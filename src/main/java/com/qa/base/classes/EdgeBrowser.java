package com.qa.base.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.qa.browsers.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser implements Browser {

	@Override
	public WebDriver launchBrowser(String url) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("remote-allow-origin=*");
		WebDriver driver = new EdgeDriver();
		driver.get(url);
		return driver;
	}

}
