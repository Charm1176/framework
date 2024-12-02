package com.SmartWorld.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SmartWorld.testClasses.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass extends BaseClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureReport() {
		ReadConfig rf=new ReadConfig();
		String timeStamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName=" MyStoreTestReport "+timeStamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "//Reports//" + reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:","Leenovo");
		reports.setSystemInfo("Operating System","windows 11");
		reports.setSystemInfo("browser:",rf.getBrowser());
		reports.setSystemInfo("user name:","champion");
		
		//configuration to change look
		htmlReporter.config().setDocumentTitle("Extent listener Report Demo");
		htmlReporter.config().setReportName("This is my firstReport");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("Test starts "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the test method succesfully executed : "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of the Passed test case is :"+result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Name of test method failed:"+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+result.getName(), ExtentColor.RED));
		test.addScreenCaptureFromPath(takesScreenshot());
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: ", ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	configureReport();
	System.out.println("Start method invoked..");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished method invoked..");
		reports.flush();
	}

}
