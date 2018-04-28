package com.qa.uitestframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.uitestframework.base.TestBase;

/**
 * @author royki
 *
 */

public class JobsPage extends TestBase {

	// Page Obejct of JobsPage

	@FindBy(id = "q")
	WebElement searchJobNab;

	@FindBy(id = "sorting-options")
	WebElement sortingOptions;

	TestBase testbase = new TestBase();

	public JobsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions on JobsPage
	public String sortByNewestJob() {
		Select fromDropDownList = new Select(sortingOptions);
		fromDropDownList.selectByVisibleText("newest");
		String newestJobPageUrl = testbase.getUrl();
		System.out.println(newestJobPageUrl);
		return newestJobPageUrl;
	}

	public void sortByMatchJob() {
		Select fromDropDownList = new Select(sortingOptions);
		fromDropDownList.selectByVisibleText("matches");
	}

	public void sortBySalaryJob() {
		Select fromDropDownList = new Select(sortingOptions);
		fromDropDownList.selectByVisibleText("salary");
	}
}
