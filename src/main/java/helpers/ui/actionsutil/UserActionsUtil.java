package helpers.ui.actionsutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/** This class is created to provide the access for ActionChains class methods and
 * provide some custom methods with use of combination of the default ones.
 * It was mostly decided to create it to avoid creating of the Actions object every time
 * it is necessary to perform some of its actions in pages classes.
 * Also, it seems to look better to have a separate class, responsible for
 * performing action chains methods then add methods just for every case to the BasePage class of PageFactory*/
public class UserActionsUtil {
    private Actions action;

    public UserActionsUtil(WebDriver driver) {
        this.action = new Actions(driver);
    }

    public void mouseOverElement(WebElement element){
        action.moveToElement(element).build().perform();
    }

    public void mouseOverAndClickChainedElement(WebElement element, WebElement chainElement){
        action.moveToElement(element)
                .moveToElement(chainElement)
                .click(chainElement)
                .build()
                .perform();
    }


}
