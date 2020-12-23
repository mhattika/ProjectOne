
/*package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.inetbanking.pageObjects.LoginPage;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.inetbanking.pageObjects.LoginPage;*/



public class TC_LogIn_1 extends BaseClass
{
	
		
	/*
	@Test
	public void loginTest() throws IOException  
	{
		driver.get(BaseURL); //launch URL
		
		//ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/test.html");
		//ExtentReports extent = new ExtentReports();
		//extent.attachReporter(reporter);
		//extlogger=extent.createTest("LoginTest");

		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(Username);
		log4jlogger.info("Entered Username");
		lp.setPassword(Password);
		log4jlogger.info("Entered passwored");
		lp.ClickOnLogin();
		
		String title= driver.getTitle();
		
		System.out.println("title is : "+title);
		System.out.println(System.getProperty("user.dir"));
		
		if (title.contentEquals("Guru99 Bank Home Page"))
			{
						Assert.assertTrue(true);
						log4jlogger.info("login test passes");
						extentlogger.log(Status.PASS,"Test is passed is" + tr.getName());
						extentlogger.log(Status.PASS,"Test is passed is"  + tr.getThrowable());
						TakesScreenshot ts= (TakesScreenshot) driver;
						File source = ts.getScreenshotAs(OutputType.FILE);
						File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tr.getName() + ".png");
						FileUtils.copyFile(source,target);
						System.out.println("Screenshot taken");
						//testlogger.addScreenCaptureFromPath(target)
						
			}
		else 
			{
			System.out.println("title not found ");
			Assert.assertTrue(false);
			log4jlogger.info("login test failed");
			extentlogger.log(Status.FAIL,"Test is Failed is" + tr.getName());
			extentlogger.log(Status.FAIL,"Test is failed is"  + tr.getThrowable());
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tr.getName() + ".png");
			FileUtils.copyFile(source,target);
			System.out.println("Screenshot taken");
			//testlogger.addScreencastFromPath(target);
			}
			
			
		
		/*@AfterMethod
		public void tearDown(ITestResult tr)
		{
		if (tr.getStatus() == ITestResult.FAILURE)
		testlogger.log(Status.FAIL,"Test is Failed is" + tr.getName());
		testlogger.log(Status.FAIL,"Test is failed + tr.getThrowable());
		captureSreen(WebDriver driver,tr.getName());
		testlogger.addScreenCaptureFromPath(target);
		} else if (tr.getStatus() == ITestResult.SKIP){
		testlogger.log(Status.SKIP,"Test Case skiped is" + tr.getName());
		} else if (tr.getStatus() == ITestResult.SUCCESS){
		testlogger.log(Status.PASS, "Test case Passed is" + tr.getName());
		}*/ 
		
		//if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		//		{
		//Assert.assertTrue(true);
		//		}
		//else
		//{
		//Assert.assertTrue(false);	
		//}
	}

}

