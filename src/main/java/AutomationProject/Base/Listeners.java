package AutomationProject.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AutomationProject.resources.ExtentReporter;

public class Listeners extends TestBase implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	@Override
    public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
    }	
	@Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test case passed");
    }
	
	@Override
    public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
        try {
        	driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			extentTest.get().addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
		} catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
    public void onTestSkipped(ITestResult result) {
		
    }
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public void onFinish(ITestContext context) {
		extent.flush();
    }
	
}
