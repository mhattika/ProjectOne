package com.inetbanking.testCases;

//import java.io.File;
import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
//import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCase2 extends BaseClass 
{

	
	@Parameters({ "OS", "browser" })
	@Test
	public void launch(String OS, String browser) throws IOException
	{
		driver.get(BaseURL);
		//Assert.assertTrue(true); // log result to log
		log4jlogger.info("Taking Scrrenshot");
		captureScreen(driver,"Test1");
		
		extentlogger=extentRep.createTest("First test"); //create new entry in report
		extentlogger.log(Status.PASS,"Title verified");
		extentlogger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		extentRep.flush();
		extentlogger.pass("details",MediaEntityBuilder.createScreenCaptureFromPath("C:/Users/Bigo/eclipse-workspace/OneProject/Screenshots/mahesh.png").build());
		//extentRep.flush();
		
		
		//extentRep.flush();
		
		ExtentTest extentlogger2 = extentRep.createTest("LogOff test");
		extentlogger2.log(Status.FAIL,"Title verified");
		//extentRep.flush();
		extentlogger.pass("details",MediaEntityBuilder.createScreenCaptureFromPath("C:/Users/Bigo/eclipse-workspace/OneProject/Screenshots/mahesh.png").build());
		//extentRep.flush();
	}
	
	/*@AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extentRep.flush();
    } */
		
		
}
