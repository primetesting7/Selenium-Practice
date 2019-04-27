package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jay Vaghani on 27/04/2019.
 */
public class Utility {

    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String str){
        driver.findElement(by).sendKeys(str);
    }
}
