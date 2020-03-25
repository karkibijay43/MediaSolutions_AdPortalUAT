package adPortalstepdefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;


import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;

import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import dataProvider.ConfigFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AdPortal_LogIn_001_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage loginPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	 ExtentReports extent; 
	
@Test
	@Given("^User is on AdPortal UAT SignUp Page and clicks Log in link$")
	public void user_is_on_AdPortal_UAT_SignUp_page() {

		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader.getApplicationUrl();
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		signUpPage.explicitly_Wait_ForLogInLink();
		
		

	}
@Test
	@When("^User enters username and password and clicks log in$")
	public void enter_UserName_and_Password() throws IOException {
		loginPage = new LogInPage(driver);
		loginPage.enter_LogInEmail("MSolutionsTestEmail@charter.com");
		loginPage.enter_LogInPassword("testpwd@MS1");
		loginPage.clickLogIn();
	     
	}
@Test
	@Then("^User lands on request dashboard page$")

	public void requestDashboard_verification() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.dashBoardPage_Title_verification();
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		
		/*
		 * File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); try {
		 * 
		 * FileUtils.copyFile(src, new File(
		 * "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/LogInScreenShots2.png"
		 * )); }
		 * 
		 * catch (IOException e) { System.out.println(e.getMessage());
		 * 
		 * 
		 * }
		 */
			
}
}
