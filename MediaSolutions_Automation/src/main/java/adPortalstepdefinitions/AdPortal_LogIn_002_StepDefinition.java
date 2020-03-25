package adPortalstepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_LogIn_002_StepDefinition {
	
	
	WebDriver driver;
	LogInPage logInPage = new LogInPage(driver);
	SignUpPage signUpPage = new SignUpPage(driver);
	RequestDashBoardPage requestDashBoardPage = new RequestDashBoardPage(driver);

	@Given("^User is on AdPortal UAT SignUp Page and clicks LogIn link$")
	public void user_is_on_logIn_page() throws InterruptedException {
		//SignUpPage signUpPage = new SignUpPage(driver);
		System.setProperty("webdriver.chrome.driver","/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String SignUpURL = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		driver.navigate().to(SignUpURL);
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,100)");
		WebDriverWait logInLink = new WebDriverWait(driver, 30);
		logInLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='login-link']")));
		//signUpPage.click_SignuplogInLink();
		WebElement LogInLink =
		driver.findElement(By.xpath("//a[@class='login-link']")); LogInLink.click();
		 
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
		requestDashBoardPage.dashBoardPage_Title_verification();
		

	}

}


