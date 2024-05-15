package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {
	
	private By dropdownLocator = By.id("dropdown");
	
	public DropdownPage (WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/* Call method to select value of the dropdown  */
	public void selectDropdownByValue(String value) {
		log.info("Selecting value in dropdown list");
		selectDropdownValue(value, dropdownLocator);
	}
	
	/* This method returns selected option in dropdown as a string */
	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}

}
