package com.qa.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadLess implements Browser {

	@Override
	public WebDriver launchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		return driver;
	}

}
