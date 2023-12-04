package com.cameratest.appium.pom;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class TouchSwipe {
	
protected AndroidDriver driver;
	
	public TouchSwipe(AndroidDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void callTouch(int x, int y) {
		TouchAction touchNew = new TouchAction(driver);
		touchNew.tap(PointOption.point(x, y)).perform();
	}
}
