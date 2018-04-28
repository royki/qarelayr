package com.qa.uitestframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.uitestframework.base.TestBase;

/**
 * @author royki
 *
 */


public class UsersPage extends TestBase {

	TestBase testbase = new TestBase();

	// Page Objects of UsersPage
	@FindBy(id = "userfilter")
	WebElement userFilter;

	@FindBy(xpath = "//a[@href='/users/2498938/royki']")
	WebElement user;

	@FindBy(xpath = "//h2[@class='user-card-name']")
	WebElement userVerify;

	public UsersPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions on UsersPage
	public void searchUser() {
		userFilter.sendKeys("royki");
		user.click();
	}

	public boolean verifyUser() {
		return userVerify.isDisplayed();
	}
}
