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
public class RegistrationTestWithUtilityMethod {
    private WebDriver driver;
    private Utility utility;
    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utility = new Utility(driver);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // Find element of register link and click
        utility.clickOnElement(By.linkText("Register"));

        //Verify the page title
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Register"));

        // Verify Register text on Register page
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Register')]")).getText();
        Assert.assertEquals(expectedText, actualText);

        // click on gender male
        utility.clickOnElement(By.id("gender-male"));

        //Find firstName field and enter firstName
        utility.sendTextToElement(By.id("FirstName"), "Jay");

        //Find lastName field and enter lastName
        utility.sendTextToElement(By.id("LastName"), "Vaghani");

        //Select day
        utility.selectByIndexFromDropDown(By.name("DateOfBirthDay"), 9);

        //Select month
        By dob = By.name("DateOfBirthMonth");
        utility.selectByVisibleTextFromDropDown(dob, "December");

        //Select year
        utility.selectByValueFromDropDown(By.name("DateOfBirthYear"), "1980");

        // Find Element of Email Field
        String email = "primetesting" + utility.generateRandomNumber() + "@gmail.com";
        utility.sendTextToElement(By.id("Email"), email);

        //Find Element of password field and Enter password
        utility.sendTextToElement(By.name("Password"), "Prime12345");

        //Find Element of Confirm password field and Enter password
        utility.sendTextToElement(By.name("ConfirmPassword"), "Prime12345");

        //Find element of Register button and click on Register button
        utility.clickOnElement(By.id("register-button"));

        // Verify the registration message display successfully
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Registration Message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
