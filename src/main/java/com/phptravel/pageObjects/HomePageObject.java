package com.phptravel.pageObjects;

import com.phptravel.PageUIs.HomePageUI;
import com.phptravel.commons.BasePage;
import com.phptravel.commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public RegisterPageObject clickToSignupLink() {
        waitForElementClickable(driver, HomePageUI.SIGN_UP_LINK);
        clickToElement(driver,HomePageUI.SIGN_UP_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public void clickToAccountLink() {
        waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
        clickToElementByJS(driver,HomePageUI.ACCOUNT_LINK);
    }
}
