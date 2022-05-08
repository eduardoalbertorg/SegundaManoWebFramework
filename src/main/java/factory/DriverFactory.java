package factory;

import java.time.Duration;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigManager;
import utils.Constants;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver initWebDriver() {
        if (driver == null) {
            ConfigManager config = new ConfigManager();
            String browser = config.getBrowserString().toLowerCase();
            String userDir = config.getUserDir();
            switch (browser) {
                case Constants.CHROME_BROWSER:
                    config.setProperty(Constants.CHROME_DRIVER_PROPERTY, userDir + Constants.CHROME_DRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
                case Constants.FIREFOX_BROWSER:
                    config.setProperty(Constants.FIREFOX_DRIVER_PROPERTY, userDir + Constants.FIREFOX_DRIVER_PATH);
                    driver = new FirefoxDriver();
                    break;
                case Constants.EDGE_BROWSER:
                    config.setProperty(Constants.EDGE_DRIVER_PROPERTY, userDir + Constants.EDGE_DRIVER_PATH);
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new InvalidArgumentException(browser);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(config.getHomePageString());
        }

        return getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
