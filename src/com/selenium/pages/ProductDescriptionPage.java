package com.selenium.pages;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDescriptionPage extends BasePage {
	public ProductDescriptionPage(WebDriver driver)
	{
		super(driver);
	}
	public void clickAddToCartButton()
	{
		driver.findElement(By.id("isCartBtn_btn")).click();
	}
	public Boolean verifyProductDescrptionPageVisible(String productId)
	{
		return driver.findElement(By.id("itemTitle")).getText().contains(productId);
	}	
}
