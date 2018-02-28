package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class testing 
{
	public static IOSDriver<MobileElement> driver;
	
	@BeforeClass
	
	public void appstrt() throws InterruptedException, MalformedURLException 
	{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "iPhone 7");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "10.3");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("bundleId", "com.release.gianttest");
		caps.setCapability(MobileCapabilityType.UDID, "a4b82f851de11c246bd09ea2605e85f6777ea4fd");
		//caps.setCapability(MobileCapabilityType.APP, "/Users/chandiprasad/Desktop/Sapphire.app");
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
		/*MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("searchnew");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Search\"])[1]");
		el2.sendKeys("multi");
		MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Search\"]");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeImage[@name=\"gradient-overlay\"])[1]");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("play");
		el5.click();*/
		Thread.sleep(35000);	
	}
	
	@Test(enabled=true)
	
	public void login() throws InterruptedException
	{
		//click on right side option
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("option");
		el1.click();
		
		//click on login
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Login");
		el2.click();
		
		//fill the blank text fields
		MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sapphire\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeTextField");
		el3.sendKeys("testuser123@gmail.com");
		driver.hideKeyboard();
		MobileElement el4 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sapphire\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
		el4.sendKeys("t");
		driver.hideKeyboard();
		
		//click on login
		MobileElement el5 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Login\"]");
		el5.click();
		Thread.sleep(30000);	
	}
	
	@Test(enabled=true,priority=2)
	
	public void profile() throws InterruptedException
	{
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("option");
		el1.click();
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Profile");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Sapphire\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[1]");
		el3.clear();
		el3.sendKeys("Chandi Prasad");
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Update Profile");
		el4.click();
		Thread.sleep(15000);
		MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Ok");
		el5.click();
	
		
	}
	
	@Test(enabled=true,priority=3)
	
	public void logout() throws InterruptedException 
	{
		//click on right side option
		MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("option");
		el6.click();
		el6.click();
		
		//click on logout
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("Logout");
		el7.click();
				
		//handle alert logout
		el7.click();
		
		Thread.sleep(10000);

		driver.quit();	
	}
}
