package adPortalstepdefinitions;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adPortalUtilities.AdPortalScreenShots;
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
	AdPortalScreenShots adPortalScreenShots;
	

	@Given("^User is on AdPortal UAT SignUp Page and clicks Log in link$")
@Test
	public void user_is_on_AdPortal_UAT_SignUp_page() {
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
		 
		
		/*
		 * signUpPage = pageObjectManager.getSignUpPage();
		 * signUpPage.explicitly_Wait_ForLogInLink(); signUpPage.click_Login();
		 */

		/*
		 * webDriverManager = new WebDriverManager(); driver =
		 * webDriverManager.getDriver(); configFileReader = new ConfigFileReader();
		 * pageObjectManager = new PageObjectManager(driver);
		 * configFileReader.getApplicationUrl(); signUpPage =
		 * pageObjectManager.getSignUpPage(); signUpPage.navigateTo_SignUpPage();
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,100)");
		 * signUpPage.explicitly_Wait_ForLogInLink(); signUpPage.click_Login();
		 */
	}

	@When("^User enters username and password and clicks log in$")
@Test
	public void enter_UserName_and_Password() throws IOException {
		loginPage = new LogInPage(driver);
		loginPage.enter_LogInEmail("MSTestEmail@charter.com");
		loginPage.enter_LogInPassword("testpwd@MS1");
		loginPage.clickLogIn();
	     
	}

	@Then("^User lands on request dashboard page$")
@Test
	public void requestDashboard_verification() {
		adPortalScreenShots = new AdPortalScreenShots(driver);
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_ContinueButton();
		requestDashBoardPage.dashBoardPage_Title_verification();
		// adPortalScreenShots.takeScreenShotLoginTest(); 
		  }
		 
			
}

