package com.Ecommerce.testCases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Ecommerce.base.BaseTest;
import com.Ecommerce.pageObjects.FilterPage;
import com.Ecommerce.pageObjects.LoginPage;
import com.Ecommerce.utility.ScreenshotUtility;

public class FilterPageTest extends BaseTest {

	private FilterPage filterPage;

	@BeforeMethod
	public void setup() throws Throwable{
		launchApp();
		LoginPage loginPage = new LoginPage();
		loginPage.loginAction(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Login unsuccessful. URL does not match the expected URL.");
		filterPage = new FilterPage();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility.captureScreenshot((TakesScreenshot) driver, result.getName());
		}
		quitDriver();
	}

	@Test
	public void valiadte_filters() throws Throwable {

		filterPage.clickFilterButton();
		Thread.sleep(3000);
	    Assert.assertTrue(filterPage.isOptionDisplayed("Name (A to Z)"), "Option 'Name (A to Z)' is not displayed.");
	    Assert.assertTrue(filterPage.isOptionDisplayed("Name (Z to A)"), "Option 'Name (Z to A)' is not displayed.");
	    Assert.assertTrue(filterPage.isOptionDisplayed("Price (low to high)"), "Option 'Price (low to high)' is not displayed.");
	    Assert.assertTrue(filterPage.isOptionDisplayed("Price (high to low)"), "Option 'Price (high to low)' is not displayed.");
	
	}



}
