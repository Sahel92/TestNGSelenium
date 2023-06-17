package com.qa.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessFireFox implements Browser {

	@Override
	public WebDriver launchBrowser(String url) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless", "remote-allow-origins=*");
		WebDriver driver = new FirefoxDriver(options);
		driver.get(url);
		return driver;
	}

}
