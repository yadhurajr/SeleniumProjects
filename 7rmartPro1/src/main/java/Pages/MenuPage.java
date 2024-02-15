package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class MenuPage {
	
public WebDriver driver;
public PageUtilities pageutilities;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'small')]//child::div[@class='inner']") private List<WebElement> menuList;
	@FindBy(xpath = "//a[@class='small-box-footer']") private List<WebElement> menuLink;
	
	public void clickOnMenu(String selectedMenu) {
		int menuIndex;
		for (WebElement menuItem : menuList) {
			menuIndex = menuList.indexOf(menuItem);
			if(menuIndex!=-1 && menuItem.getText().contains(selectedMenu)) {
				pageutilities = new PageUtilities();
				pageutilities.javaScriptClick(driver, menuLink.get(menuIndex));
				break;
			}
		}
	}

}
