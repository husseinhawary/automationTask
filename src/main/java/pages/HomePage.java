package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	//Login Locators
	@FindBy(id="email")
	WebElement loginEmailOrPhoneTxtBox;
	
	@FindBy(id="pass")
	WebElement loginPasswordTxtBox;
	
	@FindBy(id="loginbutton")
	WebElement loginBtn;
	
	
	public void userLogingWithValidData(String emailOrPhone, String password) {
		clearTextElementValue(loginEmailOrPhoneTxtBox);
		setTextElementValue(loginEmailOrPhoneTxtBox, emailOrPhone);
		clearTextElementValue(loginPasswordTxtBox);
		setTextElementValue(loginPasswordTxtBox, password);
		clickButton(loginBtn);
	}

}
