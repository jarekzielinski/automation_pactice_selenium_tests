package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

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
    }

    public void typeIntoPasswordField(String password) {
        pass.sendKeys(password);
    }

    public void clickOnLoginButton() {
        submitButton.click();
    }

    public String getMessage() {
        WaitForElement.waitUntilElementIsVisible(errorField);
        return errorField.getText();
    }
}
