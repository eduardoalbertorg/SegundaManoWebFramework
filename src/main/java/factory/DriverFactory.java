package factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private WebDriver webDriver;

    public WebDriver initWebDriver() {
        if (webDriver == null) {
            
        }

        return getDriver();
    }

    public WebDriver getDriver() {
        return webDriver;
    }
}
