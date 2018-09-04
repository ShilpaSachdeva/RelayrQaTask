package com.Google.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTestCases extends BaseScenarios {

	@Test(priority = 0)
	public void verifyGoogleSearchValidString() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 1 :: Verify Successful Search");
			String validString = "selenium";
			logger.info("Opening Google Home Page");
			String actualURLHomePage = driver.getCurrentUrl();
			if (configProperty.getProperty("baseUrl") == actualURLHomePage) {
				logger.pass("Google Home Page is validated");
			}
			logger.info("Enter Search Text");
			homepage.enterGoogleSearchText(validString);
			logger.info("Click on search");
			homepage.clickGoogleSearchBtn();
			if (searchresultpage.verifySuccessfulSearchResults(validString)) {
				logger.pass("Successful Results for Text " + validString + " Found!!!");
			} else {
				Assert.fail("Search Failed!!!");

			}
			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 1)
	public void verifyIAmFeelingLuckyLink() throws Exception {
		try {

			logger = report.createTest("Test case Id :: 2 :: Verify IamFeelingLuck Link");
			String validString = "selenium";
			logger.info("Opening Google Home Page");
			logger.info("Enter Search Text");
			homepage.enterGoogleSearchText(validString);
			logger.info("Click on I'm Feeling Lucky Button");
			homepage.clickIAmFeelinLuckyBtn();
			if (driver.getCurrentUrl().toLowerCase().contains(validString)) {
				logger.pass("Google I'm feeling lucky search results for text: " + validString + " is: "
						+ driver.getCurrentUrl());
			} else {
				Assert.fail("Search Failed!!!");
			}
			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 2)
	public void verifyGoogleSearchInvalidString() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 3 :: Verify No Results Found in Search results");
			String invalidString = "%%%%%%%%%%%%%%%%%%";
			logger.info("Opening Google Home Page");

			logger.info("Enter Search Text");
			homepage.enterGoogleSearchText(invalidString);
			logger.info("Click on search");
			homepage.clickGoogleSearchBtn();
			if ((searchresultpage.getAllSearchResults().size() == 0)
					&& (searchresultpage.noSearchResults.getText().contains(invalidString))) {
				logger.pass("Search text: " + invalidString + " doesn't has search results!!!");
			} else {
				Assert.fail("Search Failed!!!");

			}

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();

		}

	}

	@Test(priority = 3)
	public void verifySearchResultsClickFirstLink() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 4 :: Verify First Searched result link");
			String validString = "selenium";
			logger.info("Opening Google Home Page");
			driver.navigate().to(configProperty.getProperty("baseUrl"));
			logger.info("Enter Search Text");
			homepage.enterGoogleSearchText(validString);
			logger.info("Click on search");
			homepage.clickGoogleSearchBtn();
			logger.info("Opening first link under All tab");
			ArrayList<String> allresults = new ArrayList<String>();
			allresults = searchresultpage.getAllSearchLinks();
			driver.navigate().to(allresults.get(0));
			if (driver.getCurrentUrl().toLowerCase().contains(validString)) {
				logger.pass("Google First search results for text: " + validString + " is: " + allresults.get(0));
			} else {
				Assert.fail("Search Failed!!!");
			}
			driver.navigate().back();
			
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 4)
	public void verifyVideosTabSearchResult() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 5 :: Verify Search result Videos tab");
			String validString = "selenium";
			logger.info("Opening Videos tab");
			if (searchresultpage.verifySearchTabName("Videos", validString)) {
				logger.pass("Videos related to search text: " + validString + " found!!!");

				logger.info("Opening first link under Videos tab");

				ArrayList<String> allresults = new ArrayList<String>();
				allresults = searchresultpage.getAllSearchLinks();
				driver.navigate().to(allresults.get(0));
				if (driver.getCurrentUrl().toLowerCase().contains(validString)) {
					logger.pass("Google first Books results for text: " + validString + " is: " + allresults.get(0));
				}
				driver.navigate().back();
			}

			else {
				Assert.fail("videos Search Failed!!!");
			}
			

		} catch (

		Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 5)
	public void verifyImagesTabSearchResult() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 6 :: Verify Search result Images tab");
			String validString = "selenium";
			logger.info("Opening Images tab");
			

			if (searchresultpage.verifySearchTabName("Images", validString)) {
				logger.pass("Images related to search text: " + validString + " found!!!");
			} else {
				Assert.fail("Images Search Failed!!!");

			}

			

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 6)
	public void verifyNewsTabSearchResult() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 7 :: Verify Search result News tab");
			String validString = "selenium";
			logger.info("Opening News tab");
			

			if (searchresultpage.verifySearchTabName("News",validString)) {
				logger.pass("News related to search text: " + validString + " found!!!");
			} else {
				Assert.fail("News Search Failed!!!");

			}

			

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

	@Test(priority = 7)
	public void verifyMapsTabSearchResult() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 8 :: Verify Search result Maps tab");
			String validString = "selenium";
			logger.info("Opening Maps tab");
			

			if (searchresultpage.verifySearchTabName("Maps", validString)) {
				logger.pass("Maps related to search text: " + validString + " found!!!");
			} else {
				logger.pass("No Maps related to search text: " + validString + " found!!!");

			}

		

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail();
		}

	}

}