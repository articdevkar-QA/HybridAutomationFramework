package org.utils.fb.qa;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.base.fb.qa.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotUtils extends BaseTest
{

	private static final String SCREENSHOT_PATH ="C:\\Users\\Administrator\\eclipse-workspace\\HybridFramewokFB\\Screenshots";
    // System.getProperty("user.dir") + "/screenshots/";

public static String captureScreenshot(WebDriver driver, String testName) {

 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
 String screenshotName = testName + "_" + timestamp + ".png";

 File srcFile = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
 File destFile = new File(SCREENSHOT_PATH , screenshotName);

 try {
     Files.copy(srcFile, destFile);
 } catch (IOException e) {
     e.printStackTrace();
 }

 return destFile.getAbsolutePath();
}
}
