package driver_setup.browserfactory.browsers;

import configs.ConfigurationProvider;
import driver_setup.browserfactory.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import testdata.default_data.BrowserOptions;

/** This class specifically creates WebDriver for the Firefox browser and
 * implements the common methods from the BrowserFactory interface */
public class FireFoxBrowser implements BrowserFactory {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(getDriverOptions());
    }

    @Override
    public FirefoxOptions getDriverOptions() {

        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments(BrowserOptions.MAXIMIZED_BROWSER.getOptionName());
        opt.addArguments(BrowserOptions.DISABLED_INFO_BARS.getOptionName());

        if(ConfigurationProvider.getConfiguration().headless()){
            opt.addArguments(BrowserOptions.HEADLESS_MODE.getOptionName());
        }

        return opt;
    }
}
