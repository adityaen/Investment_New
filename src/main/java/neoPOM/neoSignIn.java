package neoPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoUtility.Utility1;

public class neoSignIn {
	
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement mobNumField;
	
	@FindBy(xpath="(//a[text()='Sign In'])[2]")private WebElement signButton;
	
	@FindBy(xpath="(//a[text()='Sign In'])[1]")private WebElement homeSignButton;
	
	public neoSignIn(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMobileNum(WebDriver driver,String mobNum) 
	{
	 Utility1.wait(driver, 500);	
	 mobNumField.sendKeys(mobNum);	
	 Reporter.log("Sending mob num ",true);
	}
	
	public void clickOnButton(WebDriver drievr) 
	{
		Utility1.wait(drievr, 500);
		signButton.click();
		Reporter.log("Clicking on signIn Button ",true);
	}
	
	public void clickOnhomeSignInButton(WebDriver drievr) 
	{
		Utility1.wait(drievr, 500);
		homeSignButton.click();
		Reporter.log("Clicking on home signIn Button ",true);
	}
}
