import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 17/04/2019.
 */
public class LoginTestWithUtilityMethod {
    private WebDriver driver;
    Utility utility;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utility = new Utility(driver);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Click on login Link
        utility.clickOnElement(By.linkText("Log in"));

        //Assert that login page displayed
        By welcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
        Assert.assertTrue("Welcome Text Not Displayed", utility.verifyThatElementIsDisplayed(welcomeText));
    }

    @Test
    public void userShouldLoginSuccessFully() {
        // Click on Login Link element
        By loginLink = By.linkText("Log in");
        utility.clickOnElement(loginLink);

        // Enter Email address
        utility.sendTextToElement(By.id("Email"), "prime7@yahoo.com");

        // Enter Password
        utility.sendTextToElement(By.name("Password"), "Abc123");

        // Click on Login button
        utility.clickOnElement(By.xpath("//input[@value='Log in']"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
