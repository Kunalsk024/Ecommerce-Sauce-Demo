package com.Ecommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecommerce.actionDriver.Action;
import com.Ecommerce.base.BaseTest;

public class FilterPage extends BaseTest {
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filter;

	
	public FilterPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickFilterButton() {
		Action.click(driver, filter);
	}
	
	public void filterMouseHover() {
		Action.hoverOverElement(driver, filter);
	}
	
	public boolean isOptionDisplayed(String optionText) {
	    String xpath = String.format("//select[@class='product_sort_container']/option", optionText);
	    WebElement option = driver.findElement(By.xpath(xpath));
	    return option.isDisplayed();
	}


}
