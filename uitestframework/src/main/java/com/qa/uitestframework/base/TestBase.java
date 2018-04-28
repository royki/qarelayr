package com.qa.uitestframework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.uitestframework.util.TestUtil;

/**
 * @author royki
 *
 */

/*
 * Base class to have common property, os, browsers, url, pagetitle, resource
 * folder
 * 
 */

public class TestBase {

	public static WebDriver driver;
	public static Properties property;

	public static final String OS_NAME = System.getProperty("os.name");
	public static final String CURRENT_DIR = System.getProperty("user.dir");
	public static final String RESOURCE_DIR = "/resources/";
	public static final String CONFIG_DIR = RESOURCE_DIR + "/config/";
	public static final String DRIVER_DIR = RESOURCE_DIR + "/drivers/";

	public TestBase() {
		try {
			property = new Properties();
			FileInputStream file = new FileInputStream(CURRENT_DIR + CONFIG_DIR + "config.properties");
			property.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		// Get browser from config file
		String browser = property.getProperty("browser");

		// For Windows platform
		if (OS_NAME.contains("Window")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(CURRENT_DIR);
				System.setProperty("webdriver.chrome.driver", CURRENT_DIR + DRIVER_DIR + "chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(CURRENT_DIR);
				System.setProperty("webdriver.gecko.driver", CURRENT_DIR + DRIVER_DIR + "geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} else if (OS_NAME.contains("Linux")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(CURRENT_DIR);
				System.setProperty("webdriver.chrome.driver", CURRENT_DIR + DRIVER_DIR + "chromedriver");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(CURRENT_DIR);
				System.setProperty("webdriver.gecko.driver", CURRENT_DIR + DRIVER_DIR + "geckodriver");
				driver = new FirefoxDriver();
			}
		} else if (OS_NAME.contains("Mac")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(CURRENT_DIR);
				System.setProperty("webdriver.chrome.driver", CURRENT_DIR + DRIVER_DIR + "chromedriver");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(CURRENT_DIR);
				System.setProperty("webdriver.fireefox.marionette", CURRENT_DIR + DRIVER_DIR + "geckodriver");
				driver = new FirefoxDriver();
			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(property.getProperty("url"));
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	/*
	 * public void tearDown() { driver.quit(); }
	 */
}
