package TestScripts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageExpensePage;

public class ManageExpenseTest extends Base {
	
	@Test(description = "Verify that the user is able to add expense and upload image in Manage Expense Link")
	public void verifyThatUserIsAbleToAddExpenseAndUploadImageInManageExpenseTest() {
		
		String username = "admin";
		String password = "admin";
		//String selectedMenu = "Manage Expense";
		String visibleTextOfUserId = "232(Staff)";
		String date = "30-01-2024";
		String visibleTextOfCategory = "FruitNew";
		String visibleTextOfOrderId = "7";
		String visibleTextOfPurchaseId = "17";
		String visibleTextOfExpenseType = "Debit Cash";
		String amount = "8500";
		String remarks = "Lion's image";
		
		LogInPage loginpage = new LogInPage(driver);
		//MenuPage menupage = new MenuPage(driver);
		ManageExpensePage manageexpensepage = new ManageExpensePage(driver);
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		//menupage.clickOnMenu(selectedMenu);
		manageexpensepage.clickOnMoreInfoLink();
		manageexpensepage.clickOnNewButton();
		manageexpensepage.selectUserId(visibleTextOfUserId);
		manageexpensepage.enterDateInDateInputField(date);
		manageexpensepage.selectCategory(visibleTextOfCategory);
		manageexpensepage.selectOrderId(visibleTextOfOrderId);
		manageexpensepage.selectPurchaseId(visibleTextOfPurchaseId);
		manageexpensepage.selectExpenseType(visibleTextOfExpenseType);
		manageexpensepage.enterAmountInAmountInputField(amount);
		manageexpensepage.enterRemarksInRemarksInputField(remarks);
		manageexpensepage.uploadFile();
		manageexpensepage.clickOnSaveButton();
		
		
		
		boolean isSuccessfullAlertPopupDisplayed = manageexpensepage.issuccessfullAlertPopupDisplayed();
		assertTrue(isSuccessfullAlertPopupDisplayed, "User is not able to add expense and upload image in Manage Expense Link");	
	}
	
}
