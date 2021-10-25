package driver.manager;

import configuration.LocalWebDriverProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver webdriver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webdriver == null) {

            webdriver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }
        return webdriver;
    }

    public static void disposeDriver() {
        webdriver.close();
        if(!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX))
        webdriver.quit();
        webdriver = null;
    }
}
