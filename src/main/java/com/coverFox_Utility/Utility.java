package com.coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	//readData from excel
	public static String readDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream( System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\23rd Nov Morning2024.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel", true);
		return data;
		
	}
	
	//screenshot
	public static void takeScreenshot(WebDriver driver, String screenShotName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("user.dir")+"\\screenshot"+screenShotName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot, svaed at "+dest, true);
		
	}
	
	//scroll into view
	public static void scroolIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrolling into view", true);
	}

	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream myFile= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\coverFox.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("reading "+key+ " from properties file", true);
		
		return value;
	}
	
	public void implicitWait(WebDriver driver,int timeInMilisec)
	{
		Reporter.log("waiting for "+timeInMilisec, true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeInMilisec));
	}
	
	public void sendKeys(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	
	
	
	
}
