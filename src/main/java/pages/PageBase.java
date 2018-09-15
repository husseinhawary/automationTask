package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public static void clickButton(WebElement button) {
		button.click();		
	}
	public static void clearTextElementValue(WebElement txtElement) {
		txtElement.clear();
	}
	public static void setTextElementValue(WebElement txtElement, String value) {
		txtElement.sendKeys(value);
	}
	public static void selectDropDownListValue(WebElement dropDownListElement, String value) {
		Select element = new Select(dropDownListElement);
		element.selectByValue(value);
	}

}
