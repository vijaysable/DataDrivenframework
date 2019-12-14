package com.vj.Utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.vj.base.TestBase;

public class GetData extends TestBase{
	//public static ExcelReader excel = null;
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		System.out.println(sheetName);
		System.out.println(excel.getColumnCount(sheetName));
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Hashtable<String,String> table = null;

		Object[][] data = new Object[rows-1][1];     //[cols]; because in arguments I can give only one argument Hashtable<String,String> data
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
			
			table = new Hashtable<String, String>(); // for every row a new hashtable
			
			for (int colNum = 0; colNum < cols; colNum++) {

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum)); // table.put(key, value) key is first row thats y 1
				// data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				data[rowNum - 2][0] = table; // data[rowNum - 2][colNum] = table; because the methods accepts only one column
			}

		}
		//System.out.println(""+data[0][0]+" "+data[0][1]+" "+data[0][2]+" "+data[0][3]+"");
		return data;
	}

	/*
	 * @DataProvider(name="dp") public Object[][] getData(Method m) { // import
	 * method from java.lang.reflect
	 * 
	 * if (excel == null) {
	 * 
	 * excel = new ExcelReader(
	 * "C:\\Users\\Hole\\Desktop\\Vijay\\Eclipse\\DataDrivernFramework\\src\\test\\resources\\excel\\Excel1.xlsx"
	 * );
	 * 
	 * }
	 * 
	 * String sheetname = m.getName(); //"OpenAccount"; int rows =
	 * excel.getRowCount("OpenAccount"); int columns =
	 * excel.getColumnCount("OpenAccount");
	 * 
	 * Object[][] data = new Object[rows-1][3];
	 * 
	 * for (int rownum = 2; rownum <= rows; rownum++) {
	 * 
	 * for (int colnum = 0; colnum < columns; colnum++) {
	 * 
	 * data[rownum - 2][colnum] = excel.getCellData(sheetname, colnum, rownum); }
	 * 
	 * }
	 * 
	 * return data; }
	 */

	public static void main(String[] args) {
		/*
		 * if there are n no. of columns we cannot write every column as a parameter
		 * in the test case
		 * here we can use the concept of hashtable
		 * hashtable contains key value pair
		 * 
		 * 
		 * 
		 */

	}

}
