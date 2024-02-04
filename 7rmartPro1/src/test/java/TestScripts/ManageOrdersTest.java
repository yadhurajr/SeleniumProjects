package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.ManageOrdersPage;
import Pages.MenuPage;
import Utilities.ExcelUtility;

public class ManageOrdersTest extends Base {
	
	@Test(description = "Verify that the user is able to change delivery date or time")
	public void verifyThatTheUserIsAbleToChangeDeliveryDateOrTime() throws IOException {	

		String username = ExcelUtility.getStringData(0, 1, "ManageOrdersTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageOrdersTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageOrdersTest");
		
		String startTime = ExcelUtility.getStringData(3, 1, "ManageOrdersTest");
		String endTime = ExcelUtility.getStringData(4, 1, "ManageOrdersTest");
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOrdersPage manageorderspage = new ManageOrdersPage(driver);
		
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		
		manageorderspage.clickOnChangeDeliveryDateButton();
		manageorderspage.enterStartTimeOnStartTimeInputField(startTime);
		manageorderspage.enterEndTimeOnDateEndTimeInputField(endTime);
		manageorderspage.clickOnUpdateButtonForChangingDeliveryDate();
		
		boolean isSuccessfulAlertMessageDisplayedForChangingDeliveryDate = manageorderspage.isSuccessfulAlertMessageDisplayedForChangingDeliveryDate();
		assertTrue(isSuccessfulAlertMessageDisplayedForChangingDeliveryDate, "User is not able to change delivery date or time to Order ID");
	}
	
	@Test(description = "Verify that the user is able to assign delivery boy to Order ID")
	public void verifyThatUserIsAbleToAssignDeliveryBoy() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 1, "ManageOrdersTest");
		String password = ExcelUtility.getStringData(1, 1, "ManageOrdersTest");
		String selectedMenu = ExcelUtility.getStringData(2, 1, "ManageOrdersTest");
		
		String visibleTextOfUserId = ExcelUtility.getStringData(5, 1, "ManageOrdersTest");
		
		LogInPage loginpage = new LogInPage(driver);
		MenuPage menupage = new MenuPage(driver);
		ManageOrdersPage manageorderspage = new ManageOrdersPage(driver);
		
		loginpage.enterUsernameOnUsernameInputField(username);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		
		manageorderspage.clickOnAssignDeliveryBoyButton();
		manageorderspage.selectDeliveryBoy(visibleTextOfUserId);
		manageorderspage.clickOnUpdateButtonForAssigningDeliveryBoy();
		
		boolean isSuccessfulAlertMessageDisplayedForAssigningDeliveryBoy = manageorderspage.isSuccessfulAlertMessageDisplayedForAssigningDeliveryBoy();
		assertTrue(isSuccessfulAlertMessageDisplayedForAssigningDeliveryBoy, "User is not able to assign delivery boy to order ID");
	
	}

}
