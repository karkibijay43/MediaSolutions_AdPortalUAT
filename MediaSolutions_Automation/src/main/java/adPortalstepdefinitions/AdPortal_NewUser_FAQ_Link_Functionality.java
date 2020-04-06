package adPortalstepdefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

public class AdPortal_NewUser_FAQ_Link_Functionality {

	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage logInPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	AdPortalScreenShots adPortalScreenShots;

	/*
	 * @Given("^I am a new SSU user to Ad Portal$") public void
	 * new_SSU_USer_SignUp() throws InterruptedException { webDriverManager = new
	 * WebDriverManager(); driver = WebDriverManager.getDriver();
	 * driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
	 * configFileReader = new ConfigFileReader(); pageObjectManager = new
	 * PageObjectManager(driver); configFileReader.getApplicationUrl(); signUpPage =
	 * pageObjectManager.getSignUpPage(); signUpPage.navigateTo_SignUpPage();
	 * signUpPage.enter_FirstName("Media"); signUpPage.enter_LastName("Solutions");
	 * signUpPage.enter_BusinessName("Spectrum Reach");
	 * signUpPage.enter_ZipCode("80111");
	 * signUpPage.enter_PhoneNumber("1234567890");
	 * signUpPage.enter_Email("QATestEmail@charter.com");
	 * signUpPage.enter_ConfirmEmail("QATestEmail@charter.com");
	 * signUpPage.enter_Password("testpwd@MS1");
	 * signUpPage.eneter_ConfirmPassword("testpwd@MS1"); signUpPage =
	 * pageObjectManager.getSignUpPage(); signUpPage.click_CheckBox();
	 * ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	 * driver.switchTo().window(tabs.get(1)); driver.close();
	 * driver.switchTo().window(tabs.get(0)); requestDashBoardPage = new
	 * RequestDashBoardPage(driver); signUpPage.click_nextStep();
	 * Thread.sleep(17000); // driver.close();
	 * 
	 * }
	 */

	@When("^I log in using newly created User Email and Password$")
	public void user_LogsIn_Using_New_Email_And_Password() {
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
		logInPage = pageObjectManager.getLogInPage();
		logInPage.enter_LogInEmail("QATestEmail@charter.com");
		logInPage.enter_LogInPassword("testpwd@MS1");
		logInPage.clickLogIn();

	}

	@Then("^I should land on the Ad Portal New Dashboard$")
	public void requestDashboard_verification() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.explicitly_Wait_For_FAQ_Links();
		adPortalScreenShots = new AdPortalScreenShots(driver);
		adPortalScreenShots.takeScreenShotNewDashBoardView_FAQ_Link();

	}

	@Then("^I should see the FAQ links$")
	public void verify_Presence_Of_FAQ_Links() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.verify_FAQ_Header();

	}

	@Then("^When I select the links the links should open the relevant FAQ page in a new browser tab$")
	public void open_FAQ_Page() {
		requestDashBoardPage = new RequestDashBoardPage(driver);
		// requestDashBoardPage.click_LinkText1();
		requestDashBoardPage.click_LinkText();
	}

}
