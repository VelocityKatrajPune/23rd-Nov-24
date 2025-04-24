package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {

	@FindBy(className = "mp-input-text")
	private WebElement pinCodeFiled;
	@FindBy(id = "want-expert")
	private WebElement mobileNumberField;
	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement continueButton;

	
	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterPinCode(String pinCode) {
		Reporter.log("entering PinCode", true);
		pinCodeFiled.sendKeys(pinCode);
	}

	public void enterMobileNumber(String mobileNumber) {
		Reporter.log("entering mobileNumber", true);
		mobileNumberField.sendKeys(mobileNumber);
	}

	public void clickOnContinueButton() {
		Reporter.log("clicking On Continue Button", true);
		continueButton.click();
	}
	

}
