package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final BrowserType BROWSER_TYPE=BrowserType.IE;
    private static WebDriver webdriver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webdriver == null) {

            webdriver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }
        return webdriver;
    }

    public static void disposeDriver() {
        webdriver.close();
        if(!BROWSER_TYPE.equals(BrowserType.FIREFOX))
        webdriver.quit();
        webdriver = null;
    }
}
