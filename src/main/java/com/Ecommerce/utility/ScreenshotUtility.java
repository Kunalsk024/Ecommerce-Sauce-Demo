package com.Ecommerce.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Ecommerce.base.BaseTest;

public class ScreenshotUtility extends BaseTest {
	
	 public static void captureScreenshot(TakesScreenshot driver, String methodName) {
	        try {
	            File source = driver.getScreenshotAs(OutputType.FILE);
	            String screenshotPath = System.getProperty("user.dir") + File.separator + "Screenshots" +
	                    File.separator + methodName + ".png";
	            FileUtils.copyFile(source, new File(screenshotPath));
	            System.out.println("Screenshot captured: " + screenshotPath);
	        } catch (Exception e) {
	            System.out.println("Exception while taking screenshot: " + e.getMessage());
	        }
	    }

}
