package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PositivePageOpeningTest {

    private WebDriver webdriver;


    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chrome\\chromedriver.exe");
        webdriver=new ChromeDriver();

    }


    public void positiveOpeningOfTheWebsiteByTheUser(){
        webdriver.navigate().to("http://automationpractice.com");
    }


    public void afterTest(){
        webdriver.close();
        webdriver.quit();
    }

}
