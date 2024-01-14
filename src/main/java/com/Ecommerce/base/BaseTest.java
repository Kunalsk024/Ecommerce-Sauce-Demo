package com.Ecommerce.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            String filePath = System.getProperty("user.dir") + File.separator + "Configuration" + File.separator
                    + "config.properties";
            FileInputStream ip = new FileInputStream(filePath);
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeWebDriver() {
        String browserName = prop.getProperty("browser").toLowerCase();
        switch (browserName) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                // Set the path to the locally stored chromedriver executable
                System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        driver.manage().window().maximize();
    }

    public static void loadApplicationUrl() {
        driver.get(prop.getProperty("url"));
    }

    public static void launchApp() {
        try {
            initializeWebDriver();
            loadApplicationUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected WebElement fluentWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @BeforeMethod
    public void setUp() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
