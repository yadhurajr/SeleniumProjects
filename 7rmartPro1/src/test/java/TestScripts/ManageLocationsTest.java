package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageLocationsPage;
import Pages.MenuPage;
import Utilities.ExcelUtility;

public class ManageLocationsTest extends Base {
	
	@Test(description = "Verify that the User is able to add Location details in Manage Location More Info Link")
	public void verifyThatTheUserIsAbleToAddLocationInManageLocationMoreInfoLink() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageLocationsTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageLocationsTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageLocationsTest");
		String location = ExcelUtility.getStringData(3, 1, "ManageLocationsTest");
		String deliveryCharge = ExcelUtility.getIntegerData(4, 1, "ManageLocationsTest");
		
		String value = ExcelUtility.getIntegerData(5, 1, "ManageLocationsTest");
		String visibleText = ExcelUtility.getStringData(6, 1, "ManageLocationsTest");
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageLocationsPage managelocationspage = new ManageLocationsPage(driver);
		
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		
		menupage.clickOnMenu(selectedMenu);
		managelocationspage.clickOnNewButton();
		managelocationspage.selectCountry(value);
		managelocationspage.selectState(visibleText);
		managelocationspage.enterLocationInLocationInputField(location);
		managelocationspage.enterDeliveryChargeInDeliveryChargeField(deliveryCharge);
		managelocationspage.clickOnSaveButton();
		boolean islocationCreatedSuccessfullyAlertPopupDisplayed = managelocationspage.islocationCreatedSuccessfullyAlertPopupDisplayed();
		assertTrue(islocationCreatedSuccessfullyAlertPopupDisplayed, "User is not able to add Location details in Manage Location More Info Link");
		
		
		
	}
}
