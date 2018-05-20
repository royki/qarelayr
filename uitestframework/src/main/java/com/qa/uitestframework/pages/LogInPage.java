package com.qa.uitestframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.uitestframework.base.TestBase;

/**
 * @author royki
 *
 */



public class LogInPage extends TestBase {


	// Page object of LogInPage
	@FindBy(xpath = "//a[contains(text(),'LOG IN')]") // "//a[@class='btn-s3']"
	WebElement loginH;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='submit']")
	WebElement confimLogIn;

	@FindBy(xpath = "//div[@id='main-window']")
	WebElement popWindow;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[1]/span")//"//div[contains(@class,'container-buttons-of-popup')]")
	WebElement vclose;
	
	@FindBy(id = "portal-overlay")
	WebElement iframeId;

	@FindBy(xpath = "//a[contains(text(),'interuser1')]")
	WebElement userName;
	
	@FindBy(xpath = "//button[@class='submit no-uniform']")
	WebElement logoutBtn;

	public LogInPage() {
		PageFactory.initElements(driver, this);
	}

	public void logIn() {
		Actions a = new Actions(driver);
		a.moveToElement(loginH).build().perform();
		username.sendKeys("interuser1");
		password.sendKeys("bwin.2017");
		confimLogIn.click();
		driver.switchTo().frame(iframeId);		
		vclose.click();
		driver.switchTo().defaultContent();
	}	
	
	public boolean userLoggedIn() {
		userName.isDisplayed();
		return true;
	}	
	
	public HomePage userLoggedOut() {
		logoutBtn.click();
		return new HomePage();
	}
}
