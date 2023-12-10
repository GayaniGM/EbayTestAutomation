package com.qa.eBayWebAutomation.functions;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.eBayWebAutomation.baseTest.TestBase;


public class CommonFunctions extends TestBase {

	//Method to type value on a text box
	public static void type(WebElement element, String text) {
		
		element.sendKeys(text);
		System.out.println("Entered data: " + text);
	}
	
	//Method to click on an element
	public static void click(WebElement element) {
		
		element.click();
		System.out.println("Clicked on element: " + element);
	}
	
	//Method to press key on keyboard
	public static void keyPress(WebElement element, Keys key) {
		
		element.sendKeys(key);
		System.out.println("Pressed on keyboard key: " + key);
		
	}
	
	//Method to verify an element in visible in the web page
	public static void isElementDisplayed(WebElement element) {
		
		element.isDisplayed();
		System.out.println(element + " is visible in the web page");
		Assert.assertTrue(true, "Element is not visible in the web page");
	}
	
	//Method to verify that element is present in the web page
	public static void isElementPresent(WebElement element, String attribute, String text) {
		
		String value = element.getAttribute(attribute);
		System.out.println(value + " is present");
		Assert.assertEquals(value, text, "Value does not exist.");
	}
	
	//Method to switch to tab
	public static void switchToTab() {
		
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}

		System.out.println("Swiched to tab");
	}
	
	//Method to close tab
	public static void closeTab() {
		
		driver.close();
		System.out.println("Closed the tab");
	}

	//Method to select value from the drop down
	public static void selectDropDownValue(WebElement ddElement, String value) {
		
		Select select = new Select(ddElement);
		select.selectByValue(value);
		System.out.println(value + " has been selected from the drop down");
	}
	
	//Method to store text
	public static String storeText(WebElement element) {
		
		String value = element.getText();
		return value;
		
	}
	//Method to validate the actual text is equal to the expected value
	public static void isTextExists(WebElement element, String expectedText) {
		
		String actualValue = element.getText();
		Assert.assertEquals(actualValue, expectedText);
		System.out.println(expectedText.equalsIgnoreCase(actualValue));
	
	}
	
	//Method to scroll to an element
	public static void scrollToAnElement(WebElement element) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

	}

}
