package com.inetbanking.pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
//1.Create driver object	
	WebDriver ldriver;
	
//2.Initialze class constructor same name of the class name
	public LoginPage(WebDriver rdriver) 
	{
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
	}
//3.Idendify webelements by name attribute  
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;

	//driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/u1/li[15]/a")
	@CacheLookup
	WebElement lnklogout;
	
//Action method for Username
	public void setUserName (String uname) {
		txtUserName.sendKeys(uname);
	}
	
//Action method for Password
	public void setPassword (String pwd) {
		
		txtPassword.sendKeys(pwd);	
	}
	
// Action method for login button
	public void ClickOnLogin() 
	{		
		btnLogin.click();		
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
	
	
	
}
