package com.Ecommerce.actionDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
	
	
//	type text
	 public static void type(WebElement element, String text) {
	        element.clear();
	        element.sendKeys(text);
	    }
	 
//	 click
	 public static void click(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).click().perform();
	    }
	 
	 
//	mouse hover 
	 public static void hoverOverElement(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).perform();
	    }
	
	
}
