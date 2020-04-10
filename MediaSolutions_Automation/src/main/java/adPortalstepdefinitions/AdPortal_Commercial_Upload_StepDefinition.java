package adPortalstepdefinitions;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
import adportalPageObjects.CommercialPage;
import adportalPageObjects.LogInPage;
import adportalPageObjects.ReachPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.ReviewOrderPage;
import adportalPageObjects.SchedulePage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

public class AdPortal_Commercial_Upload_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	ReachPage reachPage;
	RequestDashBoardPage requestDashBoardPage;
	SchedulePage schedulePage;
	CommercialPage commercialPage;
	ReviewOrderPage reviewOrderPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	ExtentReports extent;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^User is on SignUp page and clicks log in$")
	public void user_is_on_logIn_page() {
		webDriverManager = new WebDriverManager();
		driver = WebDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("SignUp Page is still loading");
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		signUpPage.explicitly_Wait_ForLogInLink();
		signUpPage.click_Login();

	}

	@When("^User logs in using Email and Password$")
	public void enter_UserName_and_Password() {
		logInPage = pageObjectManager.getLogInPage();
		logInPage.enter_LogInEmail("MSTestEmail@charter.com");
		logInPage.enter_LogInPassword("testpwd@MS1");
		logInPage.clickLogIn();
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();

	}

	@Then("^User should land Request Dashboard page with draft campaign$")

	public void requestDashboard_verification() {
		requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		requestDashBoardPage.request_DashBoardPage_With_Drafts_verification();

	}

	@Then("^User should be able to continue with the campaign$")

	public void start_campaign() {
		reachPage = pageObjectManager.getReachPage();
		requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.get_Started_Or_ContinueCamapaign();
		reachPage.explicitly_Wait_For_ReachPageNextButton();
		reachPage.click_ReachPageNextButton();
		reachPage.explicitly_Wait_For_RaiseAwarenessButton();
		reachPage.select_RaiseAwareness();
		reachPage.click_ReachPage1NextButton();

	}

	@Then("^User selects the address and distance and clicks Next$")
	public void enter_Address_and_Distance() throws InterruptedException {

		reachPage = pageObjectManager.getReachPage();
		reachPage.explicitly_Wait_For_AddressEntry();
		reachPage.enter_Address("Austin");
		reachPage.click_HeaderTtile();
		reachPage.click_DropDownArrow();
		reachPage.clickDistance_JSExecutor();
		reachPage.click_DropDownArrow();
		reachPage.click_ReachPage2NextButton();
		reachPage.click_ReachPage3NextButton();

	}

	@Then("^User should be able to select the dates to schedule a campaign$")
	public void Schedule_Campaign() {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.click_startCalednderArrow();
		schedulePage.click_stopCalenderArrow();
		schedulePage.enter_Budget("1000");
		schedulePage.click_SchedulePage1NextButton();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			System.out.println("The Review campaign couldn't load");
			e.printStackTrace();
		}

	}

	@Then("^User should be able to review the campaign details$")
	public void review_campaign() {
		schedulePage = new SchedulePage(driver);
		schedulePage.explicitly_Wait_For_ReviewPageNextButton();
		adPortalScreenShots = new AdPortalScreenShots(driver);
		adPortalScreenShots.takeScreenShotCreateCampaignDefault_RewviewPage();
		schedulePage.click_SchedulePage2_NextButton();

	}
	
	@Then ("^User should be able to upload their own commercial$")
	public void upload_Your_Own_Commercial () throws InterruptedException, AWTException {
		commercialPage = new CommercialPage(driver);
		commercialPage.click_Here_Link();
		commercialPage.upload_Your_Own_Commercial_Box();
		
	}
}
