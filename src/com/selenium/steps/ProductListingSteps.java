package com.selenium.steps;
import org.testng.Assert;

import com.selenium.pages.*;
public class ProductListingSteps {
	private ProductListingPage productListingPage;
	public ProductListingSteps(ProductListingPage productListingPageRef)
	{
		productListingPage = productListingPageRef;
	}
	public void ThenIVerifiedTheProductIsVisible(String productId)
	{
		Assert.assertTrue(productListingPage.IsTheProductListed(productId));
	}
	public void AndISelectedTheProduct(String product)
	{
		productListingPage.clickProductListingLink(product);
	}
}
