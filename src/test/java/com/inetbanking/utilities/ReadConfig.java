package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties"); 
		try 
		{
		 FileInputStream fis = new FileInputStream(src); //open file in read mode
		 pro = new Properties();
		 pro.load(fis);
		}
		catch (Exception e)
		{
		 System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getAppURL()
	{
		String url= pro.getProperty("BaseURL");
		return url;
	}
	
	public String getUserName()
	{
		String uname= pro.getProperty("Username");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd= pro.getProperty("Password");
		return pwd;
	}
	
	public String getChromePath()
	{
		String cpath= pro.getProperty("chromepath");
		return cpath;
	}

}
