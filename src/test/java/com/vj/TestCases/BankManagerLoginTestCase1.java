package com.vj.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vj.base.TestBase;

public class BankManagerLoginTestCase1 extends TestBase {
	
	@Test
	public void bankManagerLoginTestCase1() throws IOException {
		
		//reportng
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		//verifyEquals("abc", "actualResult");
		
		Config.getProperty("Inside login test");
		click("BankManagerLoginButton_CSS");
		Config.getProperty("Logintest successsfully executed");
		
		//reportng
		Reporter.log("login test executed for reportng");
		Reporter.log("<a href=\"C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg\">\"<img width=\"42\" height=\"42\" src=\"C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg\"></a>");
		
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("AddCustomerBtn_CSS"))),"login not successfull");
	}

	public static void main(String[] args) {
		

	}

}
