package com.cameratest.appium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 	
features = "src/test/resources/TestSSElement.feature",
glue = "com.cameratest.appium.definitions")
public class CucumberCamtestRunner extends AbstractTestNGCucumberTests {

}
