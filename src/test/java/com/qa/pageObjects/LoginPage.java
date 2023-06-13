package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
//elements
@FindBy(id="input-email")
WebElement txtEmailAddress;

@FindBy(id="input-password")
WebElement  txtPassword;

@FindBy(xpath="//input[@value='Login']")
WebElement btnlogin;

//Action Methods
public void setEmail(String email) {
	 txtEmailAddress.sendKeys(email);
}

public void setPassword(String pwd) {
	 txtPassword.sendKeys(pwd);
}

public void clickLogin() {
	btnlogin.click();
}
}
