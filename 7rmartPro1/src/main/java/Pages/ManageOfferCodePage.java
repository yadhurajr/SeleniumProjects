package Pages;

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
		
		@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
		@FindBy(xpath = "//input[@id='offer_code']") WebElement offerCodeInputField;
		@FindBy(xpath = "//input[@value='yes']") WebElement firstOfferCodeRadioButton;
		@FindBy(xpath = "//input[@id='offer_per']") WebElement percentageInputField;
		@FindBy(xpath = "//input[@id='offer_price']") WebElement amountInputField;
		@FindBy(xpath = "//div[@role='textbox']") WebElement descriptionInputField;
		@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFileButton;
		@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
		@FindBy(xpath = "//div[@class='col-sm-12']") WebElement successfullAlertPopup;
		
		public void clickOnNewButton() {
			newButton.click();
		}
		
		public void enterOfferCodeInOfferCodeInputField(String offerCode) {
			offerCodeInputField.sendKeys(offerCode);
		}
		
		public void clickOnFirstCodeUserRadioButton() {
			firstOfferCodeRadioButton.click();
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
			//String filepath = "C:\\Users\\HP\\Documents\\30Percent.jpg";
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(driver, chooseFileButton, GeneralUtility.COUPONCODE_JPGFILE);
		}
		
		public void clickOnSaveButton() {
//			saveButton.click();
			
			PageUtilities pageutilities = new PageUtilities();
			pageutilities.javaScriptClick(driver, saveButton);
			
			WaitUtility waitUtility = new WaitUtility();
			waitUtility.ExplicitWaitForAnElement(driver, saveButton);
		}
		
		public boolean issuccessfullAlertPopupDisplayed() {
			return successfullAlertPopup.isDisplayed();
		}

}

