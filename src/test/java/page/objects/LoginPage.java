package page.objects;

import driver.manager.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger= LogManager.getRootLogger();
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement pass;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy(css = "div[class='alert alert-danger'] p")
    private WebElement errorField;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoUsernameField(String name) {
        WaitForElement.waitUntilElementIsVisible(email);
        email.sendKeys(name);
        logger.info("Entered email");

    }

    public void typeIntoPasswordField(String password) {

        pass.sendKeys(password);
        logger.info("Entered password");
    }

    public void clickOnLoginButton() {

        submitButton.click();
        logger.info("Clicked button");
    }

    public String getMessage() {
        WaitForElement.waitUntilElementIsVisible(errorField);
        String warningText=errorField.getText();
        logger.info("Returned warning message\n",warningText);
        return warningText;
    }
}
