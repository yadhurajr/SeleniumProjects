package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageOfferCodePage;
import Pages.MenuPage;

public class ManageOfferCodeTest extends Base {
	
	@Test(description = "Verify that user is able to add offer code by uploading image in manage offer code link")
	public void verifyThatUserIsAbleToAddOfferCodeInManageOfferCodeMoreInfoLink() {
		
		String username = "admin";
		String password = "admin";
		String selectedMenu = "Manage Offer Code";
		String offerCode = "X100RIZZ";
		String percentage = "30%";
		String amount = "500";
		String description = "New Year Offer";
		
		
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
