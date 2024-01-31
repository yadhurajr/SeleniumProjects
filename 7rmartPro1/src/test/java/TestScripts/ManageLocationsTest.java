package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageLocationsPage;
import Pages.MenuPage;

public class ManageLocationsTest extends Base {
	
	@Test(description = "Verify that the User is able to add Location details in Manage Location More Info Link")
	public void verifyThatTheUserIsAbleToAddLocationInManageLocationMoreInfoLink() {
		
		String username = "admin";
		String password = "admin";
		String selectedMenu = "Manage Location";
		String location = "Abcdef";
		String deliveryCharge = "1000";
		
		String value = "230";
		String visibleText = "Cambridge";
		
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
