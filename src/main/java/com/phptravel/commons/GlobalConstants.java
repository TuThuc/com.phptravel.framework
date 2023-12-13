package com.phptravel.commons;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter

public class GlobalConstants {
private static GlobalConstants globalInstance;
private GlobalConstants(){

}
public static GlobalConstants getGlobalConstants() {
    if (globalInstance == null) {
        synchronized (GlobalConstants.class) {
            if (globalInstance == null) {
                globalInstance = new GlobalConstants();
            }
        }
    }
        return globalInstance;
    }
    private final long shortTimeout = 5;
    private final long longTimeout = 30;
    private final long retryTestFail = 3;
    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String javaVersion = System.getProperty("java.version");
    private final String fileSeparator = File.separator;
    private final String devAppUrl = "https://www.phptravels.net/";
    private final String  testAppUrl = "https://demo.guru99.com/v4/";
    private final String  stagingAppUrl = "https://demo.guru99.com/v4/";
    private final String  productAppUrl = "https://demo.guru99.com/v4/";

    private final String uploadPath = getFolderSeparator("uploadFiles");
    private final String extensionPath = getFolderSeparator("extensions");
    private final String downloadPath = getFolderSeparator("downloadFiles");
    //private final String browserLogs = getFolderSeparator("browserLogs") + "FirefoxLog.log";
    private final String browserLogs = projectPath + fileSeparator + "browserLogs" + fileSeparator + "FirefoxLog.log";

    private final String browserStackUserName = "tuthuc1";
    private final String browserStackAutomateKey = "b6H118BpMUuq4mqJAGPo";
    private final String browserStackUrl = "https://" + browserStackUserName + ":" + browserStackAutomateKey + "@hub-cloud.browserstack.com/wd/hub";

    private final String sauceladUserName = "oauth-tuthuc176216-91dbe";
    private final String saucelabAutuKey = "bc18b83f-ee05-4afd-b38e-1ab69390a95c";
    private final String saucelabUrl = "https://" + sauceladUserName + ":" + saucelabAutuKey + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    private final String lambdaUserName = "oauth-tuthuc176216-91dbe";
    private final String lambdaAutoKey = "bc18b83f-ee05-4afd-b38e-1ab69390a95c";
    private final String lambdaUrk = "https://" + lambdaUserName + ":" + lambdaAutoKey + "@hub.lambdatest.com/wd/hub";

    private  String getFolderSeparator(String folderName) {
        return projectPath + fileSeparator + folderName + fileSeparator;
    }
}