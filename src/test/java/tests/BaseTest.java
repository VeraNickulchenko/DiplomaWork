package tests;

import driver_setup.provider.DriverProvider;
import helpers.ui.loginHandler.LoginUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page_objects.manager.PageFactoryManager;

public class BaseTest {
    private WebDriver driver;
    private LoginUtil login;

    private PageFactoryManager pageManager;

    @BeforeClass
    @Parameters(value = {"browser", "target"})
    public void setup(@Optional("chrome") String browser, @Optional("Canada") String locale){
        driver = DriverProvider.getDriver(browser);
        login = new LoginUtil(driver, locale);
        pageManager = new PageFactoryManager(driver);
    }

    @BeforeTest
    public void setupTest(){
        login.startTheSession();
    }

    @AfterTest
    public void teardownTest(){
        login.clearSession();
    }

    public PageFactoryManager getPageManager(){
        return pageManager;
    }

}
