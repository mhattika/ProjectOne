package com.inetbanking.testCases;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class LogIn_Test extends BaseClass 
{
	
	@Test
	public void loginCheck()
	{
	
	log4jlogger.info("launch application");
	driver.get(BaseURL);
	LoginPage lp = new LoginPage(driver);

	lp.setUserName(Username);
	log4jlogger.info("Entered username");
	lp.setPassword(Password);
	log4jlogger.info("Entered password");
	lp.ClickOnLogin();
	
	String title=driver.getTitle();
	
	System.out.println("Title is : "+title);
	
	
	
	if (title.contentEquals("Guru99 Bank Home Page"))
	{
		Assert.assertTrue(true);
	}
	
	else	{
	   Assert.assertTrue(false);
	}
	
	}
	

}
