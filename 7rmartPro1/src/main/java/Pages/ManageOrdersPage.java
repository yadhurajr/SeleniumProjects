package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class ManageOrdersPage {
	
	public WebDriver driver;

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath = "//td[text()='145']/following-sibling::td[5]//a[text()='Change Delivery Date']") WebElement changeDeliveryDateButton;
	@FindBy(xpath = "//td[text()='145']/following-sibling::td[5]//input[@id='basicExample']") WebElement startTimeInputField;
	@FindBy(xpath = "//td[text()='145']/following-sibling::td[5]//input[@id='basicExample1']") WebElement endTimeInputField;
	@FindBy(xpath = "(//td[text()='145']/following-sibling::td[5]//button[@name='Update_st'])[2]") WebElement updateButtonForChangingDeliveryDate;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::div") WebElement successfulAlertMessageForChangingDeliveryDate;
	
	@FindBy(xpath = "//td[text()='145']/following-sibling::td[5]//a[text()='Assign Delivery Boy']") WebElement assignDeliveryBoyButton;
	@FindBy(xpath = "//td[text()='145']/following-sibling::td[5]//select[@id='delivery_boy_id']") WebElement deliveryBoySelectField;
	@FindBy(xpath = "(//td[text()='145']/following-sibling::td[5]//button[@type='submit'])[3]") WebElement updateButtonForAssigningDeliveryBoy;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::div") WebElement successfulAlertMessageForAssigningDeliveryBoy;
	
	public void clickOnChangeDeliveryDateButton() {
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.javaScriptClick(driver, changeDeliveryDateButton);
	}
	
	public void enterStartTimeOnStartTimeInputField(String startTime) {
		startTimeInputField.clear();
		startTimeInputField.sendKeys(startTime);
	}
	
	public void enterEndTimeOnDateEndTimeInputField(String endTime) {
		endTimeInputField.clear();
		endTimeInputField.sendKeys(endTime);
	}
	
	public void clickOnUpdateButtonForChangingDeliveryDate() {
		
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.javaScriptClick(driver, updateButtonForChangingDeliveryDate);
	}
	
	public boolean isSuccessfulAlertMessageDisplayedForChangingDeliveryDate() {
		return successfulAlertMessageForChangingDeliveryDate.isDisplayed();
	}
	
	public void clickOnAssignDeliveryBoyButton() {	
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.javaScriptClick(driver, assignDeliveryBoyButton);
	}
	
	public void selectDeliveryBoy(String visibleTextOfDeliveryBoy) {
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.selectValueUsingSelectByVisibleText(deliveryBoySelectField, visibleTextOfDeliveryBoy);
	}
	
	public void clickOnUpdateButtonForAssigningDeliveryBoy() {
		
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.javaScriptClick(driver, updateButtonForAssigningDeliveryBoy);
	}
	
	public boolean isSuccessfulAlertMessageDisplayedForAssigningDeliveryBoy() {
		return successfulAlertMessageForAssigningDeliveryBoy.isDisplayed();
	}
	
	
}
