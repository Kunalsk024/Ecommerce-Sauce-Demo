package com.Ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecommerce.actionDriver.Action;
import com.Ecommerce.base.BaseTest;


public class LoginPage extends BaseTest {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtn;

	@FindBy (xpath = "//h3[@data-test='error']")
	WebElement error;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}


	public void loginAction(String uname, String pswd) throws Throwable {

		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(driver, loginBtn);		
	}

	public void invlaid_login_action(String uname) {
		Action.type(username, uname);

	}

	public void login_With_Invalid_LoginId(String uname, String pswd) throws Throwable {
		loginAction(uname, pswd);
		Thread.sleep(3000);
	}

	public boolean isErrorDisplayed() {
		return error.isDisplayed();
	}
	
	public void invlaid_login_password_action(String uname) {
		Action.type(username, uname);

	}




}
