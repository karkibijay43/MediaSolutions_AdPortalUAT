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
import adportalPageObjects.SchedulePage;
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
	ReachPage reachPage;
	RequestDashBoardPage requestDashBoardPage;
	SchedulePage schedulePage;
	CommercialPage commercialPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	ExtentReports extent;
	AdPortalScreenShots adPortalScreenShots;
	

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
		signUpPage.explicitly_Wait_ForLogInLink();

	}

	@When("^User enters Email and Password and clicks LogIn$")
	public void enter_UserName_and_Password() {
		logInPage = pageObjectManager.getLogInPage();
		logInPage.enter_LogInEmail("MSTestEmail@charter.com");
		logInPage.enter_LogInPassword("testpwd@MS1");
		logInPage.clickLogIn();
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();

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
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.continue_Draft();
		//requestDashBoardPage.get_Started_Or_ContinueCamapaign();
		//requestDashBoardPage.click_Continue();
		reachPage.explicitly_Wait_For_ReachPageNextButton();
		reachPage.click_ReachPageNextButton();
		reachPage.explicitly_Wait_For_RaiseAwarenessButton();
		reachPage.select_RaiseAwareness();
		reachPage.click_ReachPage1NextButton();

	}

	@Then("^User enters the address on the address field and selects the distance and clicks Next$")
	public void enter_Address_and_Distance() throws InterruptedException {

		reachPage = pageObjectManager.getReachPage();
		reachPage.explicitly_Wait_For_AddressEntry();
		reachPage.enter_Address("Austin");
		reachPage.click_HeaderTtile();
		reachPage.click_DropDownAroow();
		// reachPage.enter_Distance();
		reachPage.clickDistance_JSExecutor();
		reachPage.click_DropDownAroow();
		reachPage.click_ReachPage2NextButton();
		reachPage.click_ReachPage3NextButton();
		// reachPage.click_ReachPage3NextButton_JSExecutor();

	}

	@Then("^User should be able to schedule a campaign")
	public void Schedule_Campaign() {
		SchedulePage schedulePage = new SchedulePage (driver);
		schedulePage.click_startCalednderArrow();
		schedulePage.click_stopCalenderArrow();
		schedulePage.enter_Budget("1000");
		schedulePage.click_SchedulePage1NextButton();
		  try {
			  Thread.sleep(20000); 
			  } 
		  catch (InterruptedException e) {
		  System.out.println("The Review campaign couldn't load"); e.printStackTrace();
		  }  
	    
	}

	@Then("^User should be able to review campaign$")
	public void review_campaign() {
		schedulePage = new SchedulePage(driver);
		schedulePage.explicitly_Wait_For_ReviewPageNextButton();
		adPortalScreenShots = new AdPortalScreenShots(driver);
		adPortalScreenShots.takeScreenShotCreateCampaignDefault();
		schedulePage.click_ReviewPage_NextButton();

	}

	@Then("^User should be able to name their campaign and upload commercial$")
	public void name_campaign_UploadCommercial() throws AWTException, InterruptedException {
		commercialPage = pageObjectManager.getCommercialPage();
		commercialPage.enter_CampaignName_Or_Continue_With_Commercial("TestCampaign");
		commercialPage.enter_Things_To_KnowAbout1("Test1");
		commercialPage.enter_Things_To_KnowAbout2("Test2");
		commercialPage.enter_Things_To_KnowAbout3("Test3");
		commercialPage.enter_Commercial_TagLine("TestCommercial_TagLine");
		commercialPage.click_commercial_UploadBox();
		commercialPage.click_ImageRights_CheckBox();
		commercialPage.click_commercialPage_NextButton();
		       
	}
}