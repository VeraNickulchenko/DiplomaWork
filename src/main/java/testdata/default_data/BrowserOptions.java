package testdata.default_data;

public enum BrowserOptions {
    HEADLESS_MODE("-headless"), MAXIMIZED_BROWSER("--start-maximized"), DISABLED_INFO_BARS("--disable-infobars"),  CHROME_HEADLESS_MODE("--headless=new");

    private String optionName;

    BrowserOptions(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return optionName;
    }
}
