package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 27/04/2019.
 */
public class BasicActions {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
//        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
        System.out.println("Clicked on login");
        driver.findElement(By.id("user_email")).sendKeys("test@email.com");
        System.out.println("Sending keys to username field");
        driver.findElement(By.id("user_password")).sendKeys("test");
        System.out.println("Sending keys to password field");
        Thread.sleep(5000);
        driver.findElement(By.id("user_email")).clear();
        System.out.println("Clearing the username field");
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
