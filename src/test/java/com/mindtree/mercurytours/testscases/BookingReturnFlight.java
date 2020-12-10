package com.mindtree.mercurytours.testscases;

import org.testng.annotations.Test;
import com.mindtree.mercurytours.pages.LoginPage;
import com.mindtree.mercurytours.pages.ReturnTicketFlightPage;
import com.mindtree.mercurytours.pages.ReturnTicketSelectFlightPage;
import com.mindtree.mercurytours.reusablecomponents.DataProviderSource;
import com.mindtree.mercurytours.utility.Log;
import com.mindtree.mercurytours.utility.ReadConfiguration;

/**
 * @author M1049027 Purpose: Creating return ticket in the demoaut website by
 *         logging into the application
 *
 */
public class BookingReturnFlight extends DataProviderSource {
	
	ReadConfiguration configuration = new ReadConfiguration();
	
	String userName = configuration.readUserName();
	String password = configuration.readPassword();

public BookingReturnFlight() {
		
	}
	
	// This method used to login to the  application

	@Test(priority = 1)
	public void demoautLoginTest() {
		LoginPage login = new LoginPage(driver);
		resultList.add("----------------------------TC-1: Booking Return Ticket in Demoaut website---------------------------");
		resultList.add("----------Step 1: Logging into the demoaut application------------");
		Log.info("Demoaut application is opened successfully");
		Log.info("Enter UserName");
		login.enterUserName(userName);
		
		Log.info("Enter Password");
		login.enterPassword(password);
		
		resultList.add("1:Successfully entered userName and Password");
		
		Log.info("click on signin");
		login.clickOnSignIn();
		
		resultList.add("2:Successfully logged into the demoaut application");
	}

	// This method used to book a return flight by taking inputs from the excel
	// sheet using data provider

	@Test(dataProvider = "ReturnFlightBookingData", priority = 2)
	public void bookReturnFlight(String noOfPassengers, String departFrom, String departMonth, String departDate,
			String arrivingIn, String arrivingMonth, String arrivingDay, String airline) {
		ReturnTicketFlightPage bookReturnTicket = new ReturnTicketFlightPage(
				driver);
		
		resultList.add("Step 2: -----------------Booking a Flight-------------------");
		
		Log.info("Select types of trip");
		bookReturnTicket.clickOnTypeOfTrip();
		resultList.add("1: Selected types of trip");
		
		Log.info("Select number of passengers");
		bookReturnTicket.selectNoOfPassengers(noOfPassengers);	
		resultList.add("2: Selected number of passengers");
		
		Log.info("Select departure flight destination");
		bookReturnTicket.selectDepartingFlightFrom(departFrom);
		resultList.add("3: Selected departure flight destination");
		
		Log.info("Select departure Fligh month");
		bookReturnTicket.selectDepartingOnMonth(departMonth);
		resultList.add("4: Selected departure Fligh month");
		
		Log.info("select departure Flight date");
		bookReturnTicket.selectDepartingOnDay(departDate);
		resultList.add("5: selected departure Flight date");
		
		Log.info("Select Arrival flight destination");
		bookReturnTicket.selectArrivingFlightIn(arrivingIn);
		resultList.add("6: Selected Arrival flight destination");
		
		Log.info("Select arrivaing Flight month");
		bookReturnTicket.selectArrivingOnMonth(arrivingMonth);
		resultList.add("7: Selected arrivaing Flight month");
		
		Log.info("Select arriving flight day");
		bookReturnTicket.selectArrivingOnDate(arrivingDay);	
		resultList.add("8: Selected arriving flight day");
		
		Log.info("Click on the sevice class--business");
		bookReturnTicket.clickOnServiceClass();		
		resultList.add("9: Clicked on the sevice class--business");
		
		Log.info("Select the airline");
		bookReturnTicket.selectAirline(airline);	
		resultList.add("10: Selected the airline");
		
		Log.info("Click on find flights button");
		bookReturnTicket.clickOnFindFlights();
		resultList.add("11: Clicked on find flights button");
	}

	// This method used to select a flight for returning.

	@Test(priority = 3)
	public void selectFlight() {
		
		ReturnTicketSelectFlightPage selectFlight = new ReturnTicketSelectFlightPage(
				driver);
		
		resultList.add("Step 3: --------------------------------------Select a Flight-----------------------");
		
		Log.info("click on departure flight");
		selectFlight.clickOnDepartureFlight();
		resultList.add("1: click on departure flight");
		
		Log.info("Clicked on Return Flight");
		selectFlight.clickOnReturnFlight();	
		resultList.add("2: Clicked on Return Flight");
		
		Log.info("Clicked on continue");
		selectFlight.clickOnContinue();	
		resultList.add("3: Clicked on continue");
	}

	// This method used to validate whether return ticket has been booked or not.

	@Test(priority = 4)
	public void vaidateReturnTicket() {
		Log.info("Validating Whether Return ticket has been booked or not");
		resultList.add("Step 4: Validating Whether Return ticket has been booked or not");
		if (driver.getPageSource().contains("New York to Paris") && driver.getPageSource().contains("7/9/2019")) {
			if (driver.getPageSource().contains("Paris to New York") && driver.getPageSource().contains("8/4/2019")) {
				Log.info("Return Ticket has Been booked Successfully. Thank You!");
				resultList.add("Return Ticket has Been booked Successfully. Thank You!");
			} else {
				Log.info("Return Ticket has not been booked, Try to book once again");
				resultList.add("Return Ticket has not been booked, Try to book once again");
			}
		} else {
			Log.info("Return Ticket has not been booked, Try to book once again");
			resultList.add("Return Ticket has not been booked, Try to book once again");
		}
		driver.close();
	}
}
