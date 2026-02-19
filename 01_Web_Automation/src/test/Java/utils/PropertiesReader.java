package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesReader {

    private static final String BASE_PATH = System.getProperty("user.dir");
    private static final String CONFIG_PATH =
            BASE_PATH + "/configuration/config.properties";

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load config.properties from: " + CONFIG_PATH, e
            );
        }
    }

    private PropertiesReader() {
        // prevent instantiation
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
