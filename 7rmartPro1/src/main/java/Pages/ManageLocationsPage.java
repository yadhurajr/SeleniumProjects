package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class ManageLocationsPage {
	
public WebDriver driver;
public PageUtilities pageutilities;
	
	public ManageLocationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") private WebElement countrySelectField;
	@FindBy(xpath = "//select[@id='st_id']") private WebElement stateSelectField;
	@FindBy(xpath = "//input[@id='location']") private WebElement locationInputField;
	@FindBy(xpath = "//input[@id='delivery']") private WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::div") private WebElement locationCreatedSuccessfullyAlertPopup;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void selectCountry(String value) {
		pageutilities = new PageUtilities();
		pageutilities.selectValueUsingSelectByValue(countrySelectField, value);
	}
	
	public void selectState(String visibleText) {
		pageutilities = new PageUtilities();
		pageutilities.selectValueUsingSelectByVisibleText(stateSelectField, visibleText);
	}
	
	public void enterLocationInLocationInputField(String location) {
		locationInputField.sendKeys(location);
	}
	
	public void enterDeliveryChargeInDeliveryChargeField(String deliveryCharge) {
		deliveryChargeField.sendKeys(deliveryCharge);
	}
	
	public void clickOnSaveButton( ) {
		saveButton.click();
	}
	
	public boolean islocationCreatedSuccessfullyAlertPopupDisplayed() {
		return locationCreatedSuccessfullyAlertPopup.isDisplayed();
	}

}
