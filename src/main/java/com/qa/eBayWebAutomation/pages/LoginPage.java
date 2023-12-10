package com.qa.eBayWebAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eBayWebAutomation.baseTest.TestBase;

public class LoginPage extends TestBase{

	//Initialing the page object
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}

	//Object repository
	@FindBy(id = "userid")
	public WebElement txtUsername;
	
	@FindBy(id = "signin-continue-btn")
	public WebElement btnContinue;
	
	@FindBy (id = "pass")
	public WebElement txtPassword;
	
	@FindBy(id = "sgnBt")
	public WebElement btnSignIn;
}
