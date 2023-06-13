package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



//this class contain the constructor which is commonly required for 
//every page abject class
public class BasePage {
//driver variable 
public WebDriver driver;

//constructor
public BasePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}




}
