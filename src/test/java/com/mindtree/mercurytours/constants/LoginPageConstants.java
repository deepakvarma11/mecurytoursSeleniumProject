package com.mindtree.mercurytours.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * @author M1049027 Purpose: Locators for demoaut login page
 *
 */
public class LoginPageConstants {

	public WebDriver driver;

	public LoginPageConstants(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='userName']")
	@CacheLookup
	public WebElement txtUserName;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	public WebElement txtPassword;

	@FindBy(xpath = "//input[@name='login']")
	@CacheLookup
	protected WebElement bttnSignIn;

}
