package com.qa.eBayWebAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eBayWebAutomation.baseTest.TestBase;

public class ItemDetailPage extends TestBase{

	//Initialing the page object
	public ItemDetailPage() {
		PageFactory.initElements(driver, this);
	}

	//Object repository
	@FindBy(xpath = "//h1[@class='x-item-title__mainTitle']//span")
	public WebElement lblItemName;
	
	@FindBy(id = "x-msku__select-box-1000")
	public WebElement ddSelectBox;
	
	@FindBy(id ="x-msku__option-box-1")
	public WebElement ddSelectOption;
	
	@FindBy(xpath = "//a[contains(@class,'ux-call-to-action')]//span[text()='Add to cart']")
	public WebElement btnAddToCart;
	
	@FindBy(xpath ="//a[@data-test-id='cart-item-link']//label")
	public WebElement lblAddedItemName;
	
	@FindBy(xpath ="//h1[@data-test-id='main-title']")
	public WebElement lblDetailPageHeader;
	
}
