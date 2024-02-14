package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.LogInPage;
import Pages.MenuPage;
import Retry.Retry;
import Utilities.ExcelUtility;
import Utilities.RandomUtility;

public class AdminUsersTest extends Base {
	
	@Test(retryAnalyzer = Retry.class, description = "verify that user is able to add admin users information in admin users link")
	public void verifyThatUserIsAbleToAddAdminUsersInformationInAdminUsersLink() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "AdminUsersTest");
		String password = ExcelUtility.getStringData(1, 1, "AdminUsersTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "AdminUsersTest");
		String usernameToAdd = RandomUtility.getRandomUserName();
		String passwordToAdd = ExcelUtility.getStringData(3, 1, "AdminUsersTest");
		String visibleTextOfUserType = ExcelUtility.getStringData(4, 1, "AdminUsersTest");
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUsernameOnUsernameInputField(usernameToAdd);
		adminuserspage.enterPasswordOnPassowrdInputField(passwordToAdd);
		adminuserspage.selectUserType(visibleTextOfUserType);
		adminuserspage.clickOnSaveButton();
		
		boolean isUserCreationSuccessfulAlertDisplayed = adminuserspage.isUserCreationSuccessfulAlertDisplayed();
		assertTrue(isUserCreationSuccessfulAlertDisplayed, "User is not able to add Admin Users Information in Admin Users Link");
		
	}

}
