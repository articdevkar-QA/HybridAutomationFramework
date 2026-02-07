package org.fb.test.qa;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.base.fb.qa.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.fb.qa.ExcelHelper;

public class LoginFBDatadriven extends BaseTest
{
	FBLoginPage fblp;

	LoginFBDatadriven() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		BaseTest.initialization();
		fblp = new FBLoginPage();
	}

	@Test(dataProvider = "getData")
	public void TC001_ValidLogin(String un, String pwd) {
		fblp.login(un, pwd);
	}
	
	/*@Test
	public void TC002_ValidLogin() {
		fblp.login("Abc", "Abc2");
	}*/

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {

		Object[][] obj = ExcelHelper.getExcelData("FBTestData");

		return obj;

	}

	@AfterMethod
	public void tearDown() {
		BaseTest.getDriver().quit();
	}
}
