package com.mindtree.mercurytours.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author M1049027 Purpose: Locators for selecting a flight in demoaut website
 *
 */
public class ReturnTicketFlightSelectPageConstants {

	public WebDriver driver;

	public ReturnTicketFlightSelectPageConstants(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='outFlight' and @value='Blue Skies Airlines$361$271$7:10']")
	@CacheLookup
	protected WebElement departFlightRdoBttn;

	@FindBy(xpath = "//input[@name='inFlight' and @value='Blue Skies Airlines$631$273$14:30']")
	@CacheLookup
	protected WebElement returnFlightRdoBttn;

	@FindBy(xpath = "//input[@name='reserveFlights']")
	@CacheLookup
	protected WebElement clickOnContinueBttn;

}
