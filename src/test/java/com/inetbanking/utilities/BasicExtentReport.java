package com.inetbanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReport {
	
	//builds a new report using the html template 
	   public static ExtentHtmlReporter htmlReporter;
	   ExtentReports extentRep;
	    //helps to generate the logs in test report.
	    public static ExtentTest extentlogger;
	    
	    @Parameters({ "OS", "browser" })
	    @BeforeTest
	    public void OnstartReport(String OS, String browser) {
	    	// initialize the HtmlReporter
	    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
			String repName="Test-Report-"+timeStamp+".html";
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/"+repName);
	        	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extentRep = new ExtentReports();
	        extentRep.attachReporter(htmlReporter);
	         
	        //To add system or environment info by using the setSystemInfo method.
	        extentRep.setSystemInfo("OS", OS);
	        extentRep.setSystemInfo("Browser", browser);
	        
	        extentRep.setSystemInfo("Host name","localhost");
			extentRep.setSystemInfo("Environment","QA");
			extentRep.setSystemInfo("user","pavan");
			
			htmlReporter.config().setDocumentTitle("InetBanking Test Project"); //title of report
			htmlReporter.config().setReportName("Functional Automation Test Report"); //name of the report
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
			htmlReporter.config().setTheme(Theme.DARK);
	        
	        //configuration items to change the look and feel
	        //add content, manage tests etc
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	    }
	     
	    	     
	    @AfterTest
	    public void tearDown() {
	    	//to write or update test information to reporter
	        extentRep.flush();
	    }
	}



