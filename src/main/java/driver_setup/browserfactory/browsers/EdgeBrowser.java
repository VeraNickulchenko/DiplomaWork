package driver_setup.browserfactory.browsers;

import configs.ConfigurationProvider;
import driver_setup.browserfactory.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import testdata.default_data.BrowserOptions;

/** This class specifically creates WebDriver for the Edge browser and
 * implements the common methods from the BrowserFactory interface */
public class EdgeBrowser implements BrowserFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(getDriverOptions());
    }

    @Override
    public EdgeOptions getDriverOptions() {

        EdgeOptions opt = new EdgeOptions();
        opt.addArguments(BrowserOptions.MAXIMIZED_BROWSER.getOptionName());
        opt.addArguments(BrowserOptions.DISABLED_INFO_BARS.getOptionName());

        if(ConfigurationProvider.getConfiguration().headless()){
            opt.addArguments(BrowserOptions.HEADLESS_MODE.getOptionName());
        }

        return opt;
    }
}
