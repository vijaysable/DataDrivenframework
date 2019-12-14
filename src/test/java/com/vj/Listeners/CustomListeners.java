package com.vj.Listeners;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.vj.Utilities.CaptureScreenshot;
import com.vj.Utilities.TestRunnable;
import com.vj.base.TestBase;
import com.vj.rough.TestHostAddress;

public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ISuite suite) {
		
		TestHostAddress hostMail = new TestHostAddress();
		try {
			hostMail.host();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

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
