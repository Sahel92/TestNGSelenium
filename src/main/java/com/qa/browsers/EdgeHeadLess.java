package com.qa.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeHeadLess implements Browser {

	@Override
	public WebDriver launchBrowser(String url) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless", "remote-allow-origin=*");
		WebDriver driver = new EdgeDriver();
		driver.get(url);
		return driver;
	}

}
