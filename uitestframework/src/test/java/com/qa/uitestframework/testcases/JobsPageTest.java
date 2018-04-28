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
 * 1. Go to the Job Page
 * 2. Verify Job Page Title
 * 3. Sort the jobs by 'newest' job
 */

public class JobsPageTest extends TestBase {

	HomePage homePage;
	JobsPage jobsPage;
	TestBase testbase;

	public JobsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		jobsPage = new JobsPage();
		testbase = new TestBase();
		jobsPage = homePage.clickOnJobTab();
	}

	@Test(priority = 1)
	public void verifyJobsPageTitleTest() {
		String actualTitle = "Developer Jobs, Programming Jobs & More - Stack Overflow";
		String expectedTitle = testbase.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle, "Job Page Title Not Matched");
	}

	@Test(priority = 2)
	public void sortByNewestJobTest() {
		jobsPage.sortByNewestJob();
		String newestJobPageUrlActual = "https://stackoverflow.com/jobs?med=site-ui&ref=jobs-tab&sort=p";
		String newestJobPageUrlExpected = jobsPage.sortByNewestJob();
		Assert.assertEquals(newestJobPageUrlActual, newestJobPageUrlExpected, "Job Page URL Not Matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}