package page.objects;

import driver.manager.DriverManager;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement pass;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy(css = "div[class='alert alert-danger'] ol li")
    private WebElement errorField;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    //    @Step("Type {email.name}")
    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUsernameField(String name) {
        WaitForElement.waitUntilElementIsVisible(email);
        email.sendKeys(name);
        logger.info("Entered email");
        return this;
    }

    //    @Step("Type password")
    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {

        pass.sendKeys(password);
        logger.info("Entered password");
        return this;
    }

    @Step("Click on Login Button")
    public TopMenuPage clickOnLoginButton() {

        submitButton.click();
        logger.info("Clicked button");
        return new TopMenuPage();
    }

    @Step("Getting warning message from Login Page")
    public String getMessage() {
        WaitForElement.waitUntilElementIsVisible(errorField);
        String warningText = errorField.getText();
        logger.info("Returned warning message\n", warningText);
        return warningText;
    }

}
