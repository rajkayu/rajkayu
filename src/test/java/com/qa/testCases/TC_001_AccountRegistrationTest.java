package com.qa.testCases;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pageObjects.HomePage;
import com.qa.testBase.BaseClass;
import com.qa.pageObjects.AccountRegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass{

	
 @Test(groups= {"Regression","Master"})
void test_account_Registration() {
	 
	 logger.debug("**** Application logs ****");
	 logger.info(" **** Starting TC_001_AccountRegisterTest ****");
	 try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyaccount();
	    logger.info("Clicked on Myaccount link");
		
	    hp.clickRegister();
	    logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		 logger.info("Providing the Customer Data");
		regpage.setFirstName(randomString());
		//regpage.setfistName(randomString().toUpperCase());//if i required that firstname should capital than i can write in this way
		
		
		
		regpage.setLastName(randomString());
		//regpage.setLastName(randomString().toUpperCase());//if i required that lastname should capital than i can write in this way
		
		
		regpage.setEmail(randomString()+"@gmail.com");//randomly generated email
		
		regpage.setTelephone( randomNumber());//because sendkeys does not accept no directly
		
		String password=randomAlphaNumeric();//here i am not assigning call random method directly
		//in the password field because it will genrate every time different no. so if i pass this value to 
		//setPassword  and setconfirmPassword than for both it will generate diff value so that why i stored in one var \
		//than i assign same value  to both  
		
		regpage.setPassword(password);
		
		regpage.setconfirmPassword(password);
		
		regpage.setNewsLetter();
		
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		logger.info("Validating Expected message");
		String conmsg=regpage.getConfimationmsg();
		assertEquals(conmsg,"Your Account Has Been Created!" );
		
		}catch(Exception e) {
			Assert.fail();
			 logger.info("Test Failed");
		}
		
		 logger.info("****  TC_001_AccountRegisterTest completed    ****");
		
		
	}
}
