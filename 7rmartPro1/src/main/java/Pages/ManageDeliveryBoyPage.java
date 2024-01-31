package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	
	public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath = "//li[@class='nav-item']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") WebElement manageDeliveryBoyMoreInfoLink;
	@FindBy(xpath = "//a[@href='javascript:void(0)']") WebElement blueSearchButtonLink;
	@FindBy(xpath = "//input[@id='un']") WebElement nameInputField;
	@FindBy(xpath = "//input[@id='ph']") WebElement phoneNumberInputField;
	@FindBy(xpath = "//input[@id='ut']") WebElement emailInputField;
	@FindBy(xpath = "//button[@name='Search']") WebElement redSearchButtonLink;
	@FindBy(xpath = "//tbody/tr[1]") WebElement secondRowOflistDeliveryBoyTable;
	
//	public void clickOnManageDeliveryBoyMoreInfoLink() {
//		manageDeliveryBoyMoreInfoLink.click();
//	}
	
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

}
