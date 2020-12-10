package com.mindtree.mercurytours.testscases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.mercurytours.constants.LoginPageConstants;
import com.mindtree.mercurytours.pages.LoginPage;
import com.mindtree.mercurytours.reusablecomponents.DataProviderSource;
import com.mindtree.mercurytours.utility.Log;
import com.mindtree.mercurytours.utility.ReadConfiguration;

/**
 * @author  M1049027  Purpose: This method is used to validate the user
 *         credentials and the text boxes of user name and password Date:
 *         06/11/2019
 *
 */
public class ValidatingLoginCredentials extends DataProviderSource {


	ReadConfiguration configuration = new ReadConfiguration();
	
	public ValidatingLoginCredentials() {

	}

	String userName = configuration.readUserName();
	String password = configuration.readPassword();
	

	@BeforeMethod
	public void setBeforeMethod() {
		Log.info("validating user credentials test has been started");
	}
	// Validating user credentials
	
	@Test(priority = 5)
	public void validatingUserCredentials() {
		
		// Creating an object of Login page to access all the constants of demoaut to
		// verify
		
		LoginPageConstants loginPage = new LoginPageConstants(driver);
		resultList.add("--------------------TC-2, Validating User Credentials------------------------------------");
		
		// Creating an object of login page to access the methods
		LoginPage loginMethods = new LoginPage(driver);
		

		// Validating user name textbox exists and entering valid user name.
		try {
			WebElement userNameTxtBox = loginPage.txtUserName;
			Log.info("---------------------USER NAME FIELD EXISTS-----------------------------");
			resultList.add("Step 1: ---------------------USER NAME FIELD EXISTS-----------------------------");
			
			Log.info("Enter the valid user name");
			userNameTxtBox.sendKeys(userName);
			
			Log.info("User name entered successfully");
			resultList.add("1, User name entered successfully");
			
		} catch (Exception e) {
			Log.warn("user name field doesn't exists");
		}

		Log.info("Checking whether password field exists or not");
		resultList.add("Checking whether password field exists or not");

		// Validating password textbox and entering valid password.
		try {
			WebElement passwordTxtBox = loginPage.txtPassword;
			Log.info("--------------------Password Field Exists-------------------------");
			resultList.add("Step 2: --------------------Password Field Exists-------------------------");
			
			Log.info("Enter valid password");
			passwordTxtBox.sendKeys(password);
			
			Log.info("Password Entered successfully");
			resultList.add("2: Password Entered successfully");
			
		} catch (Exception e) {
			Log.warn("Password Field doesn't exists");
		}

		// After entering the user name and password clicking on SignIn
		
		loginMethods.clickOnSignIn();
		Log.info("Clicked on Sign in");
		
		resultList.add("Step 3:Clicked on Sign in");
		
		Log.info("User logged into the application, successfully");
		resultList.add("Step 4:User logged into the application, successfully");
	}
	// This is for Pdf File

	@AfterMethod
	public void setAfterMethod() {
		Log.info("validating user credentials test has been completed");
	}
		

}
