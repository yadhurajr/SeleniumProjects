package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
public WebDriver driver;
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']") private WebElement usernameInputField;
	@FindBy(xpath = "//input[@placeholder='Password']") private WebElement passwordInputField;
	@FindBy(xpath = "//button[text()='Sign In']") private WebElement signInButton;
	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']") private WebElement adminDropdownButton;
	@FindBy(xpath = "//button[@class='close']//parent::div") private WebElement redAlertTextBox;
	
	public void enterUsernameOnUsernameInputField(String username) {
		usernameInputField.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordInputField(String password) {
		passwordInputField.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	public boolean isAdminDropdownButtonDisplayed() {
		return adminDropdownButton.isDisplayed();
	}
	
	public boolean isRedAlertTextBoxDisplayed() {
		return redAlertTextBox.isDisplayed();
	}

}
