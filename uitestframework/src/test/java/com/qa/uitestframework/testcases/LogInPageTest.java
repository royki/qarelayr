package com.qa.uitestframework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.uitestframework.base.TestBase;
import com.qa.uitestframework.pages.HomePage;
import com.qa.uitestframework.pages.LogInPage;

/**
 * @author royki
 *
 */



public class LogInPageTest extends TestBase {

	HomePage homePage;
	LogInPage loginPage;
	TestBase testBase;
	
	public LogInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		testBase = new TestBase();
		loginPage = new LogInPage();
	}
	
	@Test(priority = 1)
	public void userlogInTest() {
		loginPage.logIn();		
		loginPage.userLoggedIn();
		loginPage.userLoggedOut();
	}
	
	@Test(priority = 2)
	public void userlogOutTest() {	
		String actualTitle = "Bet Online with One of the Top Online Betting Sites | Poker & Casino | bwin";
		String expectedTitle = testBase.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle, "Home Page Title Not Matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
