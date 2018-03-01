package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class matas 
{
	public static IOSDriver<MobileElement> driver;
	public static String email="test1@gmail.com";
	public static String pwd ="t";
	
	public static void withoutlog() throws InterruptedException
	{
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("menu");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Contact Us");
		el2.click();
		System.out.println("Opening Contact us");
		System.out.println("Filling Contact us form");
		MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sapphire\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[1]");
		el3.sendKeys("test user");
		driver.hideKeyboard();
		MobileElement el4 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sapphire\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
		el4.sendKeys(email);
		driver.hideKeyboard();
		MobileElement el5 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sapphire\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField[3]");
		el5.sendKeys("hi all");
		driver.hideKeyboard();
		MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("Submit");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Ok");
		el7.click();
		System.out.println("Successfully submitted query");
		Thread.sleep(10000);
	}
	
	@Test
	public static void contact() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "iPhone 7");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "10.3");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("bundleId", "com.release.gianttest");
		caps.setCapability(MobileCapabilityType.UDID, "a4b82f851de11c246bd09ea2605e85f6777ea4fd");
		caps.setCapability(MobileCapabilityType.APP, "/Users/chandiprasad/Desktop/Sapphire.app");
		driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//handle alert for new app
		try 
		{
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		withoutlog();
	}

}
