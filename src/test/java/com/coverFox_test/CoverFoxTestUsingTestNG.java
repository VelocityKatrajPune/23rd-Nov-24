package com.coverFox_test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.coverFox_Base.Base;
import com.coverFox_POM.CoverFoxAddressDetailsPage;
import com.coverFox_POM.CoverFoxHealthPlanPage;
import com.coverFox_POM.CoverFoxHomePage;
import com.coverFox_POM.CoverFoxMemberDetailsPage;
import com.coverFox_POM.CoverFoxResultPage;
import com.coverFox_Utility.Utility;	


public class CoverFoxTestUsingTestNG extends Base{
  
	public static Logger logger;
	CoverFoxHomePage coverFoxHomePage;
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage;
	CoverFoxAddressDetailsPage coverFoxAddressDetailsPage;
	CoverFoxHealthPlanPage coverFoxHealthPlanPage;
	CoverFoxResultPage coverFoxResultPage;
	
	@BeforeClass
	public void launchBrowser() throws EncryptedDocumentException, IOException
	{
		logger= Logger.getLogger("23rdNov24_CoverFox");
		  PropertyConfigurator.configure("log4j.properties");
		 logger.info("Welcome to CoverFox Testing");

		

		openBrowser();
		logger.warn("launching browser");
		coverFoxHomePage= new CoverFoxHomePage(driver);
		coverFoxAddressDetailsPage= new CoverFoxAddressDetailsPage(driver);
		coverFoxMemberDetailsPage= new CoverFoxMemberDetailsPage(driver);
		coverFoxHealthPlanPage= new CoverFoxHealthPlanPage(driver);
		coverFoxResultPage= new CoverFoxResultPage(driver);
		
	}
	
	@BeforeMethod
	public void coverFoxPreconditions() throws InterruptedException, EncryptedDocumentException, IOException
	{
		coverFoxHomePage.clickOnGender();
		logger.error("Clicking on gender");
		coverFoxHealthPlanPage.clickOnNextButtonHealthPlanPage();
		logger.info("clickOnNextButtonHealthPlanPage");
		coverFoxMemberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel("Sheet7", 1, 0));
		logger.info("handleAgeDropDown");
		coverFoxMemberDetailsPage.clickOnNextButtonOfMemberDetailsPage();
		logger.info("clickOnNextButtonOfMemberDetailsPage");
		coverFoxAddressDetailsPage.enterPinCode(Utility.readDataFromExcel("Sheet7", 1, 1));
		logger.info("enterPinCode");
		coverFoxAddressDetailsPage.enterMobileNumber(Utility.readDataFromExcel("Sheet7", 1, 2));
		logger.info("enterMobileNumber");
		coverFoxAddressDetailsPage.clickOnContinueButton();
		logger.info("clickOnContinueButton");
		Thread.sleep(4000);
	}
	
	
	@Test
  public void validateCoverFoxPlans() throws IOException {
	
		//Assert.fail();
		int planNumberFromText = coverFoxResultPage.getPlanNumberFromText();
		int planNumberFromCards = coverFoxResultPage.getPlanNumberFromPlanCards();
		logger.info("validating CoverFoxPlans");
		Assert.assertEquals(planNumberFromText, planNumberFromCards,"Test case failed, number are not matching");
		Reporter.log("Plan number are matching TC is passed", true);
		Reporter.log("This is my first change", true);
		Reporter.log("This is my second change", true);
		Reporter.log("This is my third change", true);
		System.out.println("Good Morning");
		System.out.println("This is pull test");
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		logger.info("closing browser");
		closeBrowserWindow();
	}
}
