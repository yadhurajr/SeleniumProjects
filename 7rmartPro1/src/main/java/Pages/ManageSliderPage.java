package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtility;
import Utilities.GeneralUtility;

public class ManageSliderPage {
	
public WebDriver driver;
public FileUploadUtility fileuploadutility;
	
	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']") private WebElement newButton;
	@FindBy(xpath = "//input[@type='file']") private WebElement chooseFileButton;
	@FindBy(xpath = "//input[@type='text']") private WebElement linkTextField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']") private WebElement successfullAlertPopup;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void uploadImage() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(driver, chooseFileButton, GeneralUtility.LION_JPGFILE);
	}
	
	public void enterLinkOnLinkTextField(String linkText) {
		linkTextField.sendKeys(linkText);
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public boolean isSuccessfullAlertPopupDisplayed() {
		return successfullAlertPopup.isDisplayed();
	}

}
