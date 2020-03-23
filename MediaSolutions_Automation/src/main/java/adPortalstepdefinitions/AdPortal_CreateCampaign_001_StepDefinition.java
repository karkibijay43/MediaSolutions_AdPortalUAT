package adPortalstepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class AdPortal_CreateCampaign_001_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	ReachPage reachPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;

	@Given("^User is on AdPortal UAT SignUp page and clicks log in$")
	public void user_is_on_logIn_page() {

		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader.getApplicationUrl();
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		WebDriverWait logInLink = new WebDriverWait(driver, 30);
		logInLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='login-link']")));
		WebElement LogInLink = driver.findElement(By.xpath("//a[@class='login-link']"));
		LogInLink.click();
	}

	@When("^User enters Email and Password and clicks LogIn$")
	public void enter_UserName_and_Password() {
		 logInPage = pageObjectManager.getLogInPage();
		logInPage.enter_LogInEmail("MSolutionsTestEmail@charter.com");
		logInPage.enter_LogInPassword("testpwd@MS1");
		logInPage.clickLogIn();
		WebDriverWait newRequest = new WebDriverWait(driver, 30);
		newRequest.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='new-request-btn']")));

	}

	@Then("^User should land on Request Dashboard page$")

	public void requestDashboard_verification() {
		 requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		requestDashBoardPage.request_DashBoard_Verification();

	}

	@Then("^User should be able to Get started with the campaign$")

	public void start_campaign() {
		// If the user has already started creating campaign, and needs to continue with
		// the camapign details

		reachPage = pageObjectManager.getReachPage();
		 requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]")));

		requestDashBoardPage.click_Continue();
		WebDriverWait waitForNextButton = new WebDriverWait(driver, 30);
		waitForNextButton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));

		reachPage.click_ReachPageNextButton();

		WebDriverWait waitForRaiseAwareNessButton = new WebDriverWait(driver, 30);
		waitForRaiseAwareNessButton.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/app-order[1]/div[1]/div[2]/div[1]/div[1]/section[1]/app-goals[1]/app-card-item[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-goals-card[1]/div[2]/button[1]")));
		reachPage.select_RaiseAwareness();
		reachPage.click_ReachPage1NextButton();

	}

	@Then("^User enters the address on the address field and selects the distance and clicks Next$")
	public void enter_Address_and_Distance() throws InterruptedException

	{

		reachPage = pageObjectManager.getReachPage();
		WebDriverWait waitForAddressEntry = new WebDriverWait(driver, 10);
		waitForAddressEntry.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter a location']")));
		reachPage.enter_Address("Austin");
		reachPage.click_HeaderTtile();
		reachPage.click_DropDownAroow();
		//reachPage.enter_Distance();
		reachPage.clickDistance_JSExecutor();
		reachPage.click_DropDownAroow();
		reachPage.click_ReachPage2NextButton();
		reachPage.click_ReachPage3NextButton();
		//reachPage.click_ReachPage3NextButton_JSExecutor();


	}

	@Then("^User should be able to schedule a campaign")
	public void Schedule_Campaign() {
		reachPage = pageObjectManager.getReachPage();
		reachPage.click_startCalednderArrow();
		reachPage.click_stopCalenderArrow();
		reachPage.enter_Budget();
		reachPage.click_SchedulePage1NextButton();

	}
	
	@Then("^User should be abel to review their campaign$")
	public void review_campaign () {
		WebDriverWait waitForBudgetReview = new WebDriverWait(driver, 40);
		waitForBudgetReview.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body.white-background:nth-child(2) div.main app-order.ng-star-inserted:nth-child(2) div.order-comp:nth-child(1) div.main-section div.row-materialize.header-row-all:nth-child(2) div.row-materialize.s9.card-section section.section-container app-schedule-display.ng-star-inserted:nth-child(2) div.ng-animate-disabled div.card-item-position div.tv-commerical-question-card div.card.card-client.ng-star-inserted div.card-content.ng-star-inserted div.review-schedule.container-fluid.p-0.text-left.ng-star-inserted div.row.m-0.mb-4.pb-2 div.col.p-0.pr-3 app-commercial-schedule-overview:nth-child(2) div.ng-star-inserted div.d-flex.your-schedule-section > div.schedule-cost.d-flex.align-items-center")));
		reachPage = pageObjectManager.getReachPage();
		reachPage.verify_BudgetAmount();
	}

}
