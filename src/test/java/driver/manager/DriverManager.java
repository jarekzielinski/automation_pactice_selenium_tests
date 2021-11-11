package driver.manager;

import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static driver.BrowserType.FIREFOX;

public class DriverManager {

    private static WebDriver webdriver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webdriver == null) {

            webdriver = new BrowserFactory(getBrowserToRun(),getIsRemoteRun()).getBrowser();
        }
        return webdriver;
    }

    public static void disposeDriver() {
        webdriver.close();
        if(!getBrowserToRun().equals(FIREFOX))
        webdriver.quit();
        webdriver = null;
    }
}
