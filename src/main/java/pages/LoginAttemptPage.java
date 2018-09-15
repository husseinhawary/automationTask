package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAttemptPage extends PageBase{

	public LoginAttemptPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath=".//div[@class='_4rbf _53ij']")
	public WebElement loginFailureMsg;
}
