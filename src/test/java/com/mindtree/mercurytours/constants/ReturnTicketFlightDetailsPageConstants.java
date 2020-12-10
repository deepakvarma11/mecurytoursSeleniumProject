package com.mindtree.mercurytours.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author M1049027 Purpose: Locators for booking return ticket
 *
 */
public class ReturnTicketFlightDetailsPageConstants {

	public WebDriver driver;

	public ReturnTicketFlightDetailsPageConstants(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='roundtrip']")
	@CacheLookup
	protected WebElement tripTypeRdoBttn;

	@FindBy(name = "passCount")
	@CacheLookup
	protected WebElement noOfPassengersddl;

	@FindBy(name = "fromPort")
	@CacheLookup
	protected WebElement departingFromddl;

	@FindBy(name = "fromMonth")
	@CacheLookup
	protected WebElement onMonthddl;

	@FindBy(name = "fromDay")
	@CacheLookup
	protected WebElement onDayddl;

	@FindBy(name = "toPort")
	@CacheLookup
	protected WebElement arrivingInddl;

	@FindBy(name = "toMonth")
	@CacheLookup
	protected WebElement returningOnMonthddl;

	@FindBy(name = "toDay")
	@CacheLookup
	protected WebElement returningOnDayddl;

	@FindBy(xpath = "//input[@value='Business']")
	@CacheLookup
	protected WebElement serviceClassRdoBttn;

	@FindBy(name = "airline")
	@CacheLookup
	protected WebElement airlineDropDown;

	@FindBy(xpath = "//input[@name='findFlights']")
	@CacheLookup
	protected WebElement clickOnFindFlightsBttn;

}
