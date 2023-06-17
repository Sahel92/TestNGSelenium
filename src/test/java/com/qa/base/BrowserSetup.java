package com.qa.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.base.classes.DriverFactory;
import com.qa.customexceptions.UnknownBrowserException;
import com.qa.customexceptions.YamlFileNotFoundException;

public class BrowserSetup extends DriverFactory {

	public BrowserSetup() throws YamlFileNotFoundException {
		super();

	}

	@BeforeSuite
	public void setupBrowser() throws UnknownBrowserException {
		super.setupBrowser();
	}

	@AfterSuite
	public void tearDown() {
		super.quitBrowser();
	}

}
