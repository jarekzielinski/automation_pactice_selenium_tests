package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    Logger logger = LogManager.getRootLogger();

    @FindBy(css = "div[class='header_user_info'] a")
    private WebElement signInButton;


    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Sign In Button")
    public LoginPage clickOnSignInButton() {
        WaitForElement.waitForElementIsClickable(signInButton);
        signInButton.click();
        logger.info("Clicked signInButton");
        return new LoginPage();
    }
}
