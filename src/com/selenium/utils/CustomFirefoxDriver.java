package com.selenium.utils;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class CustomFirefoxDriver  {
	private String geckDriverPath =  "\\tools\\geckodriver-v0.19.1-win64\\geckodriver.exe";
	private String pathToFirefoxPortable = "\\tools\\FirefoxPortable\\FirefoxPortable.exe";
	public CustomFirefoxDriver()
	{
		
	}
	public WebDriver getDriver()
	{
		FirefoxProfile profile = new FirefoxProfile();
		//profile.setAssumeUntrustedCertificateIssuer(false);
		//Todo
		/*if() for proxy settings
		{
			//For tests like zap proxy security etc proxy address and ports can be set here. 
		}*/
		//Other preferences like download folder to project folder etc can be set
		//FirefoxBinary binary = new FirefoxBinary(System.getProperty("user.dir")+geckDriverPath);
		
		FirefoxOptions option = new FirefoxOptions();
		//option.setAcceptInsecureCerts(true)
		option.setBinary(System.getProperty("user.dir") + pathToFirefoxPortable);
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + geckDriverPath);
		return new FirefoxDriver();
		
	}
}
