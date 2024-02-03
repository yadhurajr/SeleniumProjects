package TestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageDeliveryBoyPage;
import Pages.MenuPage;
import Utilities.ExcelUtility;
import Utilities.RandomUtility;

public class ManageDeliveryBoyTest extends Base {
	
	private String nameToAdd;
    private String emailToAdd;
    private String phnNoToAdd;
	
	@Test(description = "Verify that user is able to add delivery boy informations", priority = 1)
	public void verifyThatUserIsAbleToAddDeliveryBoyInformations() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageDeliveryBoyTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageDeliveryBoyTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageDeliveryBoyTest");
		
		nameToAdd = RandomUtility.getRandomFullName();
		emailToAdd = RandomUtility.getRandomFirstName() + "@gmail.com";
		phnNoToAdd = RandomUtility.getRandomPhoneNumber();
		String addressToAdd = RandomUtility.getRandomAddress();
		String usernameToAdd = RandomUtility.getRandomUserName();
		String passwordToAdd = usernameToAdd + "@123";
		
		LogInPage loginpage = new LogInPage(driver);
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		MenuPage menupage = new MenuPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		managedeliveryboypage.clickOnNewButton();
		managedeliveryboypage.enterNameOnNameInputFieldToAddNewDeliveryBoyInformations(nameToAdd);
		managedeliveryboypage.enterEmailOnEmailInputFieldToAddNewDeliveryBoyInformations(emailToAdd);
		managedeliveryboypage.enterPhnNoOnPhnNoInputFieldToAddNewDeliveryBoyInformations(phnNoToAdd);
		managedeliveryboypage.enterAddressOnAddressInputFieldToAddNewDeliveryBoyInformations(addressToAdd);
		managedeliveryboypage.enterUsernameOnUsernameInputFieldToAddNewDeliveryBoyInformations(usernameToAdd);
		managedeliveryboypage.enterPasswordOnPasswordInputFieldToAddNewDeliveryBoyInformations(passwordToAdd);
		managedeliveryboypage.clickOnSaveButton();
		
		List<String> actualDetails = managedeliveryboypage.getDetailsOfSecondRow();
        assertEquals(actualDetails.get(0), nameToAdd, "Name verification failed!");
        assertEquals(actualDetails.get(1), emailToAdd, "Email verification failed!");
        assertEquals(actualDetails.get(2), phnNoToAdd, "Phone Number verification failed!");
        //assertEquals(actualDetails.get(3), addressToAdd, "Address verification failed!");
        assertEquals(actualDetails.get(4), usernameToAdd, "Username verification failed!");
		
	}
	
	@Test(description = "Verify that user is able to get the details of delivery boy by searching using name, email and phone number", priority = 2)
	public void verifyThatUserIsAbleToGetTheDetailsOfDeliveryBoyBySearchingUsingNameEmailAndPhoneNo() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageDeliveryBoyTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageDeliveryBoyTest");
		
		String expectedName = nameToAdd;
        String expectedEmail = emailToAdd;
        String expectedPhoneNumber = phnNoToAdd;
		
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageDeliveryBoyTest");
		
		LogInPage loginpage = new LogInPage(driver);
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		MenuPage menupage = new MenuPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
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
