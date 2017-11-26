package com.selenium.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BrowserSession {

	private static ReentrantLock lock = new ReentrantLock();
	public static WebDriver GetBrowserSession(String browserType)
	{
		
		//TODO check if selenium grid is enabled  then instantiate a remotedriver object 
		//with correct desired capabilities.
		
		WebDriver driver = null;
		lock.lock();
		if(browserType.equalsIgnoreCase("firefox"))
		{
			driver = new CustomFirefoxDriver().getDriver();
		}
		else 
		{
			//TODO Custom chromedriver class needs to be returned.
			driver =  new CustomChromeDriver().getDriver();
			
		}
		lock.unlock();
		return driver;
		//TODO if else can be extended for  Edge and various other browsers. 
	}
	
	//Can be optimized if driver can be read from Threadlocal storage set by BseTest::setUp() method. 
	public static void takeScreenShot(WebDriver driver,String fileName)
	{
		String fullFileNamePath = System.getProperty("user.dir") + "\\test-output\\screenshots\\"+fileName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fullFileNamePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
