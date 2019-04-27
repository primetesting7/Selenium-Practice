package actionsclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 27/04/2019.
 */
public class DragAndDropActions {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://jqueryui.com/droppable/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDragAndDrop() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.switchTo().frame(0);

        WebElement fromElement = driver.findElement(By.id("draggable"));
        WebElement toElement = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        // Drag and drop
//        action.dragAndDrop(fromElement, toElement).build().perform();

        // Click and hold, move to element, release, build and perform
        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }
}
