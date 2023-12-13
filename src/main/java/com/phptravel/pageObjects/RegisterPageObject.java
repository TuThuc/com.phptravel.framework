package com.phptravel.pageObjects;

import com.phptravel.PageUIs.RegisterPageUI;
import com.phptravel.commons.BasePage;
import com.phptravel.ultilities.excelultils.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName );
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName );
    }

    public void inputToPhoneTextbox(String phone) {
        waitForElementVisible(driver, RegisterPageUI.PHONE_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PHONE_TEXTBOX, phone );
    }
    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_ADDRESS_TEXTBOX, email );
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password );
    }

    public void clicktoCaptcharCheckbox() {
        waitForElementClickable(driver, RegisterPageUI.CAPTCHA_CHECKBOX);
        clickToElementByJS(driver, RegisterPageUI.CAPTCHA_CHECKBOX);

    }

    public void clicktoSignupButton() {
        waitForElementClickable(driver, RegisterPageUI.SIGNUP_BUTTON);
        clickToElement(driver, RegisterPageUI.SIGNUP_BUTTON);
    }

    public Object getFirstnameEmptyError() {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        return getElementValidationMessage(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
    }

    public RegisterPageObject saveTestResult(int row, int column) {
        ExcelUtil.rowNumber=row;
        ExcelUtil.columnNumber=column;
        return this;
    }
}
