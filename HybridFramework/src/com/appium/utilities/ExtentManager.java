package com.appium.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	
	//Global Variables
		private static ExtentHtmlReporter  report;
		private static ExtentReports  extent;
	
	/*ExtentHTMLReporter - A class inside the Extent reports API responsible for defining the path and name of the 
	 * report. Report will have an extension'of html. 
	 * This class can also be used to set the theme of the report, placeholder for pie chart, define the title of 
	 * the report, to define the name of the report*/
	
	/*METHOD's Job - getInstanceHtmlReporter()  - this function will be a static function which will return 
		ExtentHTMLReporter class.
		1) This  method will see if objects of ExtentHTMLReporter is created or not.
		2)If the object of ExtentHTMLReporter is not created , create it.
		3) The same object of ExtentHTMLReporter class needs to be used in all class files defined in 
		com.appium.tests package.*/
	
	
	/*ExtentReports - A class inside the Extent reports API responsible for creating the test case,
	creating logs, creating test category, defining system information for the report
	generated and for writing the report in the report generated*/
	
	/*Method's job - getInstanceReporter() --> this function will be a static function which will return ExtentReports class.
		1)This method will see if objects of ExtentReports is created or not.
		2) If the object of ExtentReports is not created , create it.
		3) The same object of the ExtentReports class needs to be used in all class files defined in 
		com.appium.tests package. .*/
	
	//Download Extent Report 3.1.5 -->https://jar-download.com/artifacts/com.aventstack/extentreports/3.1.5/source-code	
		
	public static ExtentHtmlReporter getInstanceHtmlReporter() {
		
		if(report == null) {
			//Will  create the report name by the date stamp - will use the Data class
			Date d = new Date();
			String filename  = d.toString().replace(" ", "_").replace(":", "_");
			//System.out.println(filename);
			report = new ExtentHtmlReporter("C:\\Users\\lenovo\\Desktop\\Workspace_Amazon\\HybridFramework\\ExtentReport\\"+filename+".html");
			//Appending old reports with new reports - using setAppendExisting() - if true it will append
			report.setAppendExisting(true);
			report.loadXMLConfig("C:\\Users\\lenovo\\Desktop\\Workspace_Amazon\\HybridFramework\\src\\com\\appium\\config\\report-config.xml");
		
		}
		
		return report;
		
	}
	
	public static ExtentReports getInstanceReporter() {
		if(extent == null) {
			extent = new ExtentReports();
			extent.attachReporter(report);
			//Assign the system information
			extent.setSystemInfo("OS", "Windows 8.1");
			extent.setSystemInfo("SIT Env", "Functional");
			extent.setSystemInfo("User", "Lenovo");
			extent.setSystemInfo("Author", "Ajay");
			
		}
		
		return extent;
	}
	

}
