package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageExpensePage;
import Utilities.ExcelUtility;

public class ManageExpenseTest extends Base {
	
	@Test(description = "Verify that the user is able to add expense and upload image in Manage Expense Link")
	public void verifyThatUserIsAbleToAddExpenseAndUploadImageInManageExpenseTest() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageExpenseTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageExpenseTest");
		//String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageExpenseTest");
		String visibleTextOfUserId = ExcelUtility.getStringData(3, 1, "ManageExpenseTest");
//		String date = ExcelUtility.getStringData(4, 1, "ManageExpenseTest");
		String visibleTextOfCategory = ExcelUtility.getStringData(5, 1, "ManageExpenseTest");
		String visibleTextOfOrderId = ExcelUtility.getIntegerData(6, 1, "ManageExpenseTest");
		String visibleTextOfPurchaseId = ExcelUtility.getIntegerData(7, 1, "ManageExpenseTest");
		String visibleTextOfExpenseType = ExcelUtility.getStringData(8, 1, "ManageExpenseTest");
		String amount = ExcelUtility.getIntegerData(9, 1, "ManageExpenseTest");
		String remarks = ExcelUtility.getStringData(10, 1, "ManageExpenseTest");
		
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
//		manageexpensepage.enterDateInDateInputField(date);
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
