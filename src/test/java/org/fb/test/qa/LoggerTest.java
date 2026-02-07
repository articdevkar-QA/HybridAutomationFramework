package org.fb.test.qa;

import org.apache.logging.log4j.Logger;
import org.base.fb.qa.BaseTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.utils.fb.qa.ExtendManager;
import org.utils.fb.qa.LogUtil;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class LoggerTest extends BaseTest
{
	FBLoginPage fbpage;
	Logger log =LogUtil.getLogger(LoginTest.class);
	
	
	ExtendManager Manager;
	ExtentReports Reports;
	ExtentTest test;
	
	String result="Passed";
	@BeforeSuite
	public void setup()
	{
		Reports= ExtendManager.getInstance();
		test=Reports.createTest("Log4J Implementation ");
		
	}
	
	@Test
	public void test3()
	{
		try 
		{
			
		
		log.info("Browser is loading");
		
		test.log(Status.INFO, "Start");
		
		
		initialization();
		
		log.warn("Login page should be visible");
		
		fbpage=new FBLoginPage();
		
		log.debug("User is entering username and password");
		
		fbpage.login("Admin", "Admin@123");
		
		Assert.assertEquals("Facebook",BaseTest.getDriver().getTitle());
		test.log(Status.PASS, "Passed");
		test.log(Status.INFO, "End");
		log.info("test got passed");
		}
		catch(
				Exception e)
		{
			test.fail("Test got failed");
			result="failed";
			log.error("test got failed" +e.getMessage(),e);
			Assert.fail("Test failed due to exception");
		}
		log.info("The final result is"+result);
	}
	@AfterSuite
	public void tearDown()
	{
		BaseTest.getDriver().close();
		
	}

}
