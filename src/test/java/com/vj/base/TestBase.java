package com.vj.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.model.Test;
import com.vj.Utilities.CaptureScreenshot;
import com.vj.Utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			"C:\\Users\\Hole\\Desktop\\Vijay\\Eclipse\\DataDrivernFramework\\src\\test\\resources\\excel\\Excel1.xlsx");
	public static WebDriverWait wait;

	@BeforeSuite
	public void setup() throws IOException {

		if (driver == null) {

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			Config.load(fis);
			log.debug("Config file loaded");

			fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\properties\\ObjectRepositories.properties");
			OR.load(fis);
			log.debug("OR file loaded");
		}

		if (Config.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.firefox.driver",
					"C:\\Users\\Hole\\Desktop\\Vijay\\Selenium Grid\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.debug("Firefox Launched");

		} else if (Config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Hole\\Desktop\\Vijay\\Selenium Grid\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Launched");

		}

		driver.get(Config.getProperty("testsiteurl"));
		log.debug("Navigated to: " + Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
	}

	//@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
		log.debug("LoginTest Executed");
	}

	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void click(String locator) {

		// making it more dynamic

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}

	}
	
	public static void verifyEquals(String expectedResult, String actualResult) throws IOException {
		
		try {
			Assert.assertEquals(actualResult, expectedResult);
			
		} catch (Exception e) {
			
			// for reportng
			org.testng.Reporter.log("<br>"+"Verification of failure: "+e.getMessage()+"<br>");
			CaptureScreenshot cap = new CaptureScreenshot();
			cap.capscreen();
			org.testng.Reporter.log("<br>");
			org.testng.Reporter.log("<br>");
			
			//for extent reports
			
			
		}
		
	}
	
	// for dropdowns
	static WebElement dropdown;
	public void select(String locator, String value) {
		
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	public static void main(String[] args) {

		/*
		 * a base class for all our test cases act as a superclass or parentclass for
		 * all our testcases we will be initializing - webdriver - done properties -
		 * done logs - log4j , .log extentreports DB excel mail ReportNG ExtentReports
		 * 
		 * 
		 */

	}

}
