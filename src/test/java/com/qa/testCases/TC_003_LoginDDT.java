package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pageObjects.HomePage;
import com.qa.pageObjects.LoginPage;
import com.qa.pageObjects.MyAccountPage;
import com.qa.testBase.BaseClass;
import com.qa.utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String pwd,String exp) {
		try {
			logger.info(" Starting TC_003_LoginDataDrivenTest ");

		
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			logger.info(" clicked on MyAccount link ");
			hp.clickLogin();
			logger.info(" clicked on Login link ");
		
			
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);//this data is getting from data provider
			logger.info(" enterd email address ");
			lp.setPassword(pwd);//
			logger.info(" enterd password ");
			lp.clickLogin();
			logger.info(" clicked on login button ");
			
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();//this method is created MyAccountPage
			
			if(exp.equals("valid")) {
				if(targetpage==true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			}
           if(exp.equals("invalid")) 
           {
             if(targetpage==true) //it means login successful than 
            	 {
            	 MyAccountPage myaccpage = new MyAccountPage(driver);
            	 myaccpage.clickLogout();
	             Assert.assertTrue(false);//if it happens then my test fails 
		
	         }else {
	           	Assert.assertTrue(true);//if it happens than my test pass because with invalid data our login should not success
	          }
            }

		
   }catch(Exception e) {
       Assert.fail();		
       }
		logger.info(" Finished TC_003_LoginDataDrivenTest");
	}

}
