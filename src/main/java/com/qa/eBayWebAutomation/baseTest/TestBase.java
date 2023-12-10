package com.qa.eBayWebAutomation.baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.qa.eBayWebAutomation.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	String sheetname = "testData";
	
	public TestBase() {
		
		try {
			//Load cofig.properties file
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\eBayWebAutomation\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization() {
		
		//Access chrome driver and invoke
		String browserName = prop.getProperty("browser");
		boolean headlessMode = Boolean.parseBoolean(prop.getProperty("headlessMode"));
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			if(headlessMode) {
		       
		        options.addArguments("--headless");
			}
			
	        driver = new ChromeDriver(options);
			
		
		}
		
		//Apply browser properties
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//Launch main url
		driver.get(prop.getProperty("url"));
			
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		initialization();	
		
	}
	
	@DataProvider
	//Read data from the data sheet and return to test
	public Object[][] getEbayTestData() {
		Object data [][] = TestUtil.getTestData(sheetname);
		return data;
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
