package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenersImplementationClass implements ITestListener 
{
	ExtentReports report;
	ExtentTest test;
public void onTestStart(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName + "--- testscript execution started");
		test=report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName + "--- testscript execution sucessfull - PASS");
		test.log(Status.PASS, MethodName+"--->passed");
		
	}

	public void onTestFailure(ITestResult result) 
	
	{
		String path=null;
		
		String MethodName = result.getMethod().getMethodName()+"-";
		//Reporter.log(MethodName + "--- TestScript Failed",true);
		
		//Step 1: Configure screenshot name
				String screenshotName = MethodName+new JavaUtility().getSystemDateInFormat();
				System.out.println(screenshotName);
				
				//Step 2: using screenshot method from webDriver Utility
				try {
					
					path=new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
					
			
			/*		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
					File src = eDriver.getScreenshotAs(OutputType.FILE);
					//String pa = Sysďtem.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
					 path = "./Screenshots/"+screenshotName+".png";
					File dst = new File(path);
					Files.copy(src, dst);*/
				} 
				catch (Throwable e)
				{
				e.printStackTrace();
				}
				test.log(Status.FAIL, MethodName+"--->failed");
				//It will capture the exception and log it in the report
				test.log(Status.FAIL, result.getThrowable());
				test.addScreenCaptureFromPath(path);
				
	}

	public void onTestSkipped(ITestResult result) {

		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName + "--- TestScript Skipped");
		test.log(Status.SKIP, MethodName);
		//It will capture the exception and log it in the report
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context)
	{
		//Execution will start here
		//configure the report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat());
	htmlReport.config().setDocumentTitle("SDET - 30 Execution Report");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("Selenium Execution Report");
	
	report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base-Browser", "Chrome");
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("Base-URL", "http://localhost:8888");
	report.setSystemInfo("Reporter Name", "Swathi G S");
	
	}

	public void onFinish(ITestContext context) 
	{
	//Consolidate all the Parameters and generate the report
		report.flush();
		
	}

	

}
