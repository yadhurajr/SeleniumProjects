package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageOfferCodePage;
import Pages.MenuPage;
import Utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base {
	
	@Test(description = "Verify that user is able to add offer code by uploading image in manage offer code link")
	public void verifyThatUserIsAbleToAddOfferCodeInManageOfferCodeMoreInfoLink() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageOfferCodeTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageOfferCodeTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageOfferCodeTest");
		String offerCode = ExcelUtility.getStringData(3, 1, "ManageOfferCodeTest");
		String percentage = ExcelUtility.getIntegerData(4, 1, "ManageOfferCodeTest");
		String amount = ExcelUtility.getIntegerData(5, 1, "ManageOfferCodeTest");
		String description = ExcelUtility.getStringData(6, 1, "ManageOfferCodeTest");
		
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOfferCodePage manageoffercodepage = new ManageOfferCodePage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		manageoffercodepage.clickOnNewButton();
		manageoffercodepage.enterOfferCodeInOfferCodeInputField(offerCode);
		manageoffercodepage.clickOnFirstCodeUserRadioButton();
		manageoffercodepage.enterPercentageOnPercentageField(percentage);
		manageoffercodepage.enterAmountOnAmountInputField(amount);
		manageoffercodepage.enterDescriptionOnDescriptionInputField(description);
		manageoffercodepage.uploadImage();
		manageoffercodepage.clickOnSaveButton();
		boolean isSuccessfullAlertPopupDisplayed = manageoffercodepage.issuccessfullAlertPopupDisplayed();
		assertTrue(isSuccessfullAlertPopupDisplayed, "User is not able to add offer code by uploading image in manage offer code link");	
	}

}
