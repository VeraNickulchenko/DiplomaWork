package driver_setup.browserfactory.browsers;

import configs.ConfigurationProvider;
import driver_setup.browserfactory.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testdata.default_data.BrowserOptions;

/** This class specifically creates WebDriver for the Chrome browser and
 * implements the common methods from the BrowserFactory interface */
public class ChromeBrowser implements BrowserFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
         return new ChromeDriver(getDriverOptions());
    }

    @Override
    public ChromeOptions getDriverOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(BrowserOptions.MAXIMIZED_BROWSER.getOptionName());
        options.addArguments(BrowserOptions.DISABLED_INFO_BARS.getOptionName());

        if(ConfigurationProvider.getConfiguration().headless()){
            options.addArguments(BrowserOptions.CHROME_HEADLESS_MODE.getOptionName());
        }

        return options;
    }
}
