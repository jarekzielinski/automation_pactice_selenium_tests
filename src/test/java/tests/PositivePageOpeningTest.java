package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.datatype.Duration;
import java.util.concurrent.TimeUnit;

public class PositivePageOpeningTest {

    private WebDriver webdriver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chrome\\chromedriver.exe");
        webdriver=new ChromeDriver();

    }

    @Test
    public void positiveOpeningOfTheWebsiteByTheUser(){
        webdriver.navigate().to("http://automationpractice.com");
    }

    @AfterMethod
    public void afterTest(){
        webdriver.close();
        webdriver.quit();
    }

}
