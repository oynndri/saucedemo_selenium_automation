package config;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (inputStream == null) {
                    throw new RuntimeException("config.properties not found in test resources classpath");
                }
                properties.load(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // এই মেথড দিয়ে আমরা যেকোনো ডেটা চাবো (যেমন: getProperty("baseUrl"))
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
