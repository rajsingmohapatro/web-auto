package com.selenium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BrowserSession {

	public static WebDriver GetBrowserSession(String browserType)
	{
		
		//TODO check if selenium grid is enabled  then instantiate a remotedriver object 
		//with correct desired capabilities.
		
		//TODO Threadlocking as in 2.53 the selenium webdriver create call was not Threadsafe in using C# API. 
		if(browserType.equalsIgnoreCase("firefox"))
		{
			return new CustomFirefoxDriver().getDriver();
		}
		else 
		{
			//TODO Custom chromedriver class needs to be returned.
			return new CustomChromeDriver().getDriver();
		}
		//TODO if else can be extended for  Edge and various other browsers. 
	}
	
	//Can be optimized if driver can be read from threadlocal storage set by BseTest::setUp() method. 
	public static void takeScreenShot(WebDriver driver,String fileName)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
