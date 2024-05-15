package com.herokuapp.theinternet.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckBoxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckBoxesTests extends TestUtilities {

	@Test
	public void selectingAllCheckBoxes() {
		log.info("Starting selectingAllCheckBoxes");
		
		// Open main page
		WelcomePage welcomePage= new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//Click on check boxes
		CheckBoxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
		
		//Select all check boxes
		checkboxesPage.selectAllCheckBoxes();
		
		//Verify all check boxes are checked
		Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
	}

}
