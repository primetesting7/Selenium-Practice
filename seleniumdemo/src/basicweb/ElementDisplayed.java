package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 27/04/2019.
 */
public class ElementDisplayed {
    WebDriver driver;
    // Adding code for JS
    private JavascriptExecutor js;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        // Adding code for JS
        js = (JavascriptExecutor) driver;
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void testLetsKodeIt() throws InterruptedException {
        driver.get(baseUrl);

        WebElement textBox = driver.findElement(By.id("displayed-text"));
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        hideButton.click();
        System.out.println("Clicked on hide button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        // Added code to scroll up because the element was hiding behind the top navigation menu
        // You will learn about scrolling in future lecture
        js.executeScript("window.scrollBy(0, -190);");
        WebElement showButton = driver.findElement(By.id("show-textbox"));
        showButton.click();
        System.out.println("Clicked on show button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
