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
 * Created by Jay Vaghani on 19/04/2019.
 */
public class ComputerMenuTestWithUtility {
    private WebDriver driver;
    private Utility utility;
    private String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utility = new Utility(driver);
    }

    @Test
    public void verifyThatUserShouldNavigateToDesktopPage(){
        By computersTab = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
        utility.mouseHoverToElement(computersTab);

        By desktopsTab = By.xpath("//ul[@class='top-menu']/li/ul/li/a[contains(text(),'Desktops')]");
        utility.mouseHoverToElementAndClick(desktopsTab);

        By deskTopsText = By.xpath("//div[@class='page-title']/h1");
        Assert.assertTrue(utility.verifyThatTextIsDisplayed(deskTopsText,"Desktops"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
