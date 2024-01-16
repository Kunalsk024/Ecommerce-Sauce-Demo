//kunal kamble tsest cases


package com.Ecommerce.testCases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Ecommerce.base.BaseTest;
import com.Ecommerce.dataProvider.LoginDataProvider;
import com.Ecommerce.pageObjects.LoginPage;
import com.Ecommerce.utility.ScreenshotUtility;

public class LoginPageTest extends BaseTest {

	public void setup() {
		launchApp();
	}

	  
	    public void tearDown(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenshotUtility.captureScreenshot((TakesScreenshot) driver, result.getName());
	        }
	        quitDriver();
	    }

	    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "usernames")
	    public void valid_login(String username) throws Throwable {
	        LoginPage loginPage = new LoginPage();
	        loginPage.loginAction(username, prop.getProperty("password"));
	        Thread.sleep(3000);
	        String expectedUrl = "https://www.saucedemo.com/inventory.html";
	        String actualUrl = driver.getCurrentUrl();
	        Assert.assertEquals(actualUrl, expectedUrl, "Login unsuccessful. URL does not match the expected URL for username: " + username);
	    }

	@Test
	public void invalid_login_id() throws Throwable {
		LoginPage loginPage = new LoginPage();
		String invalidLoginId = "kunalkamble_maharshtra";
		loginPage.invlaid_login_action(invalidLoginId);
		Thread.sleep(6000);
	}
	
	@Test
	public void incorrect_login_id() throws Throwable {
	    LoginPage loginPage = new LoginPage();
	    String incorrectLoginId = "invalid_username";
	    String invalidPassword = "secret_sauce";	    
	    loginPage.login_With_Invalid_LoginId(incorrectLoginId, invalidPassword);
	    boolean isErrorDisplayed = loginPage.isErrorDisplayed();
	    Assert.assertTrue(isErrorDisplayed, "Error message is not displayed for invalid login credentials.");
	}
	
	@Test
	public void valid_password() throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.loginAction(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Login unsuccessful. URL does not match the expected URL.");
	}
	
	@Test
	public void invalid_password() throws Throwable {
		LoginPage loginPage = new LoginPage();
		String invalidPassword = "kunalkamble_maharshtra";
		loginPage.invlaid_login_password_action(invalidPassword);
		Thread.sleep(6000);		
        ScreenshotUtility.captureScreenshot((TakesScreenshot) driver, "invalid_password_test");


	}

}
