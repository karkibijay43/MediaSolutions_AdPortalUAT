package adPortalstepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import com.aventstack.extentreports.ExtentReports;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

public class AdPortal_LogIn_002_StepDefinition {

	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage loginPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	AdPortalScreenShots adPortalScreenShots;

	@Given("^User is on AdPortal UAT SignUp Page and clicks LogIn link$")
	public void user_is_on_logIn_page() throws InterruptedException {
		
		webDriverManager = new WebDriverManager();
		driver = WebDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		// configFileReader.getLoginURL();
		// configFileReader.getApplicationUrl();
		//logInPage = pageObjectManager.getLogInPage();
		//logInPage.navigateTo_LogInPage();
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

	@When("^User enters Existing Email and password and clicks Log in Button$")
	public void enter_UserName_and_Password() {

		LogInPage logInPage = new LogInPage(driver);
		logInPage.userInPut_LogInEmail();
		logInPage.userInPut_LogInPassword();
		logInPage.clickLogIn();

	}

	@Then("^User lands on Request Dashboard page$")

	public void requestDashboard_verification() {
		adPortalScreenShots = new AdPortalScreenShots(driver);
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.dashBoardPage_Title_verification();
		adPortalScreenShots.takeScreenShotLoginTest();
	

	}

}
