package com.qa.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
//this class contain all the common method required by test classes
public class BaseClass  {

	public static  WebDriver driver;
	public Logger logger;//logging
	public ResourceBundle rb;//java.util pkg 
	
	
	@BeforeClass(groups= {"Sanity","Master","Regression"})
	@Parameters("Browser")
	public void setup(String br) {
	
	rb=ResourceBundle.getBundle("config");//load config.properties file
	//here ResourceBundle is predefined class and getBundle is static method
		
	logger=LogManager.getLogger(this.getClass());//this is for logging this.getClass() will represent current class
	//which is executing currently because setUp method for common for all classes or tc
	//so which is currently executing it will capture that class name
	//we should always refresh the logs folder to see logs in file 
	
	//ChromeOptions options=new ChromeOptions();
	//options.setExperimentalOption("excludeSwitches",new String[] {"enable-Automation"});//this st we add becuase when i am launching
	//browser so there it is showing your chrome browser is being controlled by automation so to remove this we add st .
	
	
	//WebDriverManager.chromedriver().setup();//from selenium 4.6.0 ver we no need to add this st also
	if(br.equals("chrome")) {
		
	 driver=new ChromeDriver();
	//just we need to write only this single st it will setup the driver and launch the browser itself
	}
	else if(br.equals("edge"))
	{
	 driver=new EdgeDriver();	
	}
	else {
		driver=new FirefoxDriver();
	}
	
    driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//driver.get("https://tutorialsninja.com/demo/");
	driver.get(rb.getString("appUrl"));//accessing value from config.properties file
	
	driver.manage().window().maximize();
	}

	//generate random string
	@Test
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		//RandomStringUtils class we take from commons-lang3 dependency which have method 
		//randomAlphabetic(5)this method will  generate 5 character String 
		//it will generate random string every time 
		return (generatedString);
		
	}
	//generate randome num
	@Test
	public String randomNumber() {
		String generatedString1=RandomStringUtils.randomNumeric(10);
		//RandomStringUtils class we take from commons-lang3 dependency which have method 
		//randomAlphabetic(5)this method will  generate 5 character String 
		//it will generate random string every time 
		return (generatedString1);
		//for numeric dynamic data we use like generate otp for 4 no. than i will give here 4 
		//instead of 10
		
	}
	
	//if i want to generate alphanumeric data randomly  than but all these three method not use for generate password data
	//that we need to generate our self because there are restriction and rules for that and if i want multiple pass than i need to data driven testing
	
	@Test
	public String randomAlphaNumeric(){
		String st=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return (st+"@"+num);
		
	}
	
	@AfterClass(groups= {"Sanity","Master","Regression"})
	public void teardown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
} 
