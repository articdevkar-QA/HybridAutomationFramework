package org.fb.test.qa;

import java.io.IOException;

import org.base.fb.qa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RegistrationTest extends BaseTest
{
	FBLoginPage fblp;
	SoftAssert soft;
	
	
	@BeforeMethod
	public void setup()
	{
		
		initialization();
		fblp = new FBLoginPage();
     	   soft=new SoftAssert();
		
	}
	
	@Test
	public void TC002() throws IOException, InterruptedException
	{
		
		WebElement CreateNewAccountbtn= BaseTest.getDriver().findElement(By.xpath("//a[text()='Create new account']"));
	
		CreateNewAccountbtn.click();
		soft.assertEquals(BaseTest.getDriver().getTitle(), "Sign up for Facebook","No title found");
	}
	
	@AfterMethod
	public void teardown() 
	{
		soft.assertAll();
		BaseTest.getDriver().quit();
	}
	
	
}
