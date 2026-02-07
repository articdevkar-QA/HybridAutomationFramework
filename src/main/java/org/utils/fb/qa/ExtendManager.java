package org.utils.fb.qa;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendManager 
{
	private static ExtentReports extent;
	

    public static ExtentReports getInstance() 
    {
        if (extent == null) 
        {

            ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Administrator\\eclipse-workspace\\HybridFramewokFB\\Reportings\\extend3.html");
            spark.config().setReportName("Automation Execution Report");
            spark.config().setDocumentTitle("Test Results");
            spark.config().setTimeStampFormat(("dd-mmm-yyyy HH:mm:ss"));

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Author", "QA Team");
        }
        return extent;
    }
    
    
}

/*
 * Initialize the ExtentSparkReporter with the desired file path for the report.
Create an instance of ExtentReports.
Attach the ExtentSparkReporter instance to the ExtentReports instance using the attachReporter() method.
Create a test entry using the extentReports.createTest() method, which returns an ExtentTest object.
Log the status and details for each test step using the methods provided by the ExtentTest object (e.g., info(), pass(), fail(), skip()).
Call the flush() method on the ExtentReports instance at the end of the test run to ensure all data is written to the report file. */

