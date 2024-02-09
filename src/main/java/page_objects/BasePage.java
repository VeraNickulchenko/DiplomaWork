package page_objects;

import helpers.ui.actionsutil.UserActionsUtil;
import helpers.ui.waitutils.WaitUtil;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @Getter
    private WebDriver driver;

    @Getter
    private WaitUtil waitAction;

    @Getter
    private UserActionsUtil userAction;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitAction = new WaitUtil(driver);
        this.userAction = new UserActionsUtil(driver);

        PageFactory.initElements(driver, this);
    }


}
