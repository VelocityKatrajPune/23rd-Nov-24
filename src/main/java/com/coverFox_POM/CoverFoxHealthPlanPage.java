package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage 

{
//variables-->WebElements
	@FindBy(className = "next-btn") private	WebElement nextButton;
	
//constructor
	
	public CoverFoxHealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//methods
	
	public void clickOnNextButtonHealthPlanPage()
	{
		Reporter.log("clicking on next button of health plan page", true);
		nextButton.click();
	}
	
	
	
}
