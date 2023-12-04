package com.cameratest.appium.pom;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class Test_CameraTest extends ExtentReportsDemo {

	protected AndroidDriver driver;
	public TouchSwipe ts;

	public void delay(int input) {
		try {
			Thread.sleep(input * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void screenshotElement(WebElement input) {
		File fileSource = input.getScreenshotAs(OutputType.FILE);
		String formatName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String fileName = "D:\\appium-workspace\\CameraTest\\hasilSS\\" + formatName + ".jpg";
		File ss = new File(fileName);
		try {
			FileUtils.copyFile(fileSource, ss);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void screenshotAll() {
		File fileSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String formatName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String fileName = "D:\\appium-workspace\\CameraTest\\hasilSS\\" + formatName + ".jpg";
		File ss = new File(fileName);
		try {
			FileUtils.copyFile(fileSource, ss);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void init() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appPackage", "com.dimatt.camtest");
		capabilities.setCapability("appActivity", "com.dimatt.camtest.SplashScreen");
		capabilities.setCapability("autoGrantPermissions", "true");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		ts = new TouchSwipe(driver);
	}

	@Test(priority=1,enabled=false)
	public void test_screenshotFull() {
		ExtentTest test1 = extent.createTest("Test Capture Fullscreen");
		test1.log(Status.INFO, "Test started");
		delay(5);
		
		driver.findElement(By.id("com.dimatt.camtest:id/btn_capture1")).click();
		test1.log(Status.PASS, "Hit the camera capture key");
		delay(2);
		
		screenshotAll();
		test1.log(Status.PASS, "Take fulscreen screenshot");
		delay(2);
		
		test1.log(Status.INFO, "Test completed.");
		delay(2);
	}

	@Test(priority=2)
	public void testCameraTest() {
		ExtentTest test2 = extent.createTest("Test Capture Partial  Element");
		test2.log(Status.INFO, "Test started");
		delay(10);
		
		screenshotElement(driver.findElement(By.id("com.dimatt.camtest:id/back_camera_preview")));
		test2.log(Status.PASS, "Take screenshot from back camera");
		delay(2);
		
		screenshotElement(driver.findElement(By.id("com.dimatt.camtest:id/btn_capture1")));
		test2.log(Status.PASS, "Take screenshot from button camera");
		delay(2);
		
		driver.findElement(By.id("com.dimatt.camtest:id/btn_capture1")).click();
		test2.log(Status.PASS, "Hit the camera capture key");
		delay(2);
		
		screenshotElement(driver.findElement(By.id("com.dimatt.camtest:id/front_camera_preview")));
		test2.log(Status.PASS, "Take screenshot from front camera");
		delay(2);
		
		test2.log(Status.INFO, "Test completed.");
		delay(2);
	}
}
