package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginAttemptPage;
import pages.WelcomePage;

public class LoginTests extends TestBase{
	HomePage homeObject;
	WelcomePage welcomeObject;
	LoginAttemptPage loginAttemptObject;


	@DataProvider(name="ExcelData")
	public Object[][] userLoginData() throws IOException{
		//get data from excel
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@DataProvider(name="UserValidData")
	public static Object[][] userLoginValidData(){
		//1- Valid Email and Password
		return new Object[][] {{"ftask18@gmail.com","facebooktask#123","News Feed"}};
	}

	@DataProvider(name="UserInvalidData")
	public static Object[][] userLoginInvalidData(){
		return new Object[][] {
			//1- Invalid Email and Valid Password, 2- Valid Email and Invalid Password
			{"ftask18wqeqe@gmail.coma","facebooktask#123","The email address that you've entered doesn't match any account. Sign up for an account."},
			{"ftask18@gmail.com","facebooktask#12","The password that you've entered is incorrect. Forgotten password?"}};
	}

	//This method reads successfully from excel file and passed with valid data but It fails with Invalid data because I faced a problem in multiple assertion. So I commented it to prove the concept
	//@Test(dataProvider="ExcelData")
	public void userLoginWithValidData(String email, String password, String msg) {
		homeObject = new HomePage(driver);
		homeObject.userLogingWithValidData(email, password);
		welcomeObject = new WelcomePage(driver);
		Assert.assertTrue(welcomeObject.loginSuccessMsg.getText().equals(msg));		                 
	}

	@Test(dataProvider="UserValidData")
	public void userLoginWithValidDataViaDataProvider(String email, String password, String msg) {
		homeObject = new HomePage(driver);
		homeObject.userLogingWithValidData(email, password);
		welcomeObject = new WelcomePage(driver);
		Assert.assertTrue(welcomeObject.loginSuccessMsg.getText().equals(msg));

	}

	@Test(dataProvider="UserInvalidData")
	public void userLoginWithInValidData(String email, String password, String msg) {
		homeObject = new HomePage(driver);
		homeObject.userLogingWithValidData(email, password);
		loginAttemptObject = new LoginAttemptPage(driver);
		Assert.assertTrue(loginAttemptObject.loginFailureMsg.getText().equals(msg));
	}

}
