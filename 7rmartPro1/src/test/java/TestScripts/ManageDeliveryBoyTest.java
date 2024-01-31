package TestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageDeliveryBoyPage;
import Pages.MenuPage;
import Utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
	
	@Test
	public void verifyThatUserIsAbleToGetTheDetailsOfDeliveryBoyBySearchingUsingEmailPhoneNoAndEmail() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageDeliveryBoyTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageDeliveryBoyTest");
		
		String expectedName = ExcelUtility.getStringData(2, 1, "ManageDeliveryBoyTest");
		String expectedEmail = ExcelUtility.getStringData(3, 1, "ManageDeliveryBoyTest");
		String expectedPhoneNumber = ExcelUtility.getIntegerData(4, 1, "ManageDeliveryBoyTest"); //doubt
		
		String selectedMenu = ExcelUtility.getStringData(5, 1, "ManageDeliveryBoyTest");
		
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
