package listners;


import static base.BaseClass.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class ExtentReport implements ITestListener {
	
	static ExtentReports report;
	 ExtentTest test;
    
	@Override  
	public void onTestStart(ITestResult result) {  
		
		test = report.createTest(result.getMethod().getMethodName());
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
		test.log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
		logger.info("Test case success"); 
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result)  {  
		
		test.log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
		test.log(Status.FAIL, result.getThrowable());
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String name = result.getMethod().getMethodName() + " Failed";
		
		String screenshotPath = System.getProperty("user.dir")+
				"/Failed_Screenshots/"+name+".jpeg";
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");

		} catch (IOException e) {
			
			
			e.printStackTrace();}

		}
			
	
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
		test.log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
	}
	
	@Override 
	public void onStart(ITestContext context) {  
		
		report = ExtentSetup.setupExtentReport();
	}
	
	
	  
	@Override  
	public void onFinish(ITestContext context) {  
	
		report.flush();
	}  

	
	
}
