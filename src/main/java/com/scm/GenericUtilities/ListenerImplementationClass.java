package com.scm.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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

public class ListenerImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"------> Testscript execution started");
		
	
	}

	public void onTestSuccess(ITestResult result) {
	String MethodName = result.getMethod().getMethodName();
	test.log(Status.PASS, MethodName+"---->Passed");
	Reporter.log(MethodName+"---->Testscript execution successful");
	}

	public void onTestFailure(ITestResult result) {
		String Failedscript = result.getMethod().getMethodName();
		
		String fs="FailedScript"+ new JavaUtility().getSystemDateAndTimeInFormat();
		EventFiringWebDriver edriver= new EventFiringWebDriver(SCMBaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File path=new File("./ScreenShot/"+fs+".png");
		String filepath = path.getAbsolutePath();
	try {
		FileUtils.copyFile(src, path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(filepath);
	test.log(Status.FAIL, result.getThrowable());
	Reporter.log("--TestScript Execution failed--");
			
			
		
	
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--Skipped");
		Reporter.log("--TestScript Execution skipped--");
		
	}

	public void onStart(ITestContext context) {
		//Configure the Report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("SCM Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser","Chrome");
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Base-URL", "https://localhost:8888");
		report.setSystemInfo("Reporter Name","Siddharth");
	}
		
		
		

	

	public void onFinish(ITestContext context) {
		//Consolidated the report
		report.flush();
	}
	
	

}
