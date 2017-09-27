package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import appium.apidemo.APIDemoDriverBase;

public class ListenerUtility implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		HelperMethods.captureScreenShot(APIDemoDriverBase.driver, result, "pass");		
	}

	public void onTestFailure(ITestResult result) {
		HelperMethods.captureScreenShot(APIDemoDriverBase.driver, result, "fail");		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
