package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

//constructor
public HomePage(WebDriver driver) {
super(driver);//this is used for invoke super class constructor
		
}
	
//elements
@FindBy(xpath="//i[@class='fa fa-user']/following::span[1]")
WebElement lnkMyaccount;

@FindBy(xpath="//a[text()='Register']")
WebElement lnkRegister;

@FindBy(linkText="Login")
WebElement lnkLogin;

//Actions methods
public void clickMyaccount() {
	lnkMyaccount.click();
}
public void clickRegister() {
	lnkRegister.click();
}
public void clickLogin() {
	lnkLogin.click();
}

}
