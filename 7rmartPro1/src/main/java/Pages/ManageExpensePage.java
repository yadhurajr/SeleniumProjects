package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtility;
import Utilities.GeneralUtility;
import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class ManageExpensePage {
	
	public WebDriver driver;
	public PageUtilities pageutilities;
	public FileUploadUtility fileuploadutility;
	public GeneralUtility generalutility;
	public WaitUtility waitutility;
		
		public ManageExpensePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
		@FindBy(xpath = "//select[@name='user_id']") private WebElement userIdSelectField;
		@FindBy(xpath = "//select[@name='ex_cat']") private WebElement categorySelectField;
		@FindBy(xpath = "//select[@name='order_id']") private WebElement orderIdSelectField;
		@FindBy(xpath = "//select[@name='purchase_id']") private WebElement purchaseIdSelectField;
		@FindBy(xpath = "//select[@name='ex_type']") private WebElement expenseTypeSelectField;
		@FindBy(xpath = "//input[@id='amount']") private WebElement amountInputField;
		@FindBy(xpath = "//textarea[@id='content']") private WebElement remarksInputField;
		@FindBy(xpath = "//input[@name='userfile']") private WebElement chooseFileButton;
		@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
		@FindBy(xpath = "//div[@class='col-sm-12']//child::div") private WebElement successfullAlertPopup;
		
		
		public void clickOnNewButton() {
			newButton.click();
		}
		
		public void selectUserId(String visibleTextOfUserId) {
			pageutilities = new PageUtilities();
			pageutilities.selectValueUsingSelectByVisibleText(userIdSelectField, visibleTextOfUserId);
		}
		
		public void selectCategory(String visibleTextOfCategory) {
			pageutilities = new PageUtilities();
			pageutilities.selectValueUsingSelectByVisibleText(categorySelectField, visibleTextOfCategory);
		}
		
		public void selectOrderId(String visibleTextOfOrderId) {
			pageutilities = new PageUtilities();
			pageutilities.selectValueUsingSelectByVisibleText(orderIdSelectField, visibleTextOfOrderId);
		}
		
		public void selectPurchaseId(String visibleTextOfPurchaseId) {
			pageutilities = new PageUtilities();
			pageutilities.selectValueUsingSelectByVisibleText(purchaseIdSelectField, visibleTextOfPurchaseId);
		}
		
		public void selectExpenseType(String visibleTextOfExpenseType) {
			pageutilities = new PageUtilities();
			pageutilities.selectValueUsingSelectByVisibleText(expenseTypeSelectField, visibleTextOfExpenseType);
		}
		
		public void enterAmountInAmountInputField(String amount) {
			amountInputField.sendKeys(amount);
		}
		
		public void enterRemarksInRemarksInputField(String remarks) {
			remarksInputField.sendKeys(remarks);
		}
		
		public void uploadFile() {
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(driver, chooseFileButton, GeneralUtility.LION_JPGFILE);
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
		
}
