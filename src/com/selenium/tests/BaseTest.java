package com.selenium.tests;

import org.testng.annotations.Test;

import com.selenium.utils.BrowserSession;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public abstract class BaseTest {
  protected WebDriver driver = null;
  
  @BeforeTest(alwaysRun = true)
  public void setUpTest(String browser) {
	  driver = BrowserSession.GetBrowserSession(browser);
	  //driver.navigate().to("https://www.google.com");
	  //driver.manage().window().maximize();
	  
  }

  @AfterTest(alwaysRun = true)
  public void tearDownTest() {
	  driver.quit();
  }

}
