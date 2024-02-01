package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LogInPage;
import Utilities.ExcelUtility;

public class LogInTest extends Base {
	
	@Test(description = "Verify that the user is able to login with correct username and correct password")
	public void verifyThatTheUserIsAbleToLoginWithCorrectUsernameAndCorrectPassword() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "LogIn");
		String password = ExcelUtility.getStringData(1, 1, "LogIn");
				
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isAdminDropdownDisplayed = loginpage.isAdminDropdownButtonDisplayed();
		assertTrue(isAdminDropdownDisplayed, "User is unable to login with valid credentials");
	}
	
	@Test
	public void verifyThatTheUserIsNOTAbleToLoginWithCorrectUsernameAndIncorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(0, 1, "LogIn");
		String password = ExcelUtility.getStringData(4, 1, "LogIn");
		
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isRedAlertTextBoxDisplayed = loginpage.isRedAlertTextBoxDisplayed();
		assertTrue(isRedAlertTextBoxDisplayed, "User is able to login with invalid credentials");
		
	}
	
	@Test
	public void verifyThatTheUserIsNOTAbleToLoginWithIncorrectUsernameAndCorrectPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 1, "LogIn");
		String password = ExcelUtility.getStringData(1, 1, "LogIn");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isRedAlertTextBoxDisplayed = loginpage.isRedAlertTextBoxDisplayed();
		assertTrue(isRedAlertTextBoxDisplayed, "User is able to login with invalid credentials");
	}
	
	@Test(dataProvider ="LoginProvider")
	public void verifyThatTheUserIsNOTAbleToLoginWithIncorrectUsernameAndIncorrectPassword(String username, String password) throws IOException {

		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		boolean isRedAlertTextBoxDisplayed = loginpage.isRedAlertTextBoxDisplayed();
		assertTrue(isRedAlertTextBoxDisplayed, "User is able to login with invalid credentials");
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] { { ExcelUtility.getStringData(4, 1, "LogIn"), ExcelUtility.getStringData(3, 1, "LogIn") },

		};

}
}
