package com.mindtree.mercurytours.pages;

import org.openqa.selenium.WebDriver;

import com.mindtree.mercurytours.constants.LoginPageConstants;

/**
 * @author M1049027 Purpose: Methods to access the locators and by using these
 *         methods, sending the inputs to the application for login purpose
 *
 */
public class LoginPage extends LoginPageConstants {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickOnSignIn() {
		bttnSignIn.click();
	}

}
