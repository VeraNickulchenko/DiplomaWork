package configs;

import org.aeonbits.owner.Config;

/** This class is created to define methods that allow to access the value of corresponding key from the
/** resources/execution_config/test_run.properties file and to use them easily inside the project
/** with help of the Owner library */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:test_run.properties"
})
public interface Configuration extends Config {

    @Key("target")
    String target();

    @Key("app_url")
    String appUrl();

    @Key("default-browser")
    String defaultBrowser();

    @Key("add_cookies")
    boolean addCookies();

    @Key("headless")
    boolean headless();


}
