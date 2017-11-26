package com.selenium.utils;

public class ExtentUtilWrapper {
    public ExtentUtilWrapper()
    {
        
    }
	public void CreateExtentReport()
	{
		//For a TestSuite. Should be called from one timesetup testng method.
	}
	public void StartTest()
    {
        //For setup of test method
    }
    public void closeExtent()
    {
        //For Onetime teardown
    }
    public void EndTest()
    {
        // For TestTear down.s
    }
}
