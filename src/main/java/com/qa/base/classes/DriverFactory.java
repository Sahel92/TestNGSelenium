package com.qa.base.classes;

import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.browsers.Browser;
import com.qa.browsers.ChromeHeadLess;
import com.qa.customexceptions.YamlFileNotFoundException;
import com.qa.util.ReadYamlFiles;

public class DriverFactory {

	private static WebDriver webDriver;
	private final ReadYamlFiles environmentVariables;
	public static final Logger logger = LogManager.getLogger(DriverFactory.class);

	/**
	 * DriverFactory constructor initializes the environmentVariables object by
	 * loading the YAML file. It also configures the log4j properties.
	 *
	 * @throws YamlFileNotFoundException if the YAML file path does not exist.
	 */
	public DriverFactory() throws YamlFileNotFoundException {
		String yamlFilePath = System.getProperty("user.dir") + "/src/main/resources/config/env_config.yml";
		String log4JPath = System.getProperty("user.dir") + "/src/main/resources/config/log4j.xml";

		try {
			environmentVariables = ReadYamlFiles.getInstance(yamlFilePath);
		} catch (FileNotFoundException e) {
			logger.info("Failed to load environment configurations. Check to make sure your directory is correct");
			throw new YamlFileNotFoundException("Failed to Load environment context with message " + e.getMessage());
		}
		System.setProperty("log4j.configurationFile", log4JPath);
	}

	/**
	 *
	 *
	 *
	 * @return The WebDriver instance.
	 */
	public WebDriver getDriver() {
		return webDriver;
	}

	/**
	 * Call to instantiate the WebDriver instance and launch a browser
	 */
	public void setupBrowser() {

		Map<Object, Object> qaEnvironment = environmentVariables.getYamlProperty("qa");
		String url = qaEnvironment.get("url").toString();

		Browser browser;

		switch (qaEnvironment.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) qaEnvironment.get("headless")) {
				browser = new ChromeHeadLess();
			}

		}

	}

}
