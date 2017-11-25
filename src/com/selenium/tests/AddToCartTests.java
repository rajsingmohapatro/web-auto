package com.selenium.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.selenium.pages.*;
import com.selenium.steps.*;


public class AddToCartTests extends BaseTest  {


  private LandingPageSteps landingPageSteps;
  private ProductListingSteps productListingSteps;
  private ProductDescriptionSteps productDescriptionSteps;
  private ShoppingCartSteps shoppingCartSteps; 
  
  @Parameters("browser")
  @BeforeTest(alwaysRun = true)
  public void setUpTest(String browser) 
  {
	  super.setUpTest(browser);
	  landingPageSteps = new LandingPageSteps(new LandingPage(driver));
	  productListingSteps = new ProductListingSteps(new ProductListingPage(driver)); 
	  productDescriptionSteps = new ProductDescriptionSteps(new ProductDescriptionPage(driver));
	  shoppingCartSteps = new ShoppingCartSteps(new ShoppingCartPage(driver));
  }
	
  @Test(dataProvider="toBeReadFromExcelReader")
  public void VerifyProductAddedToCartTest(String productDetail) {
	  landingPageSteps.GivenIAmOnEbayLandingPage("http://www.ebay.com.au");
	  landingPageSteps.AndISearchedTheProductWithId(productDetail);
	  productListingSteps.ThenIVerifiedTheProductIsVisible(productDetail);
	  productListingSteps.AndISelectedTheProduct(productDetail);
	  productDescriptionSteps.ThenIVerifiedTheDetailsForTheProduct(productDetail);
	  productDescriptionSteps.AndIAddedTheProductToCart();
	  shoppingCartSteps.ThenIVerifiedProductAddedToTheCartWithId(productDetail);
	  
  }
  
  @DataProvider(name="toBeReadFromExcelReader")
  public Object[][] sampleDataProvider()
  {
	  Object[][] rawData = {
			  {"SanDisk Dual Drive 16GB micro-USB OTG On-The-Go USB 2.0 Flash Drive Thumb Pen"}
	  };  
	  return rawData;
  }
}
