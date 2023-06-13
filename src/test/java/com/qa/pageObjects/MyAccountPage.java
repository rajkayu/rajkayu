package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

@FindBy(xpath="//h2[text()='My Account']")	//MyAccountPage Heading
WebElement msgHeading;

@FindBy(linkText="Logout")
WebElement lnkLogout;

//Action Methods 

public Boolean isMyAccountPageExists() // MyAccount Page heading display status

{
	
	try {
	return (msgHeading.isDisplayed());
	}catch(Exception e) {
	return (false); 
	}
}
public void clickLogout() {
	lnkLogout.click();
	
}	



}




