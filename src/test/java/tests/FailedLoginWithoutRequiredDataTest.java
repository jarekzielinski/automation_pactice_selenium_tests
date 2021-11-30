package tests;


import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedLoginWithoutRequiredDataTest extends TestBase {


    @Description("The goal of this test is to log in without required data " +
            "and check if warning message An email address required is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void asUserLoginWithIncorrectLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.
                typeIntoUsernameField("").
                typeIntoPasswordField("").
                clickOnLoginButton();

        String message = loginPage.getMessage();
        assertTrue(message.contains("An email address required."));
    }

}
