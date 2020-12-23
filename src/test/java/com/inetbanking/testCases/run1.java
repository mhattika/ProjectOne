package com.inetbanking.testCases;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class run1 extends BaseClass 
{
	
	@Test
	public void test1() throws IOException, InterruptedException 
	{
		log4jlogger.info("Launch Banking App");
		//driver.get(BaseURL);
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver); 
		lp.setUserName(Username);
		log4jlogger.info("Entered Username");
		lp.setPassword(Password);
		log4jlogger.info("Entered Password");
		log4jlogger.info("Before Login Screenshot");
		captureScreen(driver,"BeforeLogin");
		lp.ClickOnLogin();
		log4jlogger.info("After Login Screenshot");
		Thread.sleep(3000);
		captureScreen(driver,"AfterLogin");
		
		String title = driver.getTitle();
		
		System.out.println("title is : " + title);
		log4jlogger.info("Taking Screenshots");
		captureScreen(driver,"test1");
		
		if (title.contentEquals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log4jlogger.info("Taking Screenshots Pass");
			captureScreen(driver,"test1"); 
		}
		
		else
		{
			Assert.assertTrue(false);
			log4jlogger.info("Taking Screenshots failed");
			captureScreen(driver,"test1"); 
		}
		
		
	}

}
