package adPortalstepdefinitions;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import adPortalManagers.PageObjectManager;

import adPortalManagers.WebDriverManager;
import adportalPageObjects.LogInPage;
import adportalPageObjects.ReachPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

public class AdPortal_CreateCampaign_002_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	ReachPage reachPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	

	@Given("^User is on AdPortal UAT SignUp page and clicks Log in$")
	public void user_is_on_AdportalUAT_SignUP_page() {
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

	@When("^User enters Existing Email and Password and clicks LogIn$")
	public void enter_UserName_and_Password() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		logInPage = new LogInPage(driver);
		logInPage.enter_LogInEmail("MSolutionsTestEmail@charter.com");
		logInPage.enter_LogInPassword("testpwd@MS1");
		logInPage.clickLogIn();
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		
		/*
		 * WebDriverWait newRequest = new WebDriverWait(driver, 30);
		 * newRequest.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//button[@id='new-request-btn']")));
		 */
	}

	@Then("^User should land on Request Dashboard page with Campaign drafts$")

	public void requestDashboard_verification() {
		RequestDashBoardPage requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.request_DashBoard_Verification();
		
	}

	@Then("^User should be able to Get started or continue with the campaign$")

	public void start_campaign() {
		ReachPage reachPage = new ReachPage (driver);
		RequestDashBoardPage requestDashBoardPage = new RequestDashBoardPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]")));
		  
		  requestDashBoardPage.click_Continue();
		  WebDriverWait waitForNextButton = new WebDriverWait(driver, 30);
		  waitForNextButton
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		  "//span[contains(text(),'Next')]")));
		  
		  reachPage.click_ReachPageNextButton();
		  
		  WebDriverWait waitForRaiseAwareNessButton = new WebDriverWait(driver, 30);
		  waitForRaiseAwareNessButton.until(ExpectedConditions.presenceOfElementLocated
		  (By.xpath(
		  "/html[1]/body[1]/app-root[1]/div[1]/app-order[1]/div[1]/div[2]/div[1]/div[1]/section[1]/app-goals[1]/app-card-item[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-goals-card[1]/div[2]/button[1]"
		  )));
		  reachPage.select_RaiseAwareness();
		  reachPage.click_ReachPage1NextButton();
		
		 
	}

	@Then("^User enters the address on the address field and selects the distance in miles and clicks Next$")
	public void enter_Address_and_Distance() throws InterruptedException

	{
		ReachPage reachPage = new ReachPage (driver);		
		WebDriverWait waitForAddressEntry = new WebDriverWait(driver, 10);
		waitForAddressEntry.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter a location']")));
		reachPage.UserInPut_Address();
		//reachPage.click_HeaderTtile();
		reachPage.click_DropDownAroow();
		reachPage.UserInPut_Distance();
		reachPage.click_ReachPage2NextButton();
		reachPage.click_ReachPage3NextButton();
	}
		

	

	@Then("^User should be able to create a campaign for selected Dates$")
	public void Schedule_Campaign() {
		ReachPage reachPage = new ReachPage (driver);
		reachPage.click_startCalednderArrow();
		reachPage.click_stopCalenderArrow();
		reachPage.enter_Budget();
		reachPage.click_SchedulePage1NextButton();
		
	}
@Then("^User should be able to review their campaign Details$")
public void review_campaign_details () {
	
	
	WebDriverWait waitForBudgetReview = new WebDriverWait(driver, 40);
	waitForBudgetReview.until(ExpectedConditions.presenceOfElementLocated(By.className("mapboxgl-canvas")));
	reachPage = pageObjectManager.getReachPage();
	reachPage.verify_BudgetAmount();
}
}

