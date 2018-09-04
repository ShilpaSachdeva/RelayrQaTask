package com.Google.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonLibs.utils.WaitUtils;

public class GoogleSearchResultsPage extends BasicOperations {

	public GoogleSearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	// Using page factory FindBy method to find all the elements in this page

	@FindBy(xpath = "//div[@class='rc']/h3[@class='r']/a")
	private List<WebElement> googleSearchResults;

	@FindBy(xpath = "//div[@id='rg_s']/div[@class='rg_bx rg_di rg_el ivg-i']/a")
	private List<WebElement> googleImagesSearchResults;

	@FindBy(xpath = "//*[@id='rso']/div/div[@class='g']/div/div/h3/a")
	private List<WebElement> googleNewsSearchResults;

	@FindBy(xpath = "//div[@class='section-result']")
	private List<WebElement> googleMapsSearchResults;

	@FindBy(xpath = "//div[@class='med card-section']/p")
	public WebElement noSearchResults;

	@FindBy(xpath = "//*[@id='hdtb-msb-vis']/div/a")
	private List<WebElement> googleSearchPageTabs;

	// Defining all the user actions (Methods) that can be performed in this
	// page

	public boolean verifySearchTabName(String tabName, String searchedString) {
		boolean flag=false;
		List<WebElement> alllinks = googleSearchPageTabs;
		String a[]=new String[alllinks.size()];
		for(int i=0;i<alllinks.size();i++) {
			if (alllinks.get(i).getText().contains(tabName) && tabName=="Images") {
				
				alllinks.get(i).click();
				if (verifySuccessfulImageSearchResults(searchedString)){
					flag= true;
				}else{
					flag= false;
				}
				
			}else if (alllinks.get(i).getText().contains(tabName) && tabName=="Videos") {
				alllinks.get(i).click();
				if (verifySuccessfulSearchResults(searchedString)){
					flag= true;
				}else{
					flag= false;
				}
				
			}else if (alllinks.get(i).getText().contains(tabName) && tabName=="Maps") {
				alllinks.get(i).click();
					if (verifyMapsSearchResults()!=0){
						flag= true;
					}else{
						flag= false;
					}
			}else if (alllinks.get(i).getText().contains(tabName) && tabName=="News") {
				alllinks.get(i).click();
						if (verifyNewsSearchResults(searchedString)){
							flag= true;
						}else{
							flag= false;
						}
			
			}
			
		}
		return flag;
	}

	public boolean verifySuccessfulSearchResults(String searchedString) {
		boolean flag = false;
		ArrayList<String> searchResults = getAllSearchResults();
		for (String result : searchResults) {
			if (result.toLowerCase().contains(searchedString.toLowerCase())) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public ArrayList<String> getAllSearchResults() {
		ArrayList<String> resultNames = new ArrayList<String>();
		for (WebElement result : googleSearchResults) {
			resultNames.add(result.getText());
		}
		return resultNames;
	}

	public ArrayList<String> getAllSearchLinks() {
		ArrayList<String> resultLinks = new ArrayList<String>();
		for (WebElement result : googleSearchResults) {
			resultLinks.add(result.getAttribute("href"));
		}
		return resultLinks;
	}

	public ArrayList<String> getImagesResult() {
		ArrayList<String> resultNames = new ArrayList<String>();
		for (WebElement result : googleImagesSearchResults) {
			resultNames.add(result.getAttribute("href"));
		}
		return resultNames;
	}

	public boolean verifySuccessfulImageSearchResults(String searchedString) {
		boolean flag = false;
		ArrayList<String> searchResults = getImagesResult();
		for (String result : searchResults) {
			if (result.toLowerCase().contains(searchedString.toLowerCase())) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public ArrayList<String> getNewsResult() {
		ArrayList<String> resultNames = new ArrayList<String>();
		for (WebElement result : googleNewsSearchResults) {
			resultNames.add(result.getAttribute("href"));
		}

		return resultNames;
	}

	public boolean verifyNewsSearchResults(String searchedString) {
		boolean flag;
		ArrayList<String> searchResults = getNewsResult();
		if (searchResults.get(1).toLowerCase().contains(searchedString.toLowerCase())) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public int verifyMapsSearchResults() {
		
		if (googleMapsSearchResults.size() != 0) {
			return googleMapsSearchResults.size();
		} else {
			return 0;
		}

	}

	

}
