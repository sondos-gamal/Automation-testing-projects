package config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config {

    private static Properties properties;

    static {
        try {
            FileInputStream configFile = new FileInputStream("src/main/java/resources/config.properties");
            properties = new Properties();
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("URL");
    }
}
