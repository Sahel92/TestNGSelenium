package com.qa.browsers;

import org.openqa.selenium.WebDriver;

public interface Browser {

	/**
	 * Browser Classes implementing this must provide implementation for this
	 * method.
	 * 
	 * @return WebDriver
	 */
	WebDriver launchBrowser();

}
