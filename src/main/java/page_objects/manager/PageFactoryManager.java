package page_objects.manager;

import org.openqa.selenium.WebDriver;
import page_objects.pages.*;

/** This class is created to provide the access for all the classes from POM pattern. */
public class PageFactoryManager {
    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public NavigatonPage getNavigationPage(){
        return new NavigatonPage(driver);
    }

    public SearchPage getSearchPage(){
        return new SearchPage(driver);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

    public SignUpPage getSignUpPage(){
        return new SignUpPage(driver);
    }
}
