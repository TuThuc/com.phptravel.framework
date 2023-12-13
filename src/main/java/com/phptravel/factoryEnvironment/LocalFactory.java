package com.phptravel.factoryEnvironment;

import com.phptravel.factoryBrowser.*;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;
    private String browserName;

    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }

    public WebDriver creatDriver() {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case CHROME:
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case H_CHROME:
                driver = new HeadlessChromeDriverManager().getBrowserDriver();
                break;
            case H_FIREFOX:
                driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
                break;
            case SAFARI:
                driver = new SafariDriverManager().getBrowserDriver();
                break;
            case EDGE_CHROMIUM:
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportException(browserName);
        }

        return driver;
    }
}
