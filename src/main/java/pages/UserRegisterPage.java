package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterPage extends PageBase{

	public UserRegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Register Locators
	@FindBy(name="firstname")
	WebElement fNameTxtBox;
	
	@FindBy(name="lastname")
	WebElement surNameTxtBox;
	
	@FindBy(name="reg_email__")
	WebElement registerEmailOrPhoneTxtBox;
	
	@FindBy(name="reg_email_confirmation__")
	WebElement confirmEmailOrPhoneTxtBox;
	
	@FindBy(name="reg_passwd__")
	WebElement passwordTxtBox;
	
	@FindBy(name="birthday_day")
	WebElement daySelectBox;
	
	@FindBy(name="birthday_month") 
	WebElement monthSelectBox;
	
	@FindBy(name="birthday_year") 
	WebElement yearSelectBox;
	
	@FindBy(id="u_0_a")  
	WebElement genderCheckBox;
	
	@FindBy(name="websubmit")  
	WebElement signUpBtn;
	
	//Valid Registration Locators .//h2[@class='uiHeaderTitle']
	@FindBy(xpath=".//h2[@class='uiHeaderTitle']")
	public WebElement registrationSuccessMsg;
	
	//Invalid Registration Locators
	@FindBy(xpath=".//div[@class='_5v-0 _53im']/div[@class='_5633 _5634 _53ij']")
	public WebElement emptyFNameErrorMsg;
	
	@FindBy(xpath=".//div[@class='_5v-0 _53il']/div[@class='_5633 _5634 _53ij']")
	public WebElement emptySurNameErrorMsg;
	
	@FindBy(id="reg_error_inner")
	public WebElement passwordLessThan6CharsErrorMsg;
	
	public void userRegister(String fName, String surName, String emailOrPhone, String confirmEmailOrPhone, String password, String day, String month, String year) {
		setTextElementValue(fNameTxtBox, fName);
		setTextElementValue(surNameTxtBox, surName);
		setTextElementValue(registerEmailOrPhoneTxtBox, emailOrPhone);
		setTextElementValue(confirmEmailOrPhoneTxtBox, confirmEmailOrPhone);
		setTextElementValue(passwordTxtBox, password);
		selectDropDownListValue(daySelectBox,day);
		selectDropDownListValue(monthSelectBox,month);
		selectDropDownListValue(yearSelectBox,year);
		clickButton(genderCheckBox);
		clickButton(signUpBtn);
	}
}
