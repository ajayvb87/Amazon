package Rough;

import com.appium.utilities.Xls_Reader;

public class ReadExcel {

	public static void main(String[] args) {
		
		//Column number starts from 0 and row number starts from 1 as far as using this Xls_Reader .java class file and methods inside it.


		Xls_Reader r = new Xls_Reader("C:\\Users\\lenovo\\Desktop\\Appium\\Workspace_Weedkend_Batch2\\HybridFramework\\src\\Rough\\Example.xlsx");

		String str1 = r.getCellData("Data", "Name", 2);
		System.out.println(str1);
		
		String str2 = r.getCellData("Data", 1, 3);
		System.out.println(str2);
		
		int columnCount = r.getColumnCount("Data");
		System.out.println(columnCount);
		
		int rowCount =r.getRowCount("Data");
		System.out.println(rowCount);
	}

}
