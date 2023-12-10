package com.qa.eBayWebAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eBayWebAutomation.baseTest.TestBase;

public class HomePage extends TestBase{

	//Initialing the page object
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	
	}
	
	//Object repository
	@FindBy(xpath = "//li[@class='hl-cat-nav__active']")
	public WebElement lblEbayHomeTab;
	
	@FindBy(xpath = "//button//b")
	public WebElement lnkSignedInUser;
	
	@FindBy(id = "gh-ac")
	public WebElement txtSearchBox;
	
	@FindBy(id = "gh-btn")
	public WebElement btnSearch;

}
