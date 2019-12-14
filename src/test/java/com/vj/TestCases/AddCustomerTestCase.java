package com.vj.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vj.Utilities.ExcelReader;
import com.vj.Utilities.GetData;
import com.vj.base.TestBase;

public class AddCustomerTestCase extends TestBase {

	//public static ExcelReader excel = null;

	@Test(dataProviderClass = GetData.class, dataProvider = "dp")
	public void addCustomerTestCase(Hashtable<String,String> data) throws InterruptedException {
		
		if(!data.get("runmode").equals("Y")) {
			throw new SkipException("Skipping the test case containing "+data.get("firstName")+" "+data.get("lastName")+" "+data.get("postCode")+" as the run mode is NO");
		}
		
		click("AddCustomerBtn_CSS");
		type("firstNameBtn_XPATH", data.get("firstName"));
		type("lastNameBtn_XPATH", data.get("lastName"));
		type("postCodeBtn_XPATH",  data.get("postCode"));
		click("AddBtn_CSS");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alertText")));
		alert.accept();

	}

	/*
	 * @DataProvider public static Object[][] getData() {
	 * 
	 * if (excel == null) {
	 * 
	 * excel = new ExcelReader(
	 * "C:\\Users\\Hole\\Desktop\\Vijay\\Eclipse\\DataDrivernFramework\\src\\test\\resources\\excel\\Excel1.xlsx"
	 * );
	 * 
	 * }
	 * 
	 * String sheetname = "AddCustomer"; int rows = excel.getRowCount(sheetname);
	 * int column = excel.getColumnCount(sheetname);
	 * 
	 * Object[][] data = new Object[rows - 1][column];
	 * 
	 * for (int rowNum = 2; rowNum <= rows; rowNum++) {
	 * 
	 * for (int colNum = 0; colNum < column; colNum++) {
	 * 
	 * data[rowNum - 2][colNum] = excel.getCellData(sheetname, colNum, rowNum); } }
	 * return data; }
	 */

	public static void main(String[] args) {

	}

}
