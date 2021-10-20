package driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver webdriver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webdriver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chrome\\chromedriver.exe");
            webdriver = new ChromeDriver();
        }
        return webdriver;
    }

    public static void disposeDriver() {
        webdriver.close();
        webdriver.quit();
        webdriver = null;
    }
}
