package com.selenium.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListingPage extends BasePage {
	private WebElement productLink;
	public ProductListingPage(WebDriver driver)
	{
		super(driver);
	}
	public void clickProductListingLink(String productId)
	{
		if(IsTheProductListed(productId))
		{
			productLink.click();
		}
	}
	public Boolean IsTheProductListed(String productId)
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		productLink = links.stream().filter(x -> x.getText().contains(productId)).findFirst().get();
		return productLink.isDisplayed();
	}
	
}
