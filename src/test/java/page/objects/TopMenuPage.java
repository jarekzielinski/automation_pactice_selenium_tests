package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;

import waits.WaitForElement;

public class TopMenuPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "div[class='header_user_info'] a")
    private WebElement signInButton;


    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }
    public void clickOnSignInButton(){
        WaitForElement.waitForElementIsClickable(signInButton);
        signInButton.click();
        logger.info("Clicked signInButton");
    }
}
