package org.fb.test.qa;

import org.base.fb.qa.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage extends BaseTest
{
	public FBLoginPage() {

		PageFactory.initElements(BaseTest.getDriver(), this);
	}

	@FindBy(id = "email")
	static private WebElement userName;

	@FindBy(id = "pass")
	static private WebElement password;

	@FindBy(name = "login")
	static private WebElement loginBtn;

	public void login(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}
