package com.selfmwk.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.selfmwk.utility.BrowserFactory;
import com.selfmwk.utility.ConfigDataprovider;
import com.selfmwk.utility.ExcelDataProvider;

public class BaseClass {
	
	public WebDriver driver;
	public ConfigDataprovider config;
	public ExcelDataProvider excel;
	
	
	@BeforeSuite()
	public void setUpSuite()
	{
		config=new ConfigDataprovider();
		excel=new ExcelDataProvider();
		
		
	}
	
	@BeforeClass()
	public void setUp()
	{
		driver=BrowserFactory.startApp(driver, config.getBrowser(),config.getURL());
	}
	
	@AfterClass()
	public void quit()
	{
		BrowserFactory.quitBrowser(driver);
	}

	
	
}
