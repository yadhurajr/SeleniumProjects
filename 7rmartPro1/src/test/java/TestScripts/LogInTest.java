package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Utilities.ExcelUtility;

public class LogInTest extends Base {
	
	@Test(description = "Verify that the user is able to login with correct username and correct password")
	public void verifyThatTheUserIsAbleToLoginWithCorrectUsernameAndCorrectPassword() {
		
		String username = ExcelUtility.getString(1, 0, "LogIn");
		String password = "admin";
		
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isAdminDropdownDisplayed = loginpage.isAdminDropdownButtonDisplayed();
		assertTrue(isAdminDropdownDisplayed, "User is unable to login with valid credentials");
	}
	
	@Test
	public void verifyThatTheUserIsNOTAbleToLoginWithCorrectUsernameAndIncorrectPassword() {
		String username = "admin";
		String password = "incorrectPassword";
		
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isRedAlertTextBoxDisplayed = loginpage.isRedAlertTextBoxDisplayed();
		assertTrue(isRedAlertTextBoxDisplayed, "User is able to login with invalid credentials");
		
	}
	
	@Test
	public void verifyThatTheUserIsNOTAbleToLoginWithIncorrectUsernameAndCorrectPassword() {
		String username = "incorrectUsername";
		String password = "admin";
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isRedAlertTextBoxDisplayed = loginpage.isRedAlertTextBoxDisplayed();
		assertTrue(isRedAlertTextBoxDisplayed, "User is able to login with invalid credentials");
	}
	
	@Test
	public void verifyThatTheUserIsNOTAbleToLoginWithIncorrectUsernameAndIncorrectPassword() {
		String username = "incorrectUsername";
		String password = "incorrectPassword";
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isRedAlertTextBoxDisplayed = loginpage.isRedAlertTextBoxDisplayed();
		assertTrue(isRedAlertTextBoxDisplayed, "User is able to login with invalid credentials");
	}

}
