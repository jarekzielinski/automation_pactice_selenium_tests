package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedLoginWithoutTheRequiredNumberOfCharactersInThePasswordFieldTest extends TestBase {

    @Description("The goal of this test is to log in without the required number of characters in the password field" +
            "and check if Invalid password is displayed.")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void asUserLoginWithoutTheRequiredNumberOfCharactersInThePasswordField(){
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.
                typeIntoUsernameField("micof86894@hax55.com").
                typeIntoPasswordField("xxx").
                clickOnLoginButton();

        String message = loginPage.getMessage();
        assertTrue(message.contains("Invalid password"));
    }

}
