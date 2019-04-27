import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 17/04/2019.
 */
public class RegisterOnNopCommerce {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find element of register link and click
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        //Verify the page title
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Register"));

        // Verify Register text on Register page
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Register')]")).getText();
        Assert.assertEquals(expectedText,actualText);

        // click on gender male
        WebElement gender = driver.findElement(By.id("gender-male"));
        gender.click();

        //Find firstName field and enter firstName
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("Jay");

        //Find lastName field and enter lastName
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("Vaghani");

        //Select day
        WebElement dateOfBirthDay = driver.findElement(By.name("DateOfBirthDay"));
        Select day = new Select(dateOfBirthDay);
        day.selectByIndex(9);

        //Select month
        WebElement dateOfBirthMonth = driver.findElement(By.name("DateOfBirthMonth"));
        Select month = new Select(dateOfBirthMonth);
        month.selectByVisibleText("October");

        //Select year
        WebElement dateOfBirthYear = driver.findElement(By.name("DateOfBirthYear"));
        Select year = new Select(dateOfBirthYear);
        year.selectByValue("1980");

        // Find Element of Email Field
        String email = "primetesting"+generateRandomNumber()+"@gmail.com";
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(email);

        //Find Element of password field and Enter password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Prime12345");

        //Find Element of Confirm password field and Enter password
        WebElement confirmPasswordField = driver.findElement(By.name("ConfirmPassword"));
        confirmPasswordField.sendKeys("Prime12345");

        //Find element of Register button and click on Register button
        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();

        // Verify the registration message display successfully
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Registration Message not displayed",expectedMessage, actualMessage);

        // Click on continue button
        WebElement continueBtn = driver.findElement(By.name("register-continue"));
        continueBtn.click();

        //Click on Log Out Link
        WebElement logOutLink = driver.findElement(By.linkText("Log out"));
        logOutLink.click();
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        Assert.assertTrue(loginLink.isDisplayed());

        driver.quit();

    }

    private static int generateRandomNumber() {
        return (int)(Math.random() * 5000 + 1);
    }
}
