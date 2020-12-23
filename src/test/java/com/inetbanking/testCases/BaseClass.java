package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

//import java.io.File;
//import java.io.IOException;

//import org.apache.commons.io.FileUtils;

//import java.io.File;
//import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
//import org.testng.ITestResult;
//import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.inetbanking.utilities.ReadConfig;
//import com.inetbanking.utilities.Reporting;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	//Reporting listener1 = new Reporting();
	public String BaseURL=readconfig.getAppURL();
	public String Username=readconfig.getUserName();
	public String Password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger log4jlogger; //Logging framework
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentRep;
	public ExtentTest extentlogger;
	public ITestResult tr;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	//public void setup()
	{
		log4jlogger = Logger.getLogger("eBanking");
		
		PropertyConfigurator.configure("log4j.properties");
		
		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		//driver= new ChromeDriver();		
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver= new ChromeDriver();		
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(BaseURL);
	}
		
	
	public static void captureScreen(WebDriver driver,String tname) throws IOException
	{
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source,target);
	System.out.println("Screenshot taken");
	} 
	
	public String randomstring()
	{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring); 
	}

	public String randomNum()
	{
	String generatedstring2=RandomStringUtils.randomNumeric(4);
	return(generatedstring2); 
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
}
