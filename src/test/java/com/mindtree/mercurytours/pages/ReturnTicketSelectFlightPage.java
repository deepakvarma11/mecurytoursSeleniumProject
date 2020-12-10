package com.mindtree.mercurytours.pages;

import org.openqa.selenium.WebDriver;

import com.mindtree.mercurytours.constants.ReturnTicketFlightSelectPageConstants;

/**
 * @author M1049027 Purpose: Methods to access the locators to select the flight
 *
 */
public class ReturnTicketSelectFlightPage extends ReturnTicketFlightSelectPageConstants {

	public ReturnTicketSelectFlightPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnDepartureFlight() {
		departFlightRdoBttn.click();
	}

	public void clickOnReturnFlight() {
		returnFlightRdoBttn.click();
	}

	public void clickOnContinue() {
		clickOnContinueBttn.click();
	}

}
