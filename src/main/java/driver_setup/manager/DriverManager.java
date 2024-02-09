package driver_setup.manager;

import driver_setup.browserfactory.browsers.ChromeBrowser;
import driver_setup.browserfactory.browsers.EdgeBrowser;
import driver_setup.browserfactory.browsers.FireFoxBrowser;
import org.openqa.selenium.WebDriver;

/** This class creates WebDriver for specific browser, which name is provided as String to
 * its one and only static method. It uses specific browser class for each browser type to
 * customize and create the driver for this exact browser */
public class DriverManager {

    public static WebDriver createDriver(String browserName){

        switch (browserName.toLowerCase()){
            case "chrome":
                return new ChromeBrowser().createDriver();

            case "edge":
                return new EdgeBrowser().createDriver();

            case "firefox":
                return new FireFoxBrowser().createDriver();

        }

        throw new IllegalArgumentException("The browser: " + browserName + " is not supported! Please" +
                " provide the other browser");
    }
}
