package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageSliderPage;
import Pages.MenuPage;

public class ManageSliderTest extends Base {
	
	@Test(description = "Verify that the user is able to upload image in Manage Slider Link")
	public void verifyThatUserIsAbleToUploadImageInManageSliderLink() {
		
		String username = "admin";
		String password = "admin";
		String selectedMenu = "Manage Slider";
//		String filepath = "C:\\Users\\HP\\Documents\\Lion.jpg";
		String linkText = "https://wiki/File:Lion.jpg";
		
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
