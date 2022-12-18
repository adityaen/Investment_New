package neoUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility1 {
	public static void takeScreenShot(WebDriver driver,String filename) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desc=new File("D:\\Selenium\\screenshot\\"+filename+".png");
		FileHandler.copy(src, desc);
		Reporter.log("taking screenshot",true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement ref) 
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView[true]", ref);
		Reporter.log("Scroll into view",true);
		
	}
	
	public static void wait(WebDriver driver,int waittime)
	{
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
	}
	
	public static String readDataFromProperties(String key) throws IOException 
	{
	  Properties prop=new Properties();  //obj is created
	  
	  FileInputStream myFile=new FileInputStream("C:\\Users\\Aditya\\eclipse-workspace\\NeoStax\\src\\test\\resources\\property.properties");
	  
	  prop.load(myFile);
	  
	  String value=prop.getProperty(key);
	  
	  Reporter.log("Reading value of "+key+" from property file ",true);
	  
	  return value;
	}

}
