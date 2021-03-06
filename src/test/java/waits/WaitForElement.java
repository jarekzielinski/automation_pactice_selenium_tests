package waits;

import driver.manager.DriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitForElement {

    private static WebDriverWait getWebDriverWait(){

        return new WebDriverWait(DriverManager.getWebDriver(), 10);
    }
    public static void waitUntilElementIsVisible(WebElement webElement){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void  waitForElementIsClickable(WebElement webElement){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
