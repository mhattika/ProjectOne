package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GUImap_LogInPage 
{
	//1.Create webdriver object
	WebDriver ldriver;
	
	//2. Create Parameterised Constructor with same class name
	public GUImap_LogInPage(WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver,this);
	}
	
	//Locate web webelement by name attribute
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);	
	}
	//-------------------------------------------------
	
	//-------------------------------------------------
	@FindBy(name="passwrod")
	@CacheLookup
	WebElement txtPwd;
	public void setPwd(String pwd) {
	txtPwd.sendKeys(pwd);
	}
	
	//--------------------------------------
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btn;
	public void ClickOnLigIn()
	{
		btn.click();
	}
	
	
	
}
