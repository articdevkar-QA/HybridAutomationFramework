package org.base.fb.qa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest
{
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    protected static Properties prop;

    public BaseTest() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/Application.properties"
            );
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browser = prop.getProperty("browser");
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        tlDriver.set(driver);  

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(prop.getProperty("url"));
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}
    


