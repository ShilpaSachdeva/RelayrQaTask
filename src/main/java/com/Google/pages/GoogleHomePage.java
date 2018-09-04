package com.Google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasicOperations {

	public GoogleHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	// Using page factory FindBy method to find all the elements in this page
	
	@FindBy(id = "lst-ib")
	private WebElement googleSearchText;
	
	@FindBy(xpath = "//input[@value ='Google Search']")
	private WebElement googleSearchBtn;
	
	@FindBy(xpath = "//input[contains(@value, 'Feeling Lucky')]")
	private WebElement iAmFeelingLuckyBtn;
	
	@FindBy(xpath = "//image[@alt='Google']")
	public WebElement googleTitle;
	
	@FindBy(linkText = "English")
	public WebElement language;


	

	// Defining all the user actions (Methods) that can be performed in this page
	
	public void enterGoogleSearchText(String searchText) throws Exception {
		googleSearchText.clear();
		googleSearchText.sendKeys(searchText);		
	}
	
	public void clickGoogleSearchBtn() throws Exception {
		googleSearchBtn.click();
		
		
	}
	public void clickIAmFeelinLuckyBtn() throws Exception {
		iAmFeelingLuckyBtn.click();
		
	}

}
