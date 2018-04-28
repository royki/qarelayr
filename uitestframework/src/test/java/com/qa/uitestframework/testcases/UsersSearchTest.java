package com.qa.uitestframework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.uitestframework.base.TestBase;
import com.qa.uitestframework.pages.HomePage;
import com.qa.uitestframework.pages.UsersPage;

/**
 * @author royki
 *
 */

/*
 * 1. Go to Users' Page
 * 2. Verify Users' Page Title
 * 3. Verify Users' Page URL
 * 4. Search a User named- 'royki'
 * 5. Verify user is found
 * 
 */
public class UsersSearchTest extends TestBase {

	TestBase testbase;
	HomePage homePage;
	UsersPage usersPage;

	public UsersSearchTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		testbase = new TestBase();
		usersPage = homePage.clickOnUsersTab();
	}

	@Test(priority = 1)
	public void verifyUsersPageTitleTest() {
		String actualTitle = "Users - Stack Overflow";
		String expectedTitle = testbase.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Users' Page Title Not Matched");
	}

	@Test(priority = 2)
	public void verifyUsersPageUrlTest() {
		String usersPageUrlActual = "https://stackoverflow.com/users";
		String usersPageUrlExpected = testbase.getUrl();
		Assert.assertEquals(usersPageUrlActual, usersPageUrlExpected, "Users' Page URL Not Matched");
	}

	@Test(priority = 3)
	public void searchUserTest() {
		usersPage.searchUser();
		boolean found = usersPage.verifyUser();
		Assert.assertTrue(found);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
