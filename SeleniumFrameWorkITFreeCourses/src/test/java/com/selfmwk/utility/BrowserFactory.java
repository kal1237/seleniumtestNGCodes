package com.selfmwk.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {
	
	public static WebDriver startApp(WebDriver driver,String browserName,String appURL)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		else
		{
			System.out.println("The browser given is not supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
