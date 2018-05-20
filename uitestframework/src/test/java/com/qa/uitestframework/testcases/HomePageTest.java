package com.qa.uitestframework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.uitestframework.base.TestBase;
import com.qa.uitestframework.pages.HomePage;

/**
 * @author royki
 *
 */


public class HomePageTest extends TestBase {

	HomePage homePage;	
	TestBase testBase;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		testBase = new TestBase();
	}

	@Test
	public void verifyHomePageTitleTest() {
		String actualTitle = "Bet Online with One of the Top Online Betting Sites | Poker & Casino | bwin";
		String expectedTitle = testBase.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle, "Home Page Title Not Matched");
	}	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
