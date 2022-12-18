package neoTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base1.Base1;
import neoPOM.neoHomePage;
import neoPOM.neoPassword;
import neoPOM.neoSignIn;
import neoUtility.Utility1;


public class ValidateUserName extends Base1{
	neoSignIn login;
	neoPassword password;
	neoHomePage home;
	
	@BeforeClass
	public void launchNeoStox() throws IOException, InterruptedException
	{
	    browser();
		login=new neoSignIn(driver);
		password=new neoPassword(driver);
		home=new neoHomePage(driver);
		
	}
	
	@BeforeMethod
	public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.clickOnhomeSignInButton(driver);
		login.sendMobileNum(driver, Utility1.readDataFromProperties("mobNum"));
		login.clickOnButton(driver);
		
		Thread.sleep(2000);
		password.sendPassword(driver, Utility1.readDataFromProperties("password"));
		password.clickOnSubmitButton(driver);
		Thread.sleep(2000);
		home.popUpHandle(driver);
		
	}
	@Test
	public void validateUserName() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		Assert.assertEquals(home.getUserName(), Utility1.readDataFromProperties("userName"));
		Utility1.takeScreenShot(driver, home.getUserName());
	}

	@Test
	public void validateACBalance()
	{
		Assert.assertNotNull(home.getBalance(driver));
		Reporter.log("Ac balance is"+home.getBalance(driver),true);
	}
	 
	@AfterMethod
	  public void logout()
	  {  
		 home.logOut(driver);  
	  }
	
	 @AfterClass
	  public void closeApplication() throws InterruptedException
	  {
		 closingBrowser(driver);
		  
	  }
}
