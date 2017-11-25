package com.selenium.utils;

import org.openqa.selenium.WebDriver;

public class BrowserSession {

	public static WebDriver GetBrowserSession(String browserType)
	{
		
		//TODO check if selenium grid is enabled  then instantiate a remotedriver object 
		//with correct desired capabilities.
		if(browserType.equalsIgnoreCase("firefox"))
		{
			return new CustomFirefoxDriver().getDriver();
		}
		else 
		{
			//TODO customchromedriver class needs to be returned.
			return new CustomChromeDriver().getDriver();
		}
		//TODO if else can be extended for  Edge and various other browsers. 
	}
}
