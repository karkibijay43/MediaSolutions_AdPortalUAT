package adPortalstepdefinitions;

import java.awt.AWTException;
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

//import com.aventstack.extentreports.ExtentReports;

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

public class AdPortal_CreateCampaign_002_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	ReachPage reachPage;
	SchedulePage schedulePage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	CommercialPage commercialPage;
	AdPortalScreenShots adPortalScreenShots;

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
		signUpPage.click_Login();

	}

	@When("^User enters Existing Email and Password and clicks LogIn$")
	public void enter_UserName_and_Password() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		logInPage = new LogInPage(driver);
		logInPage.enter_LogInEmail("MSolutionsTestEmail@charter.com");
		logInPage.enter_LogInPassword("testpwd@MS1");
		logInPage.clickLogIn();

	}

	@Then("^User should land on Request Dashboard page with Campaign drafts$")

	public void requestDashboard_verification() {
		requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.request_DashBoard_Verification();

	}

	@Then("^User should be able to Get started or continue with the campaign$")

	public void start_campaign() {
		reachPage = pageObjectManager.getReachPage();
		requestDashBoardPage = pageObjectManager.getRequestDashBoardPage();
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.click_Continue();
		reachPage.explicitly_Wait_For_ReachPageNextButton();
		reachPage.click_ReachPageNextButton();
		reachPage.explicitly_Wait_For_RaiseAwarenessButton();
		reachPage.select_RaiseAwareness();
		reachPage.click_ReachPage1NextButton();

	}

	@Then("^User enters the address on the address field and selects the distance in miles and clicks Next$")
	public void enter_Address_and_Distance() throws InterruptedException {
		ReachPage reachPage = new ReachPage(driver);
		reachPage.explicitly_Wait_For_AddressEntry();
		reachPage.UserInPut_Address();
		reachPage.click_HeaderTtile();
		reachPage.click_DropDownAroow();
		reachPage.UserInPut_Distance();
		reachPage.click_ReachPage2NextButton();
		reachPage.click_ReachPage3NextButton();
	}

	@Then("^User should be able to create a campaign for selected Dates$")
	public void Schedule_Campaign() {
		SchedulePage schedulePage = new SchedulePage(driver);
		schedulePage.click_startCalednderArrow();
		schedulePage.click_stopCalenderArrow();
		schedulePage.enter_Budget_UserInput();
		schedulePage.click_SchedulePage1NextButton();

	}

	@Then("^User should be able to review their campaign Details$")
	public void review_campaign_details() {
		schedulePage = new SchedulePage(driver);
		schedulePage.explicitly_Wait_For_ReviewPageNextButton();
		adPortalScreenShots = new AdPortalScreenShots(driver);
		adPortalScreenShots.takeScreenShotCreateCampaignDefault_RewviewPage();
		schedulePage.click_SchedulePage2_NextButton();
	}

	@Then("^User should be able to name campaign and upload commercial$")
	public void name_campaign_UploadCommercial() throws AWTException, InterruptedException {
		commercialPage = pageObjectManager.getCommercialPage();
		schedulePage.enter_CampaignName_Or_Continue_With_Commercial("TestCampaign");
		commercialPage.enter_Things_To_KnowAbout1("Test1");
		commercialPage.enter_Things_To_KnowAbout2("Test2");
		commercialPage.enter_Things_To_KnowAbout3("Test3");
		commercialPage.enter_Commercial_TagLine("TestCommercial_TagLine");
		commercialPage.click_commercial_UploadBox();
		commercialPage.click_ImageRights_CheckBox();
		commercialPage.click_CommericialPage1_NextButton();
		commercialPage.enter_primary_Call_To_Action("Give us a call");
		commercialPage.enter_Street_Address("6501 S Fiddlers Green cir");
		commercialPage.enter_Apartment("007");
		commercialPage.enter_City("Greenwood Village");
		commercialPage.select_State("CO");
		commercialPage.enter_Zip_Code("80111");
		commercialPage.enter_PhoneNumber("1234567890");
		commercialPage.enter_Website_URL("Adportal.com");
		commercialPage.enter_Email_Address("MSTestEmail@charter.com");
		commercialPage.enter_Other_Way_To_Contact("MSolutionsTestemail@charter.com");
		commercialPage.enter_Other_Message_For_Audience("This is a test camppaign");
		commercialPage.click_commercialPage2_NextButton();
		commercialPage.select_Voice_Preference();
		commercialPage.select_Music_Preference();
		commercialPage.enter_Special_Instructions("Media solutions test campaign");
		commercialPage.click_CommercialPage3_NextButton();
	}
}
