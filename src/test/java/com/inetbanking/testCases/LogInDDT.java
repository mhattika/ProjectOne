package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class LogInDDT extends BaseClass {
	

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{

	LoginPage lp=new LoginPage(driver);
	lp.setUserName(user);
	lp.setPassword(pwd);
	lp.ClickOnLogin();
	
	Thread.sleep(3000);

	if(isAlertPresent()==true){
	driver.switchTo().alert().accept(); //close alert
	driver.switchTo().defaultContent(); //focus on login page
	Assert.assertTrue(false);
	log4jlogger.warn("warning-login failed");
	}
	else
	{
	Assert.assertTrue(true);
	lp.clickLogout();
	Thread.sleep(3000);
	driver.switchTo().alert().accept(); //close logout alert
	driver.switchTo().defaultContent(); //focus on login page
	}
	}

	public boolean isAlertPresent(){

	try
	{
	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e){
	return false;
	}
	}

	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
	String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/TestDataSource.xlsx";

	int rownum=XLUtils.getRowCount(path,"Sheet1");
	int colcount=XLUtils.getCellCount(path,"sheet1",1);

	String logindata[][]=new String[rownum][colcount];

	for(int i=1;i<=rownum;i++)
	{
		for (int j=0; j<colcount;j++)
		{
		logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
		}
	}
	return logindata;
	}

}
