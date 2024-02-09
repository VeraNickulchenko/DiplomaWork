package driver_setup.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

/** This interface provides methods, that are common for all browsers to initialize the driver,
 * it is used as head of the hierarchy of specific browser classes, that implements those methods
 * for corresponding browser (e.g. Chrome, Edge, Firefox, etc) */
public interface BrowserFactory {
    public WebDriver createDriver();
    public AbstractDriverOptions<?> getDriverOptions();
}
