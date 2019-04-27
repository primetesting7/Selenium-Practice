import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 17/04/2019.
 */
public class LoginToNopCommerce {
    private WebDriver driver;
    Utility utility ;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utility = new Utility(driver);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        /*// Find element of login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        // Click on Login Link element
        loginLink.click();*/
        utility.clickOnElement(By.linkText("Log in"));
        //Assert
        WebElement text = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertTrue("Welcome Text Not Displayed",text.isDisplayed());
//        String expectedText = "Welcome, Please Sign In!";
//        String actualText =driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
//        Assert.assertEquals("Welcome Text Not Displayed",expectedText,actualText);
    }

    @Test
    public void userShouldLoginSuccessFully(){
        // Find element of login link
        By loginLink = By.linkText("Log in");
        // Click on Login Link element
        utility.clickOnElement(loginLink);


        /*// Find Element of Email Field
        WebElement emailField = driver.findElement(By.id("Email"));
        // Enter Email address
        emailField.sendKeys("prime7@yahoo.com");*/

        utility.sendTextToElement(By.id("Email"),"prime7@yahoo.com");

        /*//Find Element of password field and Enter password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Abc123");*/

        utility.sendTextToElement(By.name("Password"),"Abc123");

        /*//Find element of login button and click on login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginBtn.click();*/
        utility.clickOnElement(By.xpath("//input[@value='Log in']"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
