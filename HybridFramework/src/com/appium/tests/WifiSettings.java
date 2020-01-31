package com.appium.tests;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Format;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.utilities.ExcelReader;
import com.appium.utilities.ExtentManager;
import com.appium.utilities.Keywords;
import com.appium.utilities.Xls_Reader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;

public class WifiSettings {

	public Keywords k;
	
	Xls_Reader r = new Xls_Reader("C:\\Users\\lenovo\\Desktop\\Workspace_Amazon\\HybridFramework\\src\\com\\appium\\config\\AppiumData.xlsx");
	//Call the ExtentManager Class's methods
	ExtentHtmlReporter  report = ExtentManager.getInstanceHtmlReporter();
	ExtentReports extent = ExtentManager.getInstanceReporter();
	
	ExtentTest logger;
	
	
	// Connect the Data provider method with Test Annotation method
	// Since the Data Provides has six columns , pass six parameters in Test
	// annotation method
	@Test(dataProvider = "testData")
	/*
	 * public void WifiSetting(String runMode, String deviceType, String
	 * platformType, String deviceName, String udid, String wifiSettingsData) throws
	 * MalformedURLException, InterruptedException {
	 */
	public void WifiSetting(Hashtable<String, String> h) throws MalformedURLException, InterruptedException {
	
		
		k = new Keywords();

		/*if (runMode.equals("NO")) {
			throw new SkipException("Skipping the Test annotation method as the runmode is set as : " + runMode);
		}*/
		
		if(h.get("RunMode").equals("NO")) {
			throw new SkipException("Skipping the Test annotation method as the runmode is set as : " + h.get("RunMode"));
		}
		
		logger = extent.createTest("Wifi Settings");

		// Set the capability to run on a Android Emulator Device
		k.CapabilityRunFile(h.get("DeviceType"), h.get("PlatformType"), h.get("DeviceName"), h.get("Udid"));

		//StepWise screenshot
		k.stepScreenshot("Preferences", "android");
		
		//Validate that the PREFERENCE text is present
		k.validationText("android", "Preference", "xpath", "Xpath_Preference_OptionElement_ValidateText", "Preference text is not present");
		//Logging with extent report
		//Markuphelper class -lets us to define the colour for passing, failure. skipping , information of test step - logging levels of extent report
		//It uses the createLabel to define the test step name and uses the ExtentColour interface to give colour coding for the logging level
		logger.log(Status.PASS, MarkupHelper.createLabel("Validation of Preference Text", ExtentColor.GREEN));
		
		
		// Tap on Preferences
		k.tapElement("android", "xpath", "Xpath_Preference_OptionElement_Tap");
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on Preference", ExtentColor.BLUE));
		

		Keywords.staticTime(5000L);
		
		
		//StepWise screenshot
		k.stepScreenshot("PreferencesDependencies", "android");
		
		//Validate for Preference Dependencies
		k.validationText("android", "3. Preference dependencies", "xpath", "Xpath_PreferenceDependencies_OptionElement_ValidateText", "Preference Dependencies text is not present");
		logger.log(Status.PASS, MarkupHelper.createLabel("Validation of Preference Dependencies Text", ExtentColor.GREEN));
		
		
		// Tap on Preferences Dependencies
		k.tapElement("android", "xpath", "Xpath_PreferenceDependencies_OptionElement_Tap");
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on Preference Dependencies", ExtentColor.BLUE));
		
		

		Keywords.staticTime(5000L);
		
		//StepWise screenshot
		k.stepScreenshot("WifiCheckbox", "android");
		
		//Validate by attribute value
		k.validationAttributeValue("android", "android:id/checkbox", "xpath", "Xpath_WifiCheckbox_Checkbox_ValidateAttributeValue", "Attrbute value for resource-id not present ", "resource-id");
		logger.log(Status.PASS, MarkupHelper.createLabel("Validation of attribute value for WIFI Checkbox", ExtentColor.GREEN));
		
		
		// Tap on the Checkbox - WIFI Checkbox
		k.tapElement("android", "xpath", "Xpath_WifiCheckbox_Checkbox_Tap");
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on WIFI Checkbox", ExtentColor.BLUE));
		

		Keywords.staticTime(5000L);
		
		//StepWise screenshot
		k.stepScreenshot("WifiSettings", "android");
		
		//Validate WIfi Setting by text
		k.validationText("android", "WiFi settings", "xpath", "Xpath_WifiSettings_OptionElement_ValidateText", "Wifi Settings text is not present");
		logger.log(Status.PASS, MarkupHelper.createLabel("Validation of WIFI Settings Text", ExtentColor.GREEN));
		
		
		// Tap on WIFI Settings
		k.tapElement("android", "xpath", "Xpath_WifiSettings_OptionElement_Tap");
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on WIFI Settings", ExtentColor.BLUE));

		Keywords.staticTime(5000L);
		
		//StepWise screenshot
		k.stepScreenshot("WifiEditBox", "android");

		// Tap and Type in WIFI Settings Edit Box
		k.tapTypeElement("android", "id", "Id_WifiEditBox_EditBox_Type", h.get("WifiData"));
		logger.log(Status.INFO, MarkupHelper.createLabel("Type on WIFI Settings Edit box", ExtentColor.BLUE));
		
		//StepWise screenshot
		k.stepScreenshot("OkButton", "android");
		
		//Validate the OK button
		k.validationText("android", "ok", "xpath", "Xpath_OkButton_Button_ValidateText", "Ok button text not present");
		logger.log(Status.PASS, MarkupHelper.createLabel("Validation of OK text in button", ExtentColor.GREEN));
		
		
		// Tap on the OK button
		k.tapElement("android", "xpath", "Xpath_OkButton_Button_Tap");
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on OK button", ExtentColor.BLUE));

		Keywords.staticTime(5000L);
		
		
		//StepWise screenshot after clicking on OK button
		k.stepScreenshot("AfterOkButton", "android");

		// Close the application
		k.closeApplication("android");

		/*
		 * // Keep the address of PREFERENCES a1 = driver.findElement(By.
		 * xpath("//android.widget.TextView[@content-desc = 'Preference']")); // Tap on
		 * Preferences t1 = new AndroidTouchAction(driver);
		 * t1.tap(tapOptions().withElement(element(a1))).perform();
		 * 
		 * Thread.sleep(5000L);
		 * 
		 * // Keep the address of PREFERENCE DEPENDENCIES a1 =
		 * driver.findElement(By.xpath("//android.widget.TextView[@index = '2']")); //
		 * Tap on Preference Dependencies t1 = new AndroidTouchAction(driver);
		 * t1.tap(tapOptions().withElement(element(a1))).perform();
		 * 
		 * Thread.sleep(5000L);
		 * 
		 * // Keep the address of Checkbox a1 = driver.findElement(By.
		 * xpath("//android.widget.CheckBox[@class = 'android.widget.CheckBox']")); //
		 * Tap on Checkbox t1 = new AndroidTouchAction(driver);
		 * t1.tap(tapOptions().withElement(element(a1))).perform();
		 * 
		 * Thread.sleep(5000L);
		 * 
		 * // Keep the address of WIFI Settings a1 = driver.findElement(By.
		 * xpath("//android.widget.TextView[@text = 'WiFi settings']")); // Tap on WIFI
		 * Settings t1 = new AndroidTouchAction(driver);
		 * t1.tap(tapOptions().withElement(element(a1))).perform();
		 * 
		 * Thread.sleep(5000L);
		 * 
		 * // Address of the Edit box a1 = driver.findElement(By.id("android:id/edit"));
		 * // Tap to make the cursor blink in edit box t1 = new
		 * AndroidTouchAction(driver);
		 * t1.tap(tapOptions().withElement(element(a1))).perform();
		 * a1.setValue("Kaushik");
		 * 
		 * Thread.sleep(5000L);
		 * 
		 * // Address of OK button a1 =
		 * driver.findElement(By.xpath("//android.widget.Button[@text = 'OK']")); // Tap
		 * on OK t1 = new AndroidTouchAction(driver);
		 * t1.tap(tapOptions().withElement(element(a1))).perform();
		 * 
		 * Thread.sleep(5000L);
		 * 
		 * //Close the Application driver.closeApp();
		 */

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		//getStatus --> int value
		//1--> success of Test annotation method
		//2 --> Failure of Test annotation method
		//3--> Skipping of Test annotation method
		//Static and Final variable --> FAILURE = 2, SUCCESS = 1, SKIP = 3
		if(result.getStatus()==ITestResult.FAILURE) {
			try {
				String var = k.FailScreenshot(result.getName(), "android");
				System.out.println(var);
				// adding screenshots to log
				logger.fail("Assertion failed", MediaEntityBuilder.createScreenCaptureFromPath(var).build());
				// adding screenshots to test
				logger.fail("Assertion failed").addScreenCaptureFromPath(var);
				//Add the test annotation method name which has failed in the log
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				//Add the exception name on assertion failure to the log
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			}catch(Throwable t) {
				System.out.println(t.getMessage());
			}
			
		}
		//Write the report in the report generated using the flush method
		extent.flush();
		
	}

	@DataProvider
	public Object[][] testData() {

		// Parameterization of data -->emulator/real, android/ios, Device name, UDID -
		// android by using adb devices /xocde for IOS
		// Parameterization of Edit boxes --> WIFI Settings Edit Box -->Sam
		// Parameterization to set the runmode --> If the run-mode is NO, the test
		// annotation method will skip . If the runmode is YES, the test annotation
		// method will run

		// Number of rows--> number of times we want to run the Test annotation method
		// Number of column is number of data that we want to parameterize
		// Want to run the test annotation method two times ; first on emulator and
		// second on real times
		// Want to parameterize

		/*
		 * Object[][] obj = new Object[2][6];
		 * 
		 * // Define the data for the first run for emulator- > First row , Six columns
		 * obj[0][0] = "YES"; // RUNMODE obj[0][1] = "emulator"; // Emulator or real
		 * time device obj[0][2] = "android"; // Platform Type obj[0][3] = "Pixel2AVD";
		 * // Device Name obj[0][4] = "emulator-5554"; // UDID obj[0][5] = "Sam"; //
		 * WIFI Settings Edit Box Data
		 * 
		 * // Define the data for the first run for Real Time Devide- > First row , Six
		 * // columns obj[1][0] = "NO"; // RUNMODE obj[1][1] = "emulator"; // Emulator
		 * or real time device obj[1][2] = "android"; // Platform Type obj[1][3] =
		 * "Pixel2AVD"; // Device Name obj[1][4] = "emulator-5554"; // UDID obj[1][5] =
		 * "Kaushik"; // WIFI Settings Edit Box Data
		 * 
		 * return obj;
		 */

		// In order to check the parameters passed in Test annotation method, we
		// implement the HASHTABLE concept
		// The hash table concept does not require us to pass "n" number of parameters
		// in Test Annotation method since there are "n" column defined in Data provider
		// In hashtable concept we can have "n" number of rows to run the test
		// annotation "n" number of times.
		// In hashtable concept , number of column is fixed to ONE.
		// Since we want to run "2" times , there has to be two HASHTABLE
		// In Hashtable concept, the KEYS should be same in all data sets.

		/*Object[][] obj = new Object[2][1];

		// First Hashtable for the first run
		Hashtable<String, String> h1 = new Hashtable<String, String>();
		h1.put("RunMode", "YES");// Runmode
		h1.put("DeviceType", "emulator"); // Device Type
		h1.put("PlatformType", "android"); // Platform Type
		h1.put("DeviceName", "Pixel2AVD"); // Device Name
		h1.put("Udid", "emulator-5554"); // UDID
		h1.put("WifiData", "Sam"); // WIFI Settings Edit Box Data

		// Second Hashtable for the second run
		Hashtable<String, String> h2 = new Hashtable<String, String>();
		h2.put("RunMode", "YES");// Runmode
		h2.put("DeviceType", "emulator"); // Device Type
		h2.put("PlatformType", "android"); // Platform Type
		h2.put("DeviceName", "Pixel2AVD"); // Device Name
		h2.put("Udid", "emulator-5554"); // UDID
		h2.put("WifiData", "Kaushik"); // WIFI Settings Edit Box Data
		
		//Put the first hashtable in first row first column
		obj[0][0]  = h1;
		
		//Put the second hashtable in second row first column
		obj[1][0]  = h2;
		
		return obj;*/
		
		//If the number of column increases the KEY-Value pair will keep on increasing.
		//How to tackle this?
		//In order to tackle this we need to have an excel concept.
		//Putting data in excel and managing it is much more convenient.
		/*We need to create an excel, create function to read the excel file and then create Hashtable through
		the function at runtime and pass it over the Data Provider.*/
		
		/*1) Create the Excel:
		a) The data filling should happen from first row onwards.
		b) The first row should be the test case name which is equal to the Class name defined in com.appium.test package. Between test cases , we should have a blank row.
		c) After the test case in excel , we need to define the column name.The column name should be the KEYS of Hashtable for a particular test case.column
		d) After column name, define the values in the CELL which is equal to the VALUE of the KEY.
		e) All data in excel should be in STRING Format.
		f) The excel should have an extension of XLSX.
		g) The excel sheet should be given a name.*/
		
		//Download Apache POI 3.6 --> https://archive.apache.org/dist/poi/release/bin/
		//We will use this version as our excel function is based on this version
		//Put the created excel (AppiumData.xlsx) in com.appium.config package.
		//Based on Apache POI 3.6 , a set of fucntion are pre-created. Put this class file containing function in com.appium.utilities package.
		/*With the function define in Xls_Reader class file, we need to create function in order to read data from 
		AppiumData.xlsx file --> create function to read the excel file and then create Hashtable through the 
		function at runtime and pass it over the Data Provider.This function read AppiumData.xlsx file need to be 
		created in com.appium.utilities package.*/
		
		return ExcelReader.readExcel("WifiSettings", r);
		
	}

}
