package com.qa.eBayWebAutomation.testCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qa.eBayWebAutomation.baseTest.TestBase;
import com.qa.eBayWebAutomation.functions.CommonFunctions;
import com.qa.eBayWebAutomation.functions.ItemDetailedPageFunctions;
import com.qa.eBayWebAutomation.functions.SearchResultPageFunctions;
import com.qa.eBayWebAutomation.pages.CommonPage;
import com.qa.eBayWebAutomation.pages.HomePage;
import com.qa.eBayWebAutomation.pages.ItemDetailPage;
import com.qa.eBayWebAutomation.pages.LoginPage;
import com.qa.eBayWebAutomation.pages.SearchResultPage;
import com.qa.eBayWebAutomation.util.TestUtil;

public class TC_001_EbayTest extends TestBase {


	@Test(dataProvider = "getEbayTestData")
	public void TC_001_EbayAddToCartTest(String searchData, String signedInUser, String searchItem, 
			String selectionValue, String detailedPageHeader) {
		
		CommonPage searchPage = new CommonPage();
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		SearchResultPage resultPage = new SearchResultPage();
		ItemDetailPage detailPage = new ItemDetailPage();
		
		//Search "ebay" on google search bar
		CommonFunctions.type(searchPage.txtGoogleSearchBar, searchData);
		
		//Press ENTER key
		CommonFunctions.keyPress(searchPage.txtGoogleSearchBar, Keys.ENTER);
		
		//Verify that expected result exists
		CommonFunctions.isElementPresent(searchPage.lnksearchResult, "href", TestUtil.BASEURL);
		
		//Click and navigate to eBay link
		CommonFunctions.click(searchPage.getSearchResultLink(TestUtil.BASEURL));
		
		//Verify the default active landing page as "Home"
		CommonFunctions.isElementDisplayed(homePage.lblEbayHomeTab);
		
		//Click on Sign In link
		CommonFunctions.click(searchPage.getSearchResultLink(TestUtil.SIGN_IN));
		
		//Enter username
		CommonFunctions.type(loginPage.txtUsername, TestUtil.USERNAME);
		
		//Click on Continue
		CommonFunctions.click(loginPage.btnContinue);
		
		//Enter password
		CommonFunctions.type(loginPage.txtPassword, TestUtil.PASSWORD);
		
		//Click on Sign In button
		CommonFunctions.click(loginPage.btnSignIn);
		
		//Validate signed In user as "Gayani"
		CommonFunctions.isElementPresent(homePage.lnkSignedInUser, "innerText", signedInUser);
		
		//Enter search item name
		CommonFunctions.type(homePage.txtSearchBox, searchItem);
		
		//Click on search button
		CommonFunctions.click(homePage.btnSearch);
		
		//Verify the searched result information
		CommonFunctions.isElementDisplayed(resultPage.lblSearchResultText);
		System.out.println(resultPage.lblSearchResultText.getText());
		
		//Click on first searched result
		SearchResultPageFunctions.clickOnSearchedResult();
		
		CommonFunctions.switchToTab();
		
		//Verify the page header name
		CommonFunctions.isElementDisplayed(detailPage.lblItemName);
		
		//Store the item name
		String retrieveValue = CommonFunctions.storeText(detailPage.lblItemName);
		
		//Select option on item if available
		ItemDetailedPageFunctions.verifyDropDownValueSelection("1");
		
		//Scroll to the Add to Cart button element
		CommonFunctions.scrollToAnElement(detailPage.btnAddToCart);
		
		//Click on "Add To Cart"
		CommonFunctions.click(detailPage.btnAddToCart);
		
		//Verify the navigated page header
		CommonFunctions.isElementPresent(detailPage.lblDetailPageHeader, "innerText", detailedPageHeader);
		
		//Validate the stored item name with the actual item name in the cart
		CommonFunctions.isTextExists(detailPage.lblAddedItemName, retrieveValue);
		
	}
	

}
