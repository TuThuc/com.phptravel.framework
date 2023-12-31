package com.phptravel.commons;

import com.phptravel.pageObjects.HomePageObject;
import com.phptravel.pageObjects.LoginPageObject;
import com.phptravel.pageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

public static HomePageObject getHomePage(WebDriver driver){
   return new HomePageObject(driver);
}
   public static LoginPageObject getLoginPage(WebDriver driver){
      return new LoginPageObject(driver);
   }
   public static RegisterPageObject getRegisterPage(WebDriver driver){
      return new RegisterPageObject(driver);
   }
}
