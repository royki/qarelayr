package com.qa.uitestframework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.uitestframework.base.TestBase;

public class LiveBettingPage extends TestBase {

	@FindBy(xpath = "//a[@class='activeItem'][contains(text(),'Live betting')]")
	WebElement liveBetBtn;

	@FindBy(xpath = "//table[@class='events-table']") // //*[@id="overview"]/div[2]/div[1]/div[1]/div/table
	WebElement eventTable;
	
	@FindBy(xpath = "//*[@id=\"overview\"]/div[2]/div[1]/div[1]/div/table/tbody/tr[2]/td[1]")
	WebElement fRowfromTable;
	
	List<WebElement> rows= eventTable.findElements(By.tagName("tr"));
	

}
