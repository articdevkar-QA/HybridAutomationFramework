package org.fb.test.qa;

import org.base.fb.qa.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utils.fb.qa.ScreenshotUtils;




public class LoginTest extends BaseTest
{
	
	FBLoginPage fblp;
	SoftAssert soft;
	
		@BeforeMethod
	public void setUp() 
	{
		BaseTest.initialization();
		fblp = new FBLoginPage();
	    soft=new SoftAssert();
   
	}
	
	@Test
	public void TC001_FBLoginTest()
	{
		
		fblp.login("Admin", "Admin@123");
		ScreenshotUtils.captureScreenshot(BaseTest.getDriver(), "loginTest");
		
		//soft.assertEquals(BaseTest.getDriver().getTitle(), "Facebook","No Tiltle found");
		//soft.assertAll();
	}
@AfterMethod
	public void teardown() throws InterruptedException 
	{
	Thread.sleep(4000);
	BaseTest.getDriver().close();
	}

}
