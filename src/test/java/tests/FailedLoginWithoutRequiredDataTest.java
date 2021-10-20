package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopMenuPage;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class FailedLoginWithoutRequiredDataTest extends TestBase{


    @Test
    public void asUserLoginWithIncorrectLoginAndPassword(){
        TopMenuPage topMenuPage=new TopMenuPage();
        topMenuPage.clickOnSignInButon();
        LoginPage loginPage=new LoginPage();
        loginPage.typeIntoUsernameField("");
        loginPage.typeIntoPasswordField("");
        loginPage.clickOnLoginButton();
        String message=loginPage.getMessage();
        assertTrue(message.contains("error"));
    }

}
