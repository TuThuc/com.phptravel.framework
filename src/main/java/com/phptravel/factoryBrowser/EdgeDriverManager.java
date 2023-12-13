package com.phptravel.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        /*if(!IS_OS_WINDOWS || !IS_OS_MAC) {
            throw new BrowserNotSupportedException("Edge is not supported on " + System.getProperty("os.name"));
        }*/
        //WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        return  new EdgeDriver(options);
    }

}
