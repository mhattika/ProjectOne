package com.inetbanking.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	
		public ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		public ExtentTest logger;
	
	     public void OnStart(ITestContext testContext) {
	    	 
	    	 System.out.println("*********TEST RUN START***********"); 
	    	
	    	 htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");//specify location of the report
	    	 htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
	    	  
	    	  extent=new ExtentReports();
	    	  
	    	  extent.attachReporter(htmlReporter);
	    	  extent.setSystemInfo("Host name","localhost");
	    	  extent.setSystemInfo("Environemnt","QA");
	    	  extent.setSystemInfo("user","pavan");
	    	  
	    	  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
	    	  htmlReporter.config().setReportName("Functional Testing"); // name of the report
	    	  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	    	  htmlReporter.config().setTheme(Theme.STANDARD);
	     }
	
		 public void onTestStart(ITestResult tr) {
		  System.out.println("test is started");
		  
		  	  
		 }

		 public void onTestSuccess(ITestResult tr) {
		  System.out.println(" test is passed");
		  
		  logger=extent.createTest("LogInTest"); // create new entry in th report
		  logger.log(Status.PASS,MarkupHelper.createLabel("LogInTest",ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		 }

		 public void onTestFailure(ITestResult tr) {
		  System.out.println(" test is failed");
		  logger=extent.createTest("LogInTest"); // create new entry in th report
		  logger.log(Status.FAIL,MarkupHelper.createLabel("LogInTest",ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+"LogInTest"+".png";
		  try {
		   logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		  } catch (IOException e) {
		    e.printStackTrace();
		  } 
		 }
		 
		 
		 public void onTestSkipped(ITestResult tr) {
		  System.out.println(" test is skipped");
		  
		  logger=extent.createTest("LogInTest"); // create new entry in th report
		  logger.log(Status.SKIP,MarkupHelper.createLabel("LogInTest",ExtentColor.ORANGE));
		 }
		 
		 public void onFinish(ITestContext testContext)
		 {
			 System.out.println("*********TEST RUN END************");
			 //extent.flush();
		 }


}
