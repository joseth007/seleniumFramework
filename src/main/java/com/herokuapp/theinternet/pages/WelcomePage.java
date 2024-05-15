package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject{
	
	private String pageUrl = "http://the-internet.herokuapp.com/";
	
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
	
	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/* Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page Opened!");
	}
	
	/* Open LoginPage by Clicking on form Authentication Link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
	
	/* Open CheckBoxesPage by Clicking on Checkboxes Link */
	public CheckBoxesPage clickCheckboxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkBoxesLinkLocator);
		return new CheckBoxesPage(driver, log);
	}
	
	/* Open DropdownPage by Clicking on Dropdown Link */
	public DropdownPage clickDropdownLink() {
		log.info("Clicking Dropdown link on Welcome Page");
		click(dropdownLinkLocator);
		return new DropdownPage(driver, log);
	}
	
	/* Open MultipleWindoesPage by Clicking on Miltuple Windows Link*/
	public WindowsPage clickMultipleWindowsLink() {
		log.info("Clicking Multiple Windows link on Welcome Page");
		click(multipleWindowsLinkLocator);
		return new WindowsPage(driver, log);
	}
	
	/* Open JavaScriptsAlertsPage by Clicking on JavaScrip Alerts Link*/
	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
		log.info("Clicking JavaScript Alerts link on Welcome Page");
		click(javaScriptAlertsLinkLocator);
		return new JavaScriptAlertsPage(driver, log);
	}
	
	/** Switch to alert and get it's message */
	public String getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		log.info("Alert says: " + alertText);
		return alertText;
	}

	/** Switch to alert and press OK */
	public void acceptAlert() {
		log.info("Switching to alert and pressing OK");
		Alert alert = switchToAlert();
		alert.accept();
	}

	/** Switch to alert and press Cancel */
	public void dismissAlert() {
		log.info("Switching to alert and pressing Cancel");
		Alert alert = switchToAlert();
		alert.dismiss();
	}

	/** Type text into alert and press OK */
	public void typeTextIntoAlert(String text) {
		log.info("Typing text into alert and pressing OK");
		Alert alert = switchToAlert();
		alert.sendKeys(text);
		alert.accept();
	}

}
