package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter

{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest testlogger;
	
	/*-----------------------------
	onStart(ITestContext context)
	onFinish(ITestContext context)
	-------------------------------
	onTestStart(ITestResult result)
	onTestSuccess(ITestResult result)
	onTestFailure(ITestResult result)
	onTestSkipped(ITestResult result) 
	onTestFailedButWithinSuccessPercentage(ITestResult result) 
	----------------------------------------------------------*/
	
	@BeforeTest
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); //create html file
		 //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/testReport.html");
	        
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		//ile(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png")
		//htmlReporter = new ExtentHtmlReporter("C:/Users/Bigo/eclipse-workspace/OneProject/Reports"+repName);


			
		//\\test-output/STMExtentReport.html"
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter); //attach html file to the reports
		//extent.attachReporter(htmlReporter,extentx);
		
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","pavan");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); //title of report
		htmlReporter.config().setReportName("Functional Automation Test Report"); //name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	public void OnTestSuccess(ITestResult tr)
	{
	testlogger=extent.createTest(tr.getName()); //create new entry in report
	testlogger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); //sent the passsed info
	}
	
	
	public void OnTestFailure(ITestResult tr)
	{
	testlogger=extent.createTest(tr.getName()); //create new entry in report
	testlogger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); //sent the passsed info

	String screenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	File f = new File(screenshotPath);

	if(f.exists())
		{
		try {
			testlogger.fail("Screenshot is below:"+ testlogger.addScreenCaptureFromPath(screenshotPath));
		    }
		catch (IOException e)
		    {
		    e.printStackTrace();
		    }
		}

	}
	
	public void onTestSkipped(ITestResult tr)
	{
	testlogger=extent.createTest(tr.getName()); //create new entry in report
	testlogger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	@AfterTest
	public void onFinish(ITestContext testContext)
	{
	extent.flush();
	}

}
