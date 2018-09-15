package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.UserRegisterPage;

public class RegisterTests extends TestBase{
	UserRegisterPage uerRegisterObject;
	
	@DataProvider(name="RegisterWithValidData")
	public static Object[][] userRegisterWithValidData(){
		//1- Valid Email and Password
		return new Object[][] {{"Hussein", "El-Hawary Task", "afaqyhussein2@gmail.com", "afaqyhussein2@gmail.com", "Afaqytask#123", "10", "12", "1991","Confirm your email address"}};
	}

	@DataProvider(name="RegisterWithInvalidData")
	public static Object[][] userRegisterWithInvalidData(){
		return new Object[][] {
			//Register With Empty First Name
			{"", "El-Hawary", "hussein.elhawary@gmail.com", "hussein.elhawary@gmail.com", "Afaqytask#123", "10", "12", "1991","What's your name?"},
			//Register With Empty Surname
			{"Hussein", "", "hussein.elhawary13313@gmail.com", "hussein.elhawary13313@gmail.com", "Afaqytask#123", "10", "12", "1991","What's your name?"},
			//Register With Password less that "6" chars
			{"Hussein", "El-Hawary", "hussein.elhawary@gmail.com", "hussein.elhawary@gmail.com", "asd", "10", "12", "1991","Your password must be at least 6 characters long. Please try another."}
			};
	}
	@Test(dataProvider="RegisterWithValidData")
	public void userRegistrationWithValidData(String fName, String surName, String emailOrPhone, String confirmEmailOrPhone, String password, String day, String month, String year, String msg) {
		uerRegisterObject = new UserRegisterPage(driver);
		uerRegisterObject.userRegister(fName, surName, emailOrPhone, confirmEmailOrPhone, password, day, month, year);
		Assert.assertTrue(uerRegisterObject.registrationSuccessMsg.getText().equals(msg));
	}
	
	@Test(dataProvider="RegisterWithInvalidData")
	public void userRegistrationWithInvalidData(String fName, String surName, String emailOrPhone, String confirmEmailOrPhone, String password, String day, String month, String year, String msg) {
		uerRegisterObject = new UserRegisterPage(driver);
		uerRegisterObject.userRegister(fName, surName, emailOrPhone, confirmEmailOrPhone, password, day, month, year);
		
		//Classes && IDs in registration form are dynamic. So, The assertion isn't accurate 100% but I tried to do my best
		Assert.assertTrue(uerRegisterObject.emptyFNameErrorMsg.getText().equals(msg) || uerRegisterObject.emptySurNameErrorMsg.getText().equals(msg) ||uerRegisterObject.passwordLessThan6CharsErrorMsg.getText().equals(msg));
		
	}
}
