package com.vj.Utilities;

public class TestRunnable {

	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			String testCase = excel.getCellData(sheetName, "TCID", rowNum);

			if (testCase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "runmode", rowNum);

				if (runmode.equalsIgnoreCase("Y")) {
					return true;
				} else {

					return false;
				}
			}
		}return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
