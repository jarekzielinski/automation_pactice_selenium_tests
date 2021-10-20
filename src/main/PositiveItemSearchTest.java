import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveItemSearchTest {

    private WebDriver webdriver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chrome\\chromedriver.exe");
        webdriver=new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.navigate().to("http://automationpractice.com");

    }
    @Test
    public void PositiveSearchForItemsUsingTheSearchEngine(){
        WebElement searchField=webdriver.findElement(By.id("search_query_top"));
        searchField.sendKeys("Dress");
        WebElement submitButton=webdriver.findElement(By.name("submit_search"));
        submitButton.click();

    }
    @AfterMethod
    public void afterTest(){
        webdriver.close();
        webdriver.quit();
    }

}
