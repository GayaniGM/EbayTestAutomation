package com.qa.eBayWebAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eBayWebAutomation.baseTest.TestBase;

public class SearchResultPage extends TestBase{

	//Initialing the page object
	public SearchResultPage() {

		PageFactory.initElements(driver, this);
		
	}
	
	//Object repository
	@FindBy(xpath = "//h1[@class='srp-controls__count-heading']")
	public WebElement lblSearchResultText;
	
	@FindBy(xpath = "//ul//li[@class='s-item s-item__pl-on-bottom']//div[@class='s-item__image']")
	public WebElement imgSearchItemLinkCount;
	
    public WebElement getImgSearchItemLink(int index) {
        String itemLink = "(//ul//li[@class='s-item s-item__pl-on-bottom']//div[@class='s-item__image'])['"+index+"']";
        return driver.findElement(By.xpath(itemLink));
    }

}
