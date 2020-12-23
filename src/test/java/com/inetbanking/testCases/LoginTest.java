package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass 
{
	
	@Test
	 void setup()
	 {
	  Assert.fail();
		/*driver.get(BaseURL);
	  Assert.assertTrue(false);
	  System.out.println("Setup test");
	  log4jlogger.info("Taking Scrrenshot");*/
	 }
	 
	 @Test
	 void loginByEmail()
	 {
	  Assert.assertTrue(true);
	 	 }
	 
	 @Test(dependsOnMethods={"setup"})
	 void loginByFacebook()
	 {
	  Assert.assertTrue(true);
	 }

}
