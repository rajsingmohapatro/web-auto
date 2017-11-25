package com.selenium.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class CustomChromeDriver  {
	private String chromeDriverPath =  "\\tools\\chromedriver\\chromedriver.exe";
	private String pathToChromePortable = "\\tools\\GoogleChromePortable64\\App\\Chrome-bin\\chrome.exe";
	public CustomChromeDriver()
	{
		
	}
	public WebDriver getDriver()
	{
		ChromeOptions options = new ChromeOptions();
		//profile.setAssumeUntrustedCertificateIssuer(false);
		//TODO
		/*if() for proxy settings
		{
			//For tests like zap proxy security etc proxy address and ports can be set here. 
		}*/
		//Other preferences like download folder to project folder etc can be set
		//FirefoxBinary binary = new FirefoxBinary(System.getProperty("user.dir")+geckDriverPath);
		
		//FirefoxOptions option = new FirefoxOptions();
		//option.setAcceptInsecureCerts(true)
		//option.setBinary(new FireFoxBinary)
		//System.setProperty("webdriver.firefox.bin",System.getProperty("user.dir") + pathToFirefoxPortable);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + chromeDriverPath);
		options.setBinary(System.getProperty("user.dir") + pathToChromePortable);
		return new ChromeDriver(options);
		
	}
}
