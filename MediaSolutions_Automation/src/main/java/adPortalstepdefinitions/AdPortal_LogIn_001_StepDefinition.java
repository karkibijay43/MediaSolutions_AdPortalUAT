package adPortalstepdefinitions;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import adPortalFramework.helper.WaitForWebElement;
import adPortalTestBase.TestBase;
import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class AdPortal_LogIn_001_StepDefinition extends TestBase {

	WebDriver driver;
	LogInPage loginPage = new LogInPage(driver);
	SignUpPage signUpPage = new SignUpPage(driver);
	RequestDashBoardPage requestDashBoardPage = new RequestDashBoardPage(driver);
	//WaitForWebElement explicitlyWait = new WaitForWebElement(driver);

	@Given("^User is on AdPortal UAT SignUp Page and clicks Log in link$")
	public void user_is_on_AdPortal_UAT_SignUp_page() {
		System.setProperty("webdriver.chrome.driver","/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver");

		driver = new ChromeDriver();
		
		loginPage.page_Scroll_Down();
		
		
		
		loginPage.explicitly_Wait_ForLogInLink();
		
		signUpPage.click_SignuplogInLink();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * 
		 * String LogInUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		 * driver.navigate().to(LogInUrl); driver.manage().window().maximize();
		 * js.executeScript("window.scrollBy(0,100)");
		 
		WebDriverWait logInLink = new WebDriverWait(driver, 30);
	logInLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='login-link']")));
		WebElement LogInLink = driver.findElement(By.xpath("//a[@class='login-link']"));
		loginPage.signuplogInLink.click();*/
	}

	@When("^User enters username and password and clicks log in$")
	public void enter_UserName_and_Password() {
		loginPage.enter_LogInEmail("MSolutionsTestEmail@charter.com");
		
		loginPage.enter_LogInPassword("testpwd@MS1");
		
		/*
		 * WebElement email = driver.findElement(By.cssSelector("#email"));
		 * email.sendKeys("MSolutionsTestEmail@charter.com");
		 * 
		 * WebElement password = driver.findElement(By.id("password"));
		 * password.sendKeys("testpwd@MS1");
		 * 
		 * WebElement clickLogIn =
		 * driver.findElement(By.xpath("//input[@class='spp-btn']"));
		 * clickLogIn.click();
		 */

	}

	@Then("^User lands on request dashboard page$")

	public void requestDashboard_verification() {
		requestDashBoardPage.dashBoardPage_Title_verification();
		/*
		 * String expectedTitle = "SPP - Creative Requests"; String actualTitle =
		 * driver.getTitle(); System.out.println("The Title this page is:" + " " +
		 * actualTitle);
		 * 
		 * if (expectedTitle.equalsIgnoreCase(actualTitle)) {
		 * System.out.println("You have landed on the Request DashBoard page"); } else {
		 * System.out.println("Please revisit LogIn page and enter valid credentials");
		 * }
		 */

		

	}
	
	{
		driver.close();
	}
}
