package adPortalstepdefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

public class AdPortal_SSU_LogIn_SignUp_001_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage loginPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;

	@Given("^User is on AdPortal UAT sign up page$")
	public void user_is_on_SignUp_page() throws Throwable {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader.getApplicationUrl();
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();

	}

	@When("^User enters First Namme,Last Name,Business Name, Zip Code,Phone NUmbmer,Email and Password$")
	public void enter_DataField() {

		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.enter_FirstName("Media");
		signUpPage.enter_LastName("Solutions");
		signUpPage.enter_BusinessName("Spectrum Reach");
		signUpPage.enter_ZipCode("80111");
		signUpPage.enter_PhoneNumber("1234567890");
		signUpPage.enter_Email("MSTestEmail@charter.com");
		signUpPage.enter_ConfirmEmail("MSTestEmail@charter.com");
		signUpPage.enter_Password("testpwd@MS1");
		signUpPage.eneter_ConfirmPassword("testpwd@MS1");

	}

	@Then("^User Reads and agrees Terms and conditions and clicks Next Step$")

	public void read_Accept_licenseAgreement() {

		// WebDriverWait wait = new WebDriverWait(driver,20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#isTermAccepted")));

		// WebElement checkBox =
		// driver.findElement(By.className("is-term-accepted-label"));
		// checkBox.click();

		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.click_CheckBox();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		driver.close();

		driver.switchTo().window(tabs.get(0));

	}

	@Then("^User should be able to create log in credentiasls for Adportal UAT$")
	public void next_step_LogIn() {
		// WebElement nextStep = driver.findElement(By.className("spp-btn"));
		requestDashBoardPage =new RequestDashBoardPage (driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.click_nextStep();
		
	
		 WebDriverWait wait = new WebDriverWait(driver,20);
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]")));
				 requestDashBoardPage.request_DashBoard_Verification();
				 driver.close();
	}
}

