package com.selenium.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.selenium.pages.*;
import com.selenium.steps.*;
import com.selenium.utils.BrowserSession;


public class AddToCartTests extends BaseTest  {


  private LandingPageSteps landingPageSteps;
  private ProductListingSteps productListingSteps;
  private ProductDescriptionSteps productDescriptionSteps;
  private ShoppingCartSteps shoppingCartSteps; 
  public static  String browserType;
  
  @Parameters({"browser"})
  @BeforeTest(alwaysRun = true)
  public void setUpTest(String browser) 
  {
	  browserType = browser;
	  super.setUpTest(browser);
	  landingPageSteps = new LandingPageSteps(new LandingPage(driver));
	  productListingSteps = new ProductListingSteps(new ProductListingPage(driver)); 
	  productDescriptionSteps = new ProductDescriptionSteps(new ProductDescriptionPage(driver));
	  shoppingCartSteps = new ShoppingCartSteps(new ShoppingCartPage(driver));
  }
	
  @Test(dataProvider="toBeReadFromExcelReader")
  public void VerifyProductAddedToCartTest(String productDetail) {
	  landingPageSteps.GivenIAmOnEbayLandingPage("http://www.ebay.com.au");
	  //TODO takescreenshot and extentUtil integration will move to TakeScreenShotAspect class
	  //where every method in step class will be intercepted and screenshot will be take.
	  // without cluttering test methods.
	  BrowserSession.takeScreenShot(driver, "GivenIAmOnEbayLandingPage" + browserType);
	  
	  landingPageSteps.AndISearchedTheProductWithId(productDetail);
	  BrowserSession.takeScreenShot(driver, "AndISearchedTheProductWithId" + browserType);
	  
	  productListingSteps.ThenIVerifiedTheProductIsVisible(productDetail);
	  BrowserSession.takeScreenShot(driver,"AndISearchedTheProductWithId" + browserType);
	  
	  productListingSteps.AndISelectedTheProduct(productDetail);
	  BrowserSession.takeScreenShot(driver, "AndISelectedTheProduct" + browserType);
	  
	  productDescriptionSteps.ThenIVerifiedTheDetailsForTheProduct(productDetail);
	  BrowserSession.takeScreenShot(driver, "ThenIVerifiedTheDetailsForTheProduct" + browserType);
	  
	  productDescriptionSteps.AndIAddedTheProductToCart();
	  BrowserSession.takeScreenShot(driver,"AndIAddedTheProductToCart" + browserType);
	  
	  shoppingCartSteps.ThenIVerifiedProductAddedToTheCartWithId(productDetail);
	  BrowserSession.takeScreenShot(driver, "ThenIVerifiedProductAddedToTheCartWithId" + browserType);
	  
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
