package config;


import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static ConfigLoader configLoader;
    private static final Properties properties = new Properties();

    static {
        String envValue = System.getProperty("env");
        Environment env = Environment.from(envValue);

        configLoader = new ConfigLoader(env);

        try (InputStream input =
                     ConfigManager.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }

    }

    public static String getBaseUrl() {
        return configLoader.get("base.url");
    }

    public static String getAuthUsername() {
        return configLoader.get("auth.username");
    }

    public static String getAuthPassword() {
        return configLoader.get("auth.password");
    }

    public static long getMaxResponseTime() {
        return configLoader.getLong("max.response.time");
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }


}
