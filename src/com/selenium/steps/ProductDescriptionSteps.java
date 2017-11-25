package com.selenium.steps;
import com.selenium.pages.*;
public class ProductDescriptionSteps {
	private ProductDescriptionPage productDescriptionPage;
	public ProductDescriptionSteps(ProductDescriptionPage productDescriptionPageRef)
	{
		productDescriptionPage = productDescriptionPageRef;
	}
	public void ThenIVerifiedTheDetailsForTheProduct(String productId) {
		productDescriptionPage.verifyProductDescrptionPageVisible(productId);
	}
	public void AndIAddedTheProductToCart() {
		
		productDescriptionPage.clickAddToCartButton();
	}

}
