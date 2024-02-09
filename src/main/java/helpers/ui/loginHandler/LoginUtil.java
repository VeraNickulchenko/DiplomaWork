package helpers.ui.loginHandler;

import configs.ConfigurationProvider;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

/** This class is created to handle navigation to page or some login methods.
 * Every time page is opened, it asks to select the country and to accept the cookies.
 * This class is the one responsible to handle it. Apart from that it handles driver quit
 * and login to account probably will be also added soon (it is up to reconsider) */
@AllArgsConstructor
public class LoginUtil {

    private WebDriver driver;
    private String target;


    public void startTheSession(){
        driver.navigate().to(ConfigurationProvider.getConfiguration().appUrl());
        handleCookiesNotification();
        selectLocale();
    }

    public void handleCookiesNotification(){

    }

    public void selectLocale(){

    }

    public void clearSession(){
        driver.quit();
    }
}
