package neoPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoUtility.Utility1;

public class neoHomePage {
    @FindBy(xpath="(//a[text()='OK'])[2]")private WebElement okButton;
	
	@FindBy(xpath="(//a[text()='Close'])[5]")private WebElement closeButton;
	
	@FindBy(id="lbl_username")private WebElement userName;
	
	@FindBy(id="lbl_curbalancetop")private WebElement balance;
	
	@FindBy(xpath="//span[text()='Logout']")private WebElement logoutButton;
	
	public neoHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void popUpHandle(WebDriver driver) 
	{
		if(okButton.isDisplayed())
		{
		Utility1.wait(driver, 1000);
		okButton.click();
		Utility1.scrollIntoView(driver,closeButton);
		Utility1.wait(driver, 1000);
		closeButton.click();
		Reporter.log("Handling popup ",true);
		
		
		
		}
		else
		{
			Utility1.wait(driver, 1000);
			Reporter.log("There is no pop up",true);
		}
		
	}

	public String getUserName()
	{
		String actualName=userName.getText();
		return actualName;
	}
	
	public String getBalance(WebDriver driver)
	{
		Utility1.wait(driver, 1000);
		String actualBalance=balance.getText();
		return actualBalance;
	}
	
	public void logOut(WebDriver driver)
	{
		Utility1.wait(driver, 1000);
		userName.click();
		Utility1.wait(driver, 1000);
		logoutButton.click();
		Reporter.log("Logging out from neoStox ",true);
		
		
		
		
		
	}
	
}
