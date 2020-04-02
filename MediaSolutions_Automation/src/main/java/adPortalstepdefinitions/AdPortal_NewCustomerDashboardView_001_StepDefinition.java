package adPortalstepdefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
public class AdPortal_NewCustomerDashboardView_001_StepDefinition {
	

	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage loginPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	// ExtentReports extent; 
	AdPortalScreenShots adPortalScreenShots;
	

	@Given("^A new User is on AdPortal UAT SignUP page$")
	public void user_is_on_SignUp_page() {
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
	
	@When("^User enters all required fields$")
	public void enter_DataField() {
		
		//SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.enter_FirstName("Media");
		signUpPage.enter_LastName("Solutions");
		signUpPage.enter_BusinessName("Spectrum Reach");
		signUpPage.enter_ZipCode("80111");
		signUpPage.enter_PhoneNumber("1234567890");
		signUpPage.enter_Email("SpectrumReachTestEmail@charter.com");
		signUpPage.enter_ConfirmEmail("SpectrumReachTestEmail@charter.com");
		signUpPage.enter_Password("testpwd@MS1");
		signUpPage.eneter_ConfirmPassword("testpwd@MS1");
		

	}

	@Then("^User accepts licesne agreement and clicks Next Step$")

	public void read_Accept_licenseAgreement() {
		
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.click_CheckBox();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		driver.close();

		driver.switchTo().window(tabs.get(0));
		signUpPage.click_nextStep();
		
		
		

	}
	
	@Then ("^User should be able to see blank dashboard page wtih no campaigns$")
	public void requestDashboard_verification() {
		
		requestDashBoardPage.explicitly_Wait_For_GetStartedButton();
		requestDashBoardPage.click_GetStarted();
		requestDashBoardPage.dashBoardPage_Title_verification();
		driver.close();
		

	}

	
	@Then("^User will be taken to the Reach page$")
	public void reachPage_verification () {
		String expectedTitle = "SPP - Creative Requests";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You have landed on the reach page");
		} else {
			System.out.println("This is not a reach page");
		}
		
		//driver.close();
	
		
	}

		

	
	
}


