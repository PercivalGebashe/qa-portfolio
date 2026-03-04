package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties = new Properties();

    public ConfigLoader(Environment env){
        String fileName = "config/" + env.name().toLowerCase() + ".properties";

        try (InputStream input =
                     getClass().getClassLoader().getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public long getLong(String key) {
        return Long.parseLong(get(key));
    }
}
