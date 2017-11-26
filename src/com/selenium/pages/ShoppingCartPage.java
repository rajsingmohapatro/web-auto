package com.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShoppingCartPage extends BasePage {
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	public Boolean verifyProductAddedToCartWithProductId(String productId)
	{
		return driver.findElement(By.xpath("//*[@id='pageLevelMessaing']/div/div/p/span[1]/a")).getText().contains(productId);
	}
	public Boolean verifyShoppingCartPage()
	{
		return driver.findElement(By.id("PageTitle")).getText().contains("Your eBay Shopping Cart");
	}	
}

//*[@id="pageLevelMessaing"]/div/div/p/span[1]/a
//*[@id="PageTitle"]/h1