package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    
    public ConfigReader() {
        this.properties = loadProperties();
    }

    public Properties loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(getUserDir() + Constants.CONFIG_PROPERTIES_FILE_PATH);
            Properties properties = new Properties();
            properties.load(fileInputStream);  
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the config.properties file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error loading the config.properties file.");
            e.printStackTrace();
        }
        return properties;
    }

    public String getBrowserString() {
        return properties.getProperty("browser");
    }

    public String getHomePageString() {
        return properties.getProperty("baseUrl");
    }

    public String getUserDir() {
        return System.getProperty("user.dir");
    }
}
