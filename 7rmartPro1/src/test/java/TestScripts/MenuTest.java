package TestScripts;

import org.testng.annotations.Test;

import Pages.LogInPage;
import Pages.MenuPage;

public class MenuTest extends Base {
	
	@Test
	public void verifyWhetherTheSelectedMenuTilesAreDisplayed()
	
	{
		String userName = "admin";
		String password = "admin";
		String selectedMenu = "Manage Expense";
		
		LogInPage loginpage=new LogInPage(driver);
		loginpage.enterUsernameOnUsernameInputField(userName);
		loginpage.enterPasswordOnPasswordInputField(password);
		loginpage.clickOnSignInButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenu(selectedMenu);
	}

}
