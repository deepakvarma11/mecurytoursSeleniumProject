package com.mindtree.mercurytours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.mercurytours.constants.ReturnTicketFlightDetailsPageConstants;

/**
 * @author M1049027 purpose: Methods to access locators and to book return
 *         ticket, inputs fetched from excel sheet and sending to the demoaut
 *         application.
 *
 */
public class ReturnTicketFlightPage extends ReturnTicketFlightDetailsPageConstants {

	public ReturnTicketFlightPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnTypeOfTrip() {
		tripTypeRdoBttn.click();
	}

	public void selectNoOfPassengers(String noOfPassenger) {
		Select passengers = new Select(noOfPassengersddl);
		passengers.selectByVisibleText(noOfPassenger);
	}

	public void selectDepartingFlightFrom(String departureFlightDestination) {
		Select departingFlight = new Select(departingFromddl);
		departingFlight.selectByVisibleText(departureFlightDestination);
	}

	public void selectDepartingOnMonth(String month) {
		Select departingOnMonth = new Select(onMonthddl);
		departingOnMonth.selectByVisibleText(month);
	}

	public void selectDepartingOnDay(String day) {
		Select departingOnDay = new Select(onDayddl);
		departingOnDay.selectByVisibleText(day);
	}

	public void selectArrivingFlightIn(String arrivingDestination) {
		Select arrivingIn = new Select(arrivingInddl);
		arrivingIn.selectByVisibleText(arrivingDestination);
	}

	public void selectArrivingOnMonth(String arriveMonth) {
		Select arrivingMonth = new Select(returningOnMonthddl);
		arrivingMonth.selectByVisibleText(arriveMonth);
	}

	public void selectArrivingOnDate(String arriveDate) {
		Select arrivingDate = new Select(returningOnDayddl);
		arrivingDate.selectByVisibleText(arriveDate);
	}

	public void clickOnServiceClass() {
		serviceClassRdoBttn.click();
	}

	public void selectAirline(String airline) {
		Select FlightNo = new Select(airlineDropDown);
		FlightNo.selectByVisibleText(airline);
	}

	public void clickOnFindFlights() {
		clickOnFindFlightsBttn.click();
	}

}
