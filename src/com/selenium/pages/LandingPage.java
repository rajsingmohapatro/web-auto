package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage {
	public LandingPage(WebDriver driver)
	{
		super(driver);
	}
	
	public WebElement getSearchBox()
	{
		return driver.findElement(By.id("gh-ac"));
	}
	public void setSearchBox(String product)
	{
		getSearchBox().sendKeys(product);
	}
	public Boolean IsLandingPageVisible()
	{	
		return getSearchBox().isDisplayed();
	}
	public WebElement getSearchButton()
	{
		return driver.findElement(By.id("gh-btn"));
	}
	public void clickSearchButton()
	{
		getSearchButton().click();
	}
}
