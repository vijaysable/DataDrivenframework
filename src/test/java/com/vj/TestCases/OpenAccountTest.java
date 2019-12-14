package com.vj.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vj.Utilities.GetData;
import com.vj.base.TestBase;


public class OpenAccountTest extends TestBase {
	
	@Test(dataProviderClass=GetData.class,dataProvider="dp")
	public void openAccountTest(Hashtable<String,String> data) throws InterruptedException {
		
		click("openAccntBtn_CSS");
		select("userSelectBtn_CSS", data.get("customer"));
		select("currencyBtn_CSS", data.get("currency"));
		click("processBtn_XPATH");
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alertText")));
		alert.accept();
		
	}
	
	
	public static void main(String[] args) {
		

	}

}
