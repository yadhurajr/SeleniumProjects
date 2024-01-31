package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageSliderPage;
import Pages.MenuPage;
import Utilities.ExcelUtility;

public class ManageSliderTest extends Base {
	
	@Test(description = "Verify that the user is able to upload image in Manage Slider Link")
	public void verifyThatUserIsAbleToUploadImageInManageSliderLink() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageSliderTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageSliderTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageSliderTest");
		String linkText = ExcelUtility.getStringData(3, 1, "ManageSliderTest");
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageSliderPage managesliderpage = new ManageSliderPage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		managesliderpage.clickOnNewButton();
		managesliderpage.uploadImage();
		managesliderpage.enterLinkOnLinkTextField(linkText);
		managesliderpage.clickOnSaveButton();
		boolean isSuccessfullAlertPopupDisplayed = managesliderpage.isSuccessfullAlertPopupDisplayed();
		assertTrue(isSuccessfullAlertPopupDisplayed, "User is not able to upload image in Manage Slider Link");	
	}
}
