package com.cameratest.appium.definitions;

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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cameratest.appium.pom.ExtentReportsDemo;
import com.cameratest.appium.pom.TouchSwipe;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SSElementDefinition extends ExtentReportsDemo {
	
	protected AndroidDriver driver;
	public TouchSwipe ts;
	
	ExtentTest test2 = extent.createTest("Test Capture Screenshoot Element");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
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
	
	@Before
	public void init() throws MalformedURLException {
		capabilities.setCapability("appPackage", "com.dimatt.camtest");
		capabilities.setCapability("appActivity", "com.dimatt.camtest.SplashScreen");
		capabilities.setCapability("autoGrantPermissions", "true");
		
	}
	
	@Given("User menjalankan program")
	public void given() throws Throwable {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		ts = new TouchSwipe(driver);
		test2.log(Status.INFO, "Test started.");
		delay(10);
	}
	
	@When("Program akan menguji screenshoot elemen back camera")
	public void when() throws Throwable {
		screenshotElement(driver.findElement(By.id("com.dimatt.camtest:id/back_camera_preview")));
		test2.log(Status.PASS, "Take screenshot from back camera");
		delay(3);
	}
	
	@And("Program akan menguji screenshoot tombol camera")
	public void andDua() throws Throwable {
		screenshotElement(driver.findElement(By.id("com.dimatt.camtest:id/btn_capture1")));
		test2.log(Status.PASS, "Take screenshot from button camera");
		delay(3);
	}
	
	@And("Program akan menguji tekan tombol camera")
	public void andEmpat() throws Throwable {
		driver.findElement(By.id("com.dimatt.camtest:id/btn_capture1")).click();
		test2.log(Status.PASS, "Hit the camera capture key");
		delay(3);
	}
	
	@And("Program akan menguji screenshoot elemen front camera")
	public void andTiga() throws Throwable {
		screenshotElement(driver.findElement(By.id("com.dimatt.camtest:id/front_camera_preview")));
		test2.log(Status.PASS, "Take screenshot from front camera");
		delay(3);
	}
	
	@Then("Hasil akan ditampilkan")
	public void then() throws Throwable {
		test2.log(Status.INFO, "Test completed.");
		delay(2);
	}
	
	
	
}
