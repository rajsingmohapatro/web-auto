package com.selenium.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver driver = null;
	public BasePage(WebDriver driverRef)
	{
		driver = driverRef;
	}
	public void Visit(String virtualPath)
	{
		driver.manage().window().maximize();
		driver.navigate().to(virtualPath); 
	}
}
