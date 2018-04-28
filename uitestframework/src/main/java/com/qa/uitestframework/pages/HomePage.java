package com.qa.uitestframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.uitestframework.base.TestBase;

/**
 * @author royki
 *
 */

public class HomePage extends TestBase {

	// Page Object of HomePage
	@FindBy(id = "nav-jobs")
	WebElement jobTab;

	@FindBy(id = "nav-questions")
	WebElement questionTab;

	@FindBy(id = "nav-users")
	WebElement userTab;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions/Method of HomePage
	public QuestionsPage clickOnQuestionTab() {
		questionTab.click();
		return new QuestionsPage();
	}

	public JobsPage clickOnJobTab() {
		jobTab.click();
		return new JobsPage();
	}

	public UsersPage clickOnUsersTab() {
		userTab.click();
		return new UsersPage();
	}
}
