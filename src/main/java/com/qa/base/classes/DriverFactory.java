package com.qa.base.classes;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.browsers.Browser;
import com.qa.browsers.ChromeBrowser;
import com.qa.browsers.ChromeHeadLess;
import com.qa.browsers.EdgeHeadLess;
import com.qa.browsers.FireFoxBrowser;
import com.qa.browsers.HeadLessFireFox;
import com.qa.customexceptions.UnknownBrowserException;
import com.qa.customexceptions.YamlFileNotFoundException;
import com.qa.util.ReadYamlFiles;

/**
 * The DriverFactory class handles the creation and management of WebDriver
 * instance based on environment configurations loaded from a YAML file.
 */
public class DriverFactory {

	private WebDriver webDriver;
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
	 * Get the WebDriver instance.
	 *
	 * @return The WebDriver instance.
	 */
	public WebDriver getDriver() {
		return webDriver;
	}

	/**
	 * Call to instantiate the WebDriver instance and launch a browser based on the
	 * environment configuration.
	 *
	 * @throws UnknownBrowserException if the specified browser is unknown.
	 */
	public void setupBrowser() throws UnknownBrowserException {
		Map<Object, Object> qaEnvironment = environmentVariables.getYamlProperty("qa");
		String url = qaEnvironment.get("url").toString();
		String browserName = qaEnvironment.get("browser").toString().toLowerCase();
		boolean isHeadless = (boolean) qaEnvironment.get("headless");

		Browser browser;

		switch (browserName) {
		case "chrome":
			browser = isHeadless ? new ChromeHeadLess() : new ChromeBrowser();
			break;
		case "firefox":
			browser = isHeadless ? new HeadLessFireFox() : new FireFoxBrowser();
			break;
		case "edge":
			browser = isHeadless ? new EdgeHeadLess() : new EdgeBrowser();
			break;
		default:
			throw new UnknownBrowserException("Unknown Browser. Check environment properties");
		}

		webDriver = browser.launchBrowser(url);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		webDriver.manage().window().fullscreen();
	}

	/**
	 * Quit the WebDriver and close the browser if it is currently open.
	 */
	public void quitBrowser() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}