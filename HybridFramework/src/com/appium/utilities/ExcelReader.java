package com.appium.utilities;

import java.util.Hashtable;

public class ExcelReader {
	
	//First we need to find out the row number containing the test cases.
	//Second we need to find out how many columns are there in each test case.
	//Third find out how many row of data are there in each test case.
	//Fourth , we need to create  a hashtable at runtime
	
	public static Object[][] readExcel(String testCase, Xls_Reader xls){ //WifiSettings
		
		
		//1) First we need to find out the row number containing the test cases.
		//Test case starts from the first row.
		//Column number starts from 0 and row number starts from 1 - Xls_Reader class file
		int testCaseStartRowNumber = 1;
		//While loop will stop running when its find the test case 
		while(!xls.getCellData("Data", 0, testCaseStartRowNumber).equals(testCase)) {
					testCaseStartRowNumber++;
		}
		System.out.println(testCase+" is present in row number "+testCaseStartRowNumber);
		
		
		//2. Second we need to find out how many columns are there in each test case.
		//Row number in which column name is present for each test case = testCaseStartRowNumber+1
		int rowNumberfromWhichColumnNameisStarting =  testCaseStartRowNumber+1;
		int startingColumn = 1;
		while(!xls.getCellData("Data", startingColumn, rowNumberfromWhichColumnNameisStarting).equals("")) {
			startingColumn++;
		}
		System.out.println(testCase+" has "+startingColumn+ " columns filled with data");
		
		
		//3) Third find out how many row of data are there in each test case.
		//Test data for a particular test case = testCaseStartRowNumber +2
		int rowNumberFromWhichTestDataStarts = testCaseStartRowNumber+2;
		int columnInWhichDataIsPresent = 0;
		int counterRowfilledWithData = 0;//TO count how many times the while loop is run. Assume one row is filled with data
		while(!xls.getCellData("Data",columnInWhichDataIsPresent, rowNumberFromWhichTestDataStarts+counterRowfilledWithData).equals("")) {
			counterRowfilledWithData++;
		}
		System.out.println(testCase+" has "+counterRowfilledWithData+ " rows filled with data");
		
		
		//4) Fourth , we need to create  a hashtable at runtime
		//Pick up the data from excel sheet and put it to hashtable . Create a function for it.
		Object obj [][] = new Object[counterRowfilledWithData][1];
		Hashtable<String, String>table = null;
		//Outer FOR loop for the keys of the hashtable which are nothing column name in excel sheet
		//Outer FOR loop will give the number of rows to be iterated for the specific testcase
		int rNum;
		int cNum;
		for(rNum = rowNumberFromWhichTestDataStarts; rNum<rowNumberFromWhichTestDataStarts+counterRowfilledWithData; rNum++) {
			//System.out.println("Number of row to iterate for the test case" +testCase+ " is "+rNum);
			table = new Hashtable<String, String>();
			//Inner FOR loop for the values of the keys which are column values in excel
			//Inner FOR loop will give the number of columns to be iterated for the specific test case
			//cNum = 0  based on analogy that in apache POI 3.6 column number starts with 0
			for(cNum = 0; cNum<startingColumn; cNum++) {
				//System.out.println("Number of column to iterate for the test case" +testCase+ " is "+cNum);
				//Body to fetch data from the column of each test case and put it to hashtable
				//Key
				//String x = xls.getCellData("Data", cNum, rowFromWhichColumnStartsForTestCase);
				//Value 
				//String y = xls.getCellData("Data", cNum, rNum);
				//System.out.println(x+"--"+y);
				table.put(xls.getCellData("Data", cNum, rowNumberfromWhichColumnNameisStarting), xls.getCellData("Data", cNum, rNum));	
			}
			//Put the hashtable to the Object array
			obj[rNum-rowNumberFromWhichTestDataStarts][0] = table;//rNum = 3, 3-3 = 0, rNum = 4, 4-3 = 1,rNum = 5, 5-3= =3
		
		}
		
		return obj;
		//return null;
		
	}

}
