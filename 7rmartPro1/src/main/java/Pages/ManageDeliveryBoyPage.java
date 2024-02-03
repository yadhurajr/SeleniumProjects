package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	
	public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//TestCase2
	@FindBy(xpath = "//a[@href='javascript:void(0)']") WebElement blueSearchButtonLink;
	@FindBy(xpath = "//input[@id='un']") WebElement nameInputField;
	@FindBy(xpath = "//input[@id='ph']") WebElement phoneNumberInputField;
	@FindBy(xpath = "//input[@id='ut']") WebElement emailInputField;
	@FindBy(xpath = "//button[@name='Search']") WebElement redSearchButtonLink;
	@FindBy(xpath = "//tbody/tr[1]") WebElement secondRowOflistDeliveryBoyTable;
	
	//TestCase1
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//input[@id='name']") WebElement nameInputField2;
	@FindBy(xpath = "//input[@id='email']") WebElement emailInputField2;
	@FindBy(xpath = "//input[@id='phone']") WebElement phoneNumberInputField2;
	@FindBy(xpath = "//textarea[@id='address']") WebElement addressInputField2;
	@FindBy(xpath = "//input[@id='username']") WebElement usernameInputField2;
	@FindBy(xpath = "//input[@id='password']") WebElement passwordInputField2;
	@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath = "//tbody/tr[1]") WebElement secondRowOflistDeliveryBoyTableAfterAddingDeliveryBoyInstructions;
	
	public void clickOnBlueSearchButtonLink() {
		blueSearchButtonLink.click();
	}
	
	public void enterNameOnNameInputField(String expectedName) {
		nameInputField.sendKeys(expectedName);
	}
	
	public void enterPhoneNumberOnPhoneNumberInputField(String expectedPhoneNumber) {
		phoneNumberInputField.sendKeys(expectedPhoneNumber);
	}
	
	public void enterEmailOnEmailInputField(String expectedEmail) {
		emailInputField.sendKeys(expectedEmail);
	}
	
	public void clickOnRedSearchButtonLink() {
		redSearchButtonLink.click();
	}
	
    public List<String> getDetailsOfSecondRow() {
    	List<String> details = new ArrayList<String>();
        List<WebElement> cellsOfSecondRow = secondRowOflistDeliveryBoyTable.findElements(By.tagName("td"));

        for (WebElement cell : cellsOfSecondRow) {
            details.add(cell.getText());
        }

    return details;

    }
    
    public void clickOnNewButton() {
    	newButton.click();
    }
    
    public void enterNameOnNameInputFieldToAddNewDeliveryBoyInformations(String nameToAdd) {
    	nameInputField2.sendKeys(nameToAdd);
    }
    
    public void enterEmailOnEmailInputFieldToAddNewDeliveryBoyInformations(String emailToAdd) {
    	emailInputField2.sendKeys(emailToAdd);
    }
    
    public void enterPhnNoOnPhnNoInputFieldToAddNewDeliveryBoyInformations(String phnNoToAdd) {
    	phoneNumberInputField2.sendKeys(phnNoToAdd);
    }
    
    public void enterAddressOnAddressInputFieldToAddNewDeliveryBoyInformations(String addressToAdd) {
    	addressInputField2.sendKeys(addressToAdd);
    }
    
    public void enterUsernameOnUsernameInputFieldToAddNewDeliveryBoyInformations(String usernameToAdd) {
    	usernameInputField2.sendKeys(usernameToAdd);
    }
    
    public void enterPasswordOnPasswordInputFieldToAddNewDeliveryBoyInformations(String passwordToAdd) {
    	passwordInputField2.sendKeys(passwordToAdd);
    }
    
    public void clickOnSaveButton() {
    	PageUtilities pageutilities = new PageUtilities();
		pageutilities.javaScriptClick(driver, saveButton);
    }
    
    public List<String> getDetailsOfSecondRowAfterAddingDeliveryBoyInstructions() {
    	List<String> actualDetails = new ArrayList<String>();
        List<WebElement> cellsOfSecondRow = secondRowOflistDeliveryBoyTableAfterAddingDeliveryBoyInstructions.findElements(By.tagName("td"));

        for (WebElement cell : cellsOfSecondRow) {
        	actualDetails.add(cell.getText());
        }

    return actualDetails;

    }    
}
