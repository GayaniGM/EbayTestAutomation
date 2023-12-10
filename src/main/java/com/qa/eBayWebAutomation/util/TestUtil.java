package com.qa.eBayWebAutomation.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.eBayWebAutomation.baseTest.TestBase;

public class TestUtil extends TestBase{

	//Assigning config properties to variables
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String URL = prop.getProperty("url");
	public static String BASEURL = prop.getProperty("baseUrl");
	public static String SIGN_IN = prop.getProperty("eBaySignIn");
	public static String USERNAME = prop.getProperty("username");
	public static String PASSWORD = prop.getProperty("password");
	
	public static String TESTDATASHEET_PATH = System.getProperty("user.dir") + "\\src\\main\\java"
	        + "\\com\\qa\\eBayWebAutomation\\testData\\TC_001_EbayTest.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	//Method to read excel data
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			//Access data file location
			file = new FileInputStream(TESTDATASHEET_PATH);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//Access the sheet name
		sheet = book.getSheet(sheetName);
		
		//Assign row and column values to 2D object array
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//Implementing for loop to read data iterations
		for (int i = 0; i<sheet.getLastRowNum();i++) {
			for(int k = 0; k< sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
	}

}
