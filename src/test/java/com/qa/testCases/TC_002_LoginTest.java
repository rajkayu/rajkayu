package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pageObjects.HomePage;
import com.qa.pageObjects.LoginPage;
import com.qa.pageObjects.MyAccountPage;
import com.qa.testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void test_login() {
		try{
		logger.info("**** starting TC_002_LoginTest ****");
	
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on MyAccount link");
		hp.clickLogin();
		logger.info("clicked on login link");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("***** Providing login details ****");
		
		lp.setEmail(rb.getString("email"));//this is valid email id access from properties file
		
		lp.setPassword(rb.getString("password"));//this is valid password  access from properties file
		lp.clickLogin();
		logger.info("clicked on login button");
		
		MyAccountPage macc=new MyAccountPage(driver);
		Boolean targetpage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true);
		}
	catch(Exception e) {
			Assert.fail();
		}

	logger.info("**** finished TC_002_LoginTest ");	
	}
}
