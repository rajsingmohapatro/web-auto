package com.selenium.steps;
import com.selenium.pages.*;
import com.selenium.utils.*;

public class LandingPageSteps {
		private LandingPage landingPage;
		public LandingPageSteps(LandingPage landingPageRef)
		{
			landingPage = landingPageRef;
		}
		public void GivenIAmOnEbayLandingPage(String url)
		{
			landingPage.Visit(url);
			landingPage.IsLandingPageVisible();
		}
		public void AndISearchedTheProductWithId(String productId)
		{
			landingPage.setSearchBox(productId);
			landingPage.clickSearchButton();
		}
}
