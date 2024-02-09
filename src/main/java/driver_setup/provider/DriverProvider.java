package driver_setup.provider;

import driver_setup.manager.DriverManager;
import org.openqa.selenium.WebDriver;

/** This class is Singleton class, that is responsible for providing
 * one and only WebDriver instance for the whole project.
 * It has one static method, that returns WebDriver specific to corresponding browser,
 * basing on the browser name passed to it as a parameter or creates it if the driver
 * does not exist yet */
public class DriverProvider {
    private static WebDriver driver = null;

    private DriverProvider(){

    }

    public static WebDriver getDriver(String browserName){

        if(driver == null){
            driver = DriverManager.createDriver(browserName);
        }

        return driver;
    }


}
