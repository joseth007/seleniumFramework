package com.herokuapp.theinternet.dropdownpagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DropDownPageTests extends TestUtilities{
	
	@Test
	public void selectDropdownOption() {
		log.info("Starting selectDropDownOption");
		
		//Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		// Click on dropdownLink
		DropdownPage dropdownPage = welcomePage.clickDropdownLink();
		dropdownPage.selectDropdownByValue("1");
		
		
		//Verify option selected
		String value = dropdownPage.getSelectedOption();
		Assert.assertEquals(value, "Option 1", "The value doesn't match");
		
	}

}
