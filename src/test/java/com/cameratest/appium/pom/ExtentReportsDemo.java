package com.cameratest.appium.pom;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {
	
	ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	
	@BeforeSuite
	public void reportSetup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		
		//membuat EXtentReports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterSuite
	public void reportTeardown() {
		extent.flush();
		
	}
	
}
