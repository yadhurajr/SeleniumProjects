package TestScripts;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageDeliveryBoyPage;
import Pages.MenuPage;

public class ManageDeliveryBoyTest extends Base {
	
	@Test
	public void verifyThatUserIsAbleToGetTheDetailsOfDeliveryBoyBySearchingUsingEmailPhoneNoAndEmail() {
		
		String username = "admin";
		String password = "admin";
		
		String expectedName = "Andre Bashirian";
		String expectedEmail = "Sunny@gmail.com";
		String expectedPhoneNumber = "8915019834";
		
		String selectedMenu = "Manage Delivery Boy";
		
		LogInPage loginpage = new LogInPage(driver);
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		MenuPage menupage = new MenuPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
//		managedeliveryboypage.clickOnManageDeliveryBoyMoreInfoLink();
		menupage.clickOnMenu(selectedMenu);
		managedeliveryboypage.clickOnBlueSearchButtonLink();
		managedeliveryboypage.enterNameOnNameInputField(expectedName);
		managedeliveryboypage.enterPhoneNumberOnPhoneNumberInputField(expectedPhoneNumber);
		managedeliveryboypage.enterEmailOnEmailInputField(expectedEmail);
		managedeliveryboypage.clickOnRedSearchButtonLink();
		
		List<String> actualDetails = managedeliveryboypage.getDetailsOfSecondRow();
        assertEquals(actualDetails.get(0), expectedName, "Name verification failed!");
        assertEquals(actualDetails.get(1), expectedEmail, "Email verification failed!");
        assertEquals(actualDetails.get(2), expectedPhoneNumber, "Phone Number verification failed!");
	}

}
