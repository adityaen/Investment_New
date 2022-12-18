package neoPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoUtility.Utility1;

public class neoPassword {
	
	@FindBy (id="txt_accesspin")private WebElement passwordField;
	
	@FindBy (xpath="//a[text()='Submit']")private WebElement submitButton;
	
	public neoPassword(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void sendPassword(WebDriver driver,String password)
	{
		Utility1.wait(driver, 1000);
		passwordField.sendKeys(password);
		Reporter.log("Sending password ",true);
	}
	public void clickOnSubmitButton(WebDriver drievr)
	{
		Utility1.wait(drievr, 1000);
		submitButton.click();
		Reporter.log("Clicking on submit button ",true);
	}
}
