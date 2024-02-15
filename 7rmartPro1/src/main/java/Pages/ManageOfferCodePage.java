package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtility;
import Utilities.GeneralUtility;
import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class ManageOfferCodePage {
	
	public WebDriver driver;
	public FileUploadUtility fileuploadutility;
		
		public ManageOfferCodePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
		@FindBy(xpath = "//input[@id='offer_code']") private WebElement offerCodeInputField;
		
		@FindBy(xpath = "//input[@value='yes']") private WebElement firstOrderUserYesRadioButton;
		@FindBy(xpath = "//input[@value='no']") private WebElement firstOrderUserNoRadioButton;
		
		@FindBy(xpath = "//input[@id='offer_per']") private WebElement percentageInputField;
		@FindBy(xpath = "//input[@id='offer_price']") private WebElement amountInputField;
		@FindBy(xpath = "//div[@role='textbox']") private WebElement descriptionInputField;
		@FindBy(xpath = "//input[@id='main_img']") private WebElement chooseFileButton;
		@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
		@FindBy(xpath = "//div[@class='col-sm-12']") private WebElement successfullAlertPopup;
		
		@FindBy(xpath = "//a[@onclick='click_button(2)']") private WebElement blueSearchButton;
		@FindBy(xpath = "//input[@placeholder='Offer Code']") private WebElement offerCodeInputfieldToSearch;
		@FindBy(xpath = "//button[@type='submit']") private WebElement redSearchButton;
		@FindBy(xpath = "//tbody/tr[1]") private WebElement secondRowOfListOfferCodeTable;
		
		public void clickOnNewButton() {
			newButton.click();
		}
		
		public void enterOfferCodeInOfferCodeInputField(String offerCode) {
			offerCodeInputField.sendKeys(offerCode);
		}
		
		public void clickOnFirstOrderUserYesRadioButton() {
			firstOrderUserYesRadioButton.click();
		}
		public void clickOnFirstOrderUserNoRadioButton() {
			firstOrderUserNoRadioButton.click();
		}
		
		public void enterPercentageOnPercentageField(String percentage) {
			percentageInputField.sendKeys(percentage);
		}
		
		public void enterAmountOnAmountInputField(String amount) {
			amountInputField.sendKeys(amount);
		}
		
		public void enterDescriptionOnDescriptionInputField(String description) {
			descriptionInputField.sendKeys(description);
		}
		
		public void uploadImage() {
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(driver, chooseFileButton, GeneralUtility.COUPONCODE_JPGFILE);
		}
		
		public void clickOnSaveButton() {
			
			PageUtilities pageutilities = new PageUtilities();
			pageutilities.javaScriptClick(driver, saveButton);
			
			WaitUtility waitUtility = new WaitUtility();
			waitUtility.ExplicitWaitForAnElement(driver, saveButton);
		}
		
		public boolean issuccessfullAlertPopupDisplayed() {
			return successfullAlertPopup.isDisplayed();
		}
		
		public void clickOnBlueSearchButton() {
			blueSearchButton.click();
		}
		
		public void enterOfferCodeOnOfferCodeInputfieldToSearch(String expectedOfferCode) {
			offerCodeInputfieldToSearch.sendKeys(expectedOfferCode);
		}
		
		public void clickOnRedSearchButton() {
			redSearchButton.click();
		}
		
		public List<String> getDetailsOfSecondRow() {
	    	List<String> actualDetails = new ArrayList<String>();
	        List<WebElement> cellsOfSecondRow = secondRowOfListOfferCodeTable.findElements(By.tagName("td"));

	        for (WebElement cell : cellsOfSecondRow) {
	        	actualDetails.add(cell.getText());
	        }

	    return actualDetails;

	    }

}

