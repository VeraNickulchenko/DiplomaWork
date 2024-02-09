package helpers.ui.waitutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** This class is created to provide the access for WebDriverWait class methods.
 * It was mostly decided to create it since it seems to look better to have a separate class, responsible for
 * performing waits  then add methods just for every case to the BasePage class of Page Factory*/
public class WaitUtil {
    private WebDriver driver;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(WebElement element, Duration timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }
}
