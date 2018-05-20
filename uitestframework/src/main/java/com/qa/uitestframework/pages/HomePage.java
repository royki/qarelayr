package com.qa.uitestframework.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.uitestframework.base.TestBase;

/**
 * @author royki
 *
 */

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
}
