package com.vj.Listeners;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.vj.Utilities.CaptureScreenshot;
import com.vj.Utilities.TestRunnable;
import com.vj.base.TestBase;

public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {

	public void onTestStart(ITestResult result) {
		// runmodes=Y or throw newskipexception
		if(!TestRunnable.isTestRunnable(result.getName().toUpperCase(), excel)) {
			throw new SkipException("Skipping the test "+result.getName().toUpperCase()+" as the runmode is No");
		}
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		CaptureScreenshot cap = new CaptureScreenshot();
		try {
			cap.capscreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	public static void main(String[] args) {
		

	}

}
