package Rough;

import com.appium.utilities.ExcelReader;
import com.appium.utilities.Xls_Reader;

public class SampleRead {
	
	//Just to show the working behavior of ExcelReader class files  readExcel function

	public static void main(String[] args) {
		
		Xls_Reader r = new Xls_Reader("C:\\Users\\lenovo\\Desktop\\Appium\\Workspace_Weedkend_Batch2\\HybridFramework\\src\\com\\appium\\config\\AppiumData.xlsx");

		ExcelReader.readExcel("WifiSettings", r);
		
		ExcelReader.readExcel("DragAndDrop", r);

	}

}
