package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.utilities.XLUtils;

@Test
public class GetdTestData {
	
	String [][] getData() throws IOException
	{
	String path="C:/TestDataSource/TestDataSource.xlsx";

	int rownum=XLUtils.getRowCount(path,"Sheet1");
	int colcount=XLUtils.getCellCount(path,"sheet1",1);

	String logindata[][]=new String[rownum][colcount];

	for(int i=1;i<=rownum;i++)
	{
		for (int j=0; j<colcount;j++)
		{
		logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
		System.out.println(logindata[i-1][j]);
		}
	}
	return logindata;
	}

}
