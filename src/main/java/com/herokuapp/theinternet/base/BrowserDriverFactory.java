package com.herokuapp.theinternet.base;

import java.net.MalformedURLException;
import java.net.URI;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverFactory {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	private String gridHubUrl = "http://127.0.0.1:4445/wd/hub";
	
	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}
	
	public WebDriver createDriver() throws MalformedURLException {
		// Create driver
				log.info("Create driver: " + browser);

				RemoteWebDriver remoteWebDriver;
				switch (browser) {
				case "chrome":
					driver.set(new ChromeDriver());
					break;

				case "firefox":
					driver.set(new FirefoxDriver());
					break;
					
				case "edge":
					driver.set(new EdgeDriver());
					break;
					
				case "chromegrid":
					ChromeOptions chromeOptions = new ChromeOptions();
	                remoteWebDriver = new RemoteWebDriver(URI.create(gridHubUrl).toURL(), chromeOptions);
	                driver.set(remoteWebDriver);
	                break;

				case "firefoxgrid":
					FirefoxOptions firefoxOptions = new FirefoxOptions();
	                remoteWebDriver = new RemoteWebDriver(URI.create(gridHubUrl).toURL(), firefoxOptions);
	                driver.set(remoteWebDriver);
	                break;
					
				case "edgegrid":
					EdgeOptions edgeOptions = new EdgeOptions();
	                remoteWebDriver = new RemoteWebDriver(URI.create(gridHubUrl).toURL(), edgeOptions);
	                driver.set(remoteWebDriver);
	                break;

				default:
					log.warn("Do not know how to start: " + browser + ", starting chrome.");
					driver.set(new ChromeDriver());
					break;
				}
				return driver.get();
	}

}
