package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    @FindBy(css = "div[class='header_user_info'] a")
    private WebElement signInButton;


    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }
    public void clickOnSignInButton(){
        WaitForElement.waitForElementIsClickable(signInButton);
        signInButton.click();
    }
}
