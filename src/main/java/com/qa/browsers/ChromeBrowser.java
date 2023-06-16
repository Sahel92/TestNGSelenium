package com.qa.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser implements Browser {

	/**
	 * returns Chrome Browser non-headless allows for auto update of the brwoser
	 * with the options arguement passed.
	 */
	@Override
	public WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		return new ChromeDriver(options);
	}

}
