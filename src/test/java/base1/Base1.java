package base1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;


import neoUtility.Utility1;

public class Base1 {
   protected WebDriver driver;
	public void browser() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Utility1.readDataFromProperties("url"));
		driver.manage().window().maximize();
		Reporter.log("launching browser",true);
		Utility1.wait(driver, 1000);	
	}
	
	public static void closingBrowser(WebDriver driver) throws InterruptedException 
	{
		Reporter.log("closing browser",true);
		Thread.sleep(1000);
		driver.close();
		
		
		
		
	}
}
