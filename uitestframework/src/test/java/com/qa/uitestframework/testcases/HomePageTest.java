package com.qa.uitestframework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.uitestframework.base.TestBase;
import com.qa.uitestframework.pages.HomePage;
import com.qa.uitestframework.pages.JobsPage;

/**
 * @author royki
 *
 */

/*
 * 1. Go to the Home Page
 * 2. Verify Home Page Title
 * 3. Click on Job tab
 * 4. Verify Job tab url
 */

public class HomePageTest extends TestBase {

	HomePage homePage;
	JobsPage jobsPage;
	TestBase testbase;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		testbase = new TestBase();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String actualTitle = "Stack Overflow - Where Developers Learn, Share, & Build Careers";
		String expectedTitle = testbase.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle, "Home Page Title Not Matched");
	}

	@Test(priority = 2)
	public void clickOnJobsTabTest() {
		jobsPage = homePage.clickOnJobTab();
		String actualJobPageUrl = testbase.getUrl();
		String expectedJobPageUrl = "https://stackoverflow.com/jobs?med=site-ui&ref=jobs-tab";
		Assert.assertEquals(actualJobPageUrl, expectedJobPageUrl, "Job tab URL Not Matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
