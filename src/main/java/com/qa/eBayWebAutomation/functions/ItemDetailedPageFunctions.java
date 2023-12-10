package com.qa.eBayWebAutomation.functions;

import org.openqa.selenium.NoSuchElementException;

import com.qa.eBayWebAutomation.pages.ItemDetailPage;

public class ItemDetailedPageFunctions {

	//Method to select values from drop down if a select drop down is available
	public static void verifyDropDownValueSelection(String value) {
		
		ItemDetailPage detailPage = new ItemDetailPage();
		try {
			if(detailPage.ddSelectBox.isDisplayed()) {
				CommonFunctions.selectDropDownValue(detailPage.ddSelectBox, value);
				
			}else {
				System.out.println("A drop down does not exists");
			}
		}

    catch (NoSuchElementException e) {
        System.out.println("A drop down does not exist for the record");
    }
	}
}
