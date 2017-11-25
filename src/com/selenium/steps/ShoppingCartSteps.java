package com.selenium.steps;
import org.testng.Assert;

import com.selenium.pages.*;
public class ShoppingCartSteps {
	private ShoppingCartPage shoppingCartPage;
	public ShoppingCartSteps(ShoppingCartPage shoppingCartPageRef)
	{
		shoppingCartPage = shoppingCartPageRef;
	}
	public void ThenIVerifiedProductAddedToTheCartWithId(String productId) {
		Assert.assertTrue(shoppingCartPage.verifyShoppingCartPage());
		Assert.assertTrue(shoppingCartPage.verifyProductAddedToCartWithProductId(productId));
	}
}
