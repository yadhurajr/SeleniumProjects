package TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageOfferCodePage;
import Pages.MenuPage;
import Retry.Retry;
import Utilities.ExcelUtility;
import Utilities.RandomUtility;

public class ManageOfferCodeTest extends Base {
	
	private String offerCode1;
	private String percentage1;
	private String amount1;
	
	private String offerCode2;
	private String percentage2;
	private String amount2;
	
	@Test(retryAnalyzer = Retry.class, description = "Verify that user is able to add offer code informations by uploading image in manage offer code link as First Order User", priority = 1, groups = {"Smoke"})
	public void verifyThatUserIsAbleToAddOfferCodeInformationsInManageOfferCodeMoreInfoLinkAsFirstOrderUser() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageOfferCodeTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageOfferCodeTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageOfferCodeTest");
		offerCode1 = RandomUtility.getRandomOfferCode();
		percentage1 = ExcelUtility.getIntegerData(3, 1, "ManageOfferCodeTest");
		amount1 = ExcelUtility.getIntegerData(4, 1, "ManageOfferCodeTest");
		String description = ExcelUtility.getStringData(5, 1, "ManageOfferCodeTest");
		
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOfferCodePage manageoffercodepage = new ManageOfferCodePage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		manageoffercodepage.clickOnNewButton();
		manageoffercodepage.enterOfferCodeInOfferCodeInputField(offerCode1);
		manageoffercodepage.clickOnFirstOrderUserYesRadioButton();
		manageoffercodepage.enterPercentageOnPercentageField(percentage1);
		manageoffercodepage.enterAmountOnAmountInputField(amount1);
		manageoffercodepage.enterDescriptionOnDescriptionInputField(description);
		manageoffercodepage.uploadImage();
		manageoffercodepage.clickOnSaveButton();
		boolean isSuccessfullAlertPopupDisplayed = manageoffercodepage.issuccessfullAlertPopupDisplayed();
		assertTrue(isSuccessfullAlertPopupDisplayed, "User is not able to add offer code by uploading image in manage offer code link");	
	}
	
	@Test(retryAnalyzer = Retry.class, description = "Verify that user is able to search offer code details of First Order User by searching offer code", priority = 2, groups = {"Smoke"})
	public void verifyThatUserIsAbleToSearchOfferCodeDetailsOfFirstOrderUserBySearchingtheOfferCode() throws IOException {
		String username = ExcelUtility.getStringData(0, 1, "ManageOfferCodeTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageOfferCodeTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageOfferCodeTest");
		
		String expectedOfferCode = offerCode1;
		String expectedPercentage = percentage1;
		String expectedAmount = amount1;
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOfferCodePage manageoffercodepage = new ManageOfferCodePage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		
		manageoffercodepage.clickOnBlueSearchButton();
		manageoffercodepage.enterOfferCodeOnOfferCodeInputfieldToSearch(expectedOfferCode);
		manageoffercodepage.clickOnRedSearchButton();
		
		List<String> actualDetails = manageoffercodepage.getDetailsOfSecondRow();
        assertEquals(actualDetails.get(0), expectedOfferCode + " (First Order)", "Offer Code verification failed!");
        assertEquals(actualDetails.get(1), expectedPercentage + "%", "Percentage verification failed!");
        assertEquals(actualDetails.get(2), "£" + expectedAmount, "Amount verification failed!");
				
	}
	
	@Test(retryAnalyzer = Retry.class, description = "Verify that user is able to add offer code informations by uploading image in manage offer code link NOT as First Order User", priority = 3)
	public void verifyThatUserIsAbleToAddOfferCodeInManageOfferCodeMoreInfoLinkNotAsFirstOrderUser() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageOfferCodeTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageOfferCodeTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageOfferCodeTest");
		offerCode2 = RandomUtility.getRandomOfferCode();
		percentage2 = ExcelUtility.getIntegerData(3, 1, "ManageOfferCodeTest");
		amount2 = ExcelUtility.getIntegerData(4, 1, "ManageOfferCodeTest");
		String description = ExcelUtility.getStringData(5, 1, "ManageOfferCodeTest");
		
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOfferCodePage manageoffercodepage = new ManageOfferCodePage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		manageoffercodepage.clickOnNewButton();
		manageoffercodepage.enterOfferCodeInOfferCodeInputField(offerCode2);
		manageoffercodepage.clickOnFirstOrderUserNoRadioButton();
		manageoffercodepage.enterPercentageOnPercentageField(percentage2);
		manageoffercodepage.enterAmountOnAmountInputField(amount2);
		manageoffercodepage.enterDescriptionOnDescriptionInputField(description);
		manageoffercodepage.uploadImage();
		manageoffercodepage.clickOnSaveButton();
		boolean isSuccessfullAlertPopupDisplayed = manageoffercodepage.issuccessfullAlertPopupDisplayed();
		assertTrue(isSuccessfullAlertPopupDisplayed, "User is not able to add offer code by uploading image in manage offer code link");	
	}
	
	@Test(retryAnalyzer = Retry.class, description = "Verify that user is able to search offer code details of not a First Order User by searching offer code", priority = 4)
	public void verifyThatUserIsAbleToSearchOfferCodeDetailsOfNotAFirstOrderUserBySearchingtheOfferCode() throws IOException {
		String username = ExcelUtility.getStringData(0, 1, "ManageOfferCodeTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageOfferCodeTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageOfferCodeTest");
		
		String expectedOfferCode = offerCode2;
		String expectedPercentage = percentage2;
		String expectedAmount = amount2;
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOfferCodePage manageoffercodepage = new ManageOfferCodePage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		
		manageoffercodepage.clickOnBlueSearchButton();
		manageoffercodepage.enterOfferCodeOnOfferCodeInputfieldToSearch(expectedOfferCode);
		manageoffercodepage.clickOnRedSearchButton();
		
		List<String> actualDetails = manageoffercodepage.getDetailsOfSecondRow();
        assertEquals(actualDetails.get(0), expectedOfferCode, "Offer Code verification failed!");
        assertEquals(actualDetails.get(1), expectedPercentage + "%", "Percentage verification failed!");
        assertEquals(actualDetails.get(2), "£" + expectedAmount, "Amount verification failed!");
				
	}

}
