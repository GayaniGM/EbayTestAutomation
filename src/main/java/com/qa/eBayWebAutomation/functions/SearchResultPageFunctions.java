package com.qa.eBayWebAutomation.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.qa.eBayWebAutomation.baseTest.TestBase;
import com.qa.eBayWebAutomation.pages.SearchResultPage;

public class SearchResultPageFunctions extends TestBase{

	//Method to click on first result from the search results
	public static void clickOnSearchedResult() {
		
		SearchResultPage resultPage = new SearchResultPage();
		int elementCount = resultPage.imgSearchItemLinkCount.findElements(By.xpath
				("//ul//li[@class='s-item s-item__pl-on-bottom']//div[@class='s-item__image']")).size();
		for(int i=1; i<= elementCount; i++) {
			
			//Break loop from first click
			if (i == 1) {
				CommonFunctions.click(resultPage.getImgSearchItemLink(i));
				break;
			} else {
				continue;
			}
		}
		

		
	}

}
