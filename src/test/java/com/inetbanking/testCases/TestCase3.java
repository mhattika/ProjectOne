package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestCase3 extends BaseClass {
	
	@Parameters({ "OS", "browser" })
	@Test
	public void launch2(String OS, String browser) throws IOException
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

}
