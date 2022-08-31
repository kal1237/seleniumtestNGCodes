package com.selfmwk.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataprovider {
	
	Properties prop;
	public ConfigDataprovider()
	{
		
		File src=new File("./Config/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to load config file"+e.getMessage());
		}
		
	}

	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getURL()
	{
		return prop.getProperty("qaURL");
	}
	
}
