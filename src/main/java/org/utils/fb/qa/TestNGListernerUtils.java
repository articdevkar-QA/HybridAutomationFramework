package org.utils.fb.qa;



import org.apache.logging.log4j.Logger;
import org.base.fb.qa.BaseTest;
import org.testng.ITestContext;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListernerUtils implements ITestListener

{
	private static ExtentReports extent = ExtendManager.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	Logger log = LogUtil.getLogger(TestNGListernerUtils.class);
	
	public void onStart(ITestContext context)
	{
		log.info("Test Suite Started : " + context.getName());
	}
	
	public void onTestStart(ITestResult result)
	{
		log.info("Test execution is getting start");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		test.info("Test Execution has been Started");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
	    
		log.info("Test Passed");
		extentTest.get().pass("Test has been Passed");
	 }
	
	public void onTestSkipped(ITestResult result) 
	{
		log.warn("Test Debugg");
		extentTest.get().skip("Test has been Skipped");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		log.info("Test failed");
		log.debug("Test Debugg");
		 
		String screenshotPath = ScreenshotUtils.captureScreenshot(BaseTest.getDriver(), result.getMethod().getMethodName());

		extentTest.get().fail(result.getThrowable());
		extentTest.get().addScreenCaptureFromPath(screenshotPath);
	  }
	
	public void onFinish(ITestContext context) 
	{
	
		log.info("Test Finshed");
		extent.flush();
	 }

}
