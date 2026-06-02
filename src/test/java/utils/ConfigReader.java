package utils;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {

            properties = new Properties();

            properties.load(
                    new InputStreamReader(
                            new FileInputStream(
                                    "src/test/resources/config.properties"
                            ),
                            StandardCharsets.UTF_8
                    )
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}