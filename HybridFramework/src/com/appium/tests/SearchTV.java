package com.appium.tests;

import java.net.MalformedURLException;
import java.util.Hashtable;

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

public class SearchTV {

	public Keywords k;

	//Define the path of Excel file for reading data
	Xls_Reader r = new Xls_Reader("C:\\Users\\lenovo\\Desktop\\Workspace_Amazon\\HybridFramework\\src\\com\\appium\\config\\AppiumData.xlsx");
	
	// Call the ExtentManager Class's methods
	ExtentHtmlReporter report = ExtentManager.getInstanceHtmlReporter();
	ExtentReports extent = ExtentManager.getInstanceReporter();
	
	//Object of ExtentTest class which acts as logger
	ExtentTest logger;

	// Connect the Data provider method with Test Annotation method
	// Since the Data Provides has six columns , pass six parameters in Test
	// annotation method
	@Test(dataProvider = "testData")
	public void TC_SearchTV(Hashtable<String, String> h) throws MalformedURLException, InterruptedException {

		//Object of Keywords class to initialize the constructor
		k = new Keywords();
		
		//To skip the Test annotation method if the RUNMODE is set to NO in excel sheet
		if (h.get("RunMode").equals("NO")) {
			throw new SkipException("Skipping the Test annotation method as the runmode is set as : " + h.get("RunMode"));
		}

		//Create the Test case for Extent Report 
		logger = extent.createTest("SearchTV");

		// Set the capability to run on a Android Emulator Device with PAckage and Activity
		k.CapabilityRunFileAndoidPackage(h.get("DeviceName"), h.get("PlatformType"), h.get("Package"), h.get("Activity"));

		// StepWise screenshot
		k.stepScreenshot("Skip Sign In", "android");
		
		Keywords.staticTime(10000L);

		// Validate that the `Skip Sign In text is present in the Skip sign in button
		k.validationText("android", "Skip sign in", "xpath", "Xpath_Skipsignin_Button_ValidateText","Skip sign in text is not present");
		
		// Logging with extent report
		// Markuphelper class -lets us to define the colour for passing, failure.
		// skipping , information of test step - logging levels of extent report
		// It uses the createLabel to define the test step name and uses the
		// ExtentColour interface to give colour coding for the logging level
		logger.log(Status.PASS, MarkupHelper.createLabel("Validation of Skip Sign In Text", ExtentColor.GREEN));

		// Tap on Skip sign in Button
		k.tapElement("android", "xpath", "Xpath_Skipsignin_Button_Tap");
		
		//Info Level logging for Extent Report
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on Skip sign in", ExtentColor.BLUE));

		Keywords.staticTime(10000L);

		// StepWise screenshot
		k.stepScreenshot("Search Landing Page", "android");

		// Validate for Search Edit box
		k.validationText("android", "Search", "xpath","Xpath_Search_EditBox_ValidateText","Search text is not present in edit box");
		logger.log(Status.PASS,MarkupHelper.createLabel("Validation of Search Text in edit box", ExtentColor.GREEN));

		// Tap on Search edit box
		k.tapElement("android", "xpath", "Xpath_Search_EditBox_Type");
		
		Keywords.staticTime(10000L);
		
		// Type on Search edit box
		k.tapTypeElement("android", "xpath", "Xpath_Search_EditBox_Type", "65 inch TV");
		
		//Click on the enter button after typing 65 inch TV
		k.androidKeyPress(66);
		
		// StepWise screenshot
		k.stepScreenshot("Search Items for 65 inch TV", "android");
		
		//Info Level logging for Extent Report
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on Preference Dependencies", ExtentColor.BLUE));

		Keywords.staticTime(10000L);
		
		//Scroll to "Sanyo 165 cm (65 inches) Kaizen Series 4K Ultra HD Smart Certified Android IPS LED TV XT-65A082U (Black) (2019 Model)"
		k.androidScrolling("Sanyo 165 cm (65 inches)");
		
		//Info Level logging for Extent Report
		logger.log(Status.INFO, MarkupHelper.createLabel("Scrolled to Sanyo", ExtentColor.BLUE));
		
		Keywords.staticTime(10000L);
		
		// Validate for Use my current location button
		k.validationText("android", "Use my current location", "xpath","Xpath_Usemycurrentlocation_Button_ValidateText","Use my current location button not present");
		logger.log(Status.PASS,MarkupHelper.createLabel("Validation of Use my current location button", ExtentColor.GREEN));
		
		// Tap on Use my current location button
		k.tapElement("android", "xpath", "Xpath_Usemycurrentlocation_Button_Tap");
		
		// StepWise screenshot
		k.stepScreenshot("Use my current location button", "android");
				
		
		//Info Level logging for Extent Report
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on Use my current location button", ExtentColor.BLUE));
				
		Keywords.staticTime(10000L);
		
		
		//Tap on Allow of the pop up for acception location sharing
		k.tapElement("android", "xpath", "Xpath_Allow_Button_Tap");
		
		//Scroll to Add to Cart button and click
		k.androidScrolling("Add to Cart");
		
		Keywords.staticTime(10000L);
		
		//Validate for Proceed to checkout button
		k.validationText("android", "Proceed to checkout", "xpath","Xpath_Proceedtocheckout_Button_ValidateText","Proceed to checkout button not present");
		logger.log(Status.PASS,MarkupHelper.createLabel("Validation of Use my current location button", ExtentColor.GREEN));
		
		// Tap on Proceed to checkout button
		k.tapElement("android", "xpath", "Xpath_Proceedtocheckout_Button_Tap");
		
		// StepWise screenshot
		k.stepScreenshot("Proceed to checkout button", "android");
		
		//Info Level logging for Extent Report
		logger.log(Status.INFO, MarkupHelper.createLabel("Tap on Proceed to checkout button", ExtentColor.BLUE));
		
		//Changing Screen Orientation from Portrait to Landscape
		k.androidOrientation();
		
		// Close the application
		k.closeApplication("android");


	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		// getStatus --> returns an int value
		// 1--> success of Test annotation method
		// 2 --> Failure of Test annotation method
		// 3--> Skipping of Test annotation method
		// Static and Final variable --> FAILURE = 2, SUCCESS = 1, SKIP = 3
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				String var = k.FailScreenshot(result.getName(), "android");
				System.out.println(var);
				// adding screenshots to log
				logger.fail("Assertion failed", MediaEntityBuilder.createScreenCaptureFromPath(var).build());
				// adding screenshots to test
				logger.fail("Assertion failed").addScreenCaptureFromPath(var);
				// Add the test annotation method name which has failed in the log
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				// Add the exception name on assertion failure to the log
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			} catch (Throwable t) {
				System.out.println(t.getMessage());
			}

		}
		// Write the report in the report generated using the flush method
		extent.flush();

	}

	@DataProvider
	public Object[][] testData() {

		// Parameterization of data -->emulator/real, android/ios, Device name, UDID -android by using adb devices 
		// Parameterization of Edit boxes --> WIFI Settings Edit Box -->Sam
		// Parameterization to set the runmode --> If the run-mode is NO, the test annotation method will skip . If the run-mode is YES, the test annotationmethod will run

		// Number of rows--> number of times we want to run the Test annotation method
		// Number of column is number of data that we want to parameterize
		// Want to run the test annotation method two times ; first on emulator and second on real times
		// Want to parameterize

		
		/*
		 * We need to create an excel, create function to read the excel file and then
		 * create Hashtable through the function at runtime and pass it over the Data
		 * Provider.
		 */

		/*
		 * 1) Create the Excel: a) The data filling should happen from first row
		 * onwards. b) The first row should be the test case name which is equal to the
		 * Class name defined in com.appium.test package. Between test cases , we should
		 * have a blank row. c) After the test case in excel , we need to define the
		 * column name.The column name should be the KEYS of Hashtable for a particular
		 * test case.column d) After column name, define the values in the CELL which is
		 * equal to the VALUE of the KEY. e) All data in excel should be in STRING
		 * Format. f) The excel should have an extension of XLSX. g) The excel sheet
		 * should be given a name.
		 */

		// Download Apache POI 3.6 --> https://archive.apache.org/dist/poi/release/bin/
		// We will use this version as our excel function is based on this version
		// Put the created excel (AppiumData.xlsx) in com.appium.config package.
		// Based on Apache POI 3.6 , a set of function are pre-created. Put this class
		// file containing function in com.appium.utilities package.
		
		/*
		 * With the function define in Xls_Reader class file, we need to create function
		 * in order to read data from AppiumData.xlsx file --> create function to read
		 * the excel file and then create Hashtable through the function at runtime and
		 * pass it over the Data Provider.This function read AppiumData.xlsx file need
		 * to be created in com.appium.utilities package.
		 */

		return ExcelReader.readExcel("SearchTV", r);

	}
}
