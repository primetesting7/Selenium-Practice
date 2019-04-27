package waittypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jay Vaghani on 26/04/2019.
 */
public class ExplicitWaitDemo {
    private WebDriver driver;
    private String baseUrl = "https://letskodeit.teachable.com/pages/practice";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        // Maximize the browser's window
        driver.manage().window().maximize();
    }

    @Test()
    public void test() throws Exception {
        driver.get(baseUrl);
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        emailField.sendKeys("test");

        driver.findElement(By.id("user_email")).sendKeys("test");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}








