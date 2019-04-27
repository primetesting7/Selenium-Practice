import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jay Vaghani on 13/04/2019.
 */
public class ChromeDriverDemo {
    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "https://www.brightlittlestars.com/";
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions action = new Actions(driver);
        WebElement ourNurseries = driver.findElement(By.xpath("//li[@id='menu-item-2804']"));
        action.moveToElement(ourNurseries).build().perform();

        List<WebElement> ourNurseriesList = driver.findElements(By.xpath("//li[@id='menu-item-2804']/ul/li/a"));
        selectTownOfNursery(ourNurseriesList, "Stanmore");
    }


    public static void selectTownOfNursery(List<WebElement> elementList, String town){
        for (WebElement townElement :elementList ) {
            try {
                if (townElement.getText().equalsIgnoreCase(town)){
                    townElement.click();
                }
            }catch (StaleElementReferenceException ex){
                ex.getMessage();
            }
        }
    }
}
