package com.qa.eBayWebAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eBayWebAutomation.baseTest.TestBase;

public class CommonPage extends TestBase{
	
	//Initialing the page object
	public CommonPage() {
		PageFactory.initElements(driver, this);
	}

	//Object repository
	@FindBy(name = "q")
	public WebElement txtGoogleSearchBar;
	
    public WebElement getSearchResultLink(String url) {
        String lnkSearchResult = "//a[contains(@href, '" + url + "')]";
        return driver.findElement(By.xpath(lnkSearchResult));
    }
	
    @FindBy (xpath = "//div[@class='g']//a")
    public WebElement lnksearchResult;
}
