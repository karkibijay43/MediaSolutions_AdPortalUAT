package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LogInStepDefinition {

	WebDriver driver;

	@Given("^User is on AdPortal Login Page$")
	public void user_is_on_logIn_page() {
		System.setProperty("webdriver.chrome.driver", "/Users/p2815492/Desktop/chromedriver");
		driver = new ChromeDriver();

		String LogInUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		driver.navigate().to(LogInUrl);
		// driver.get(LogInUrl);

		driver.manage().window().maximize();
		WebElement LogInLink = driver.findElement(By.className("login-link"));
		LogInLink.click();
	}

	@When("^User enters Username and Password$")
	public void enter_UserName_and_Password() {

		WebElement email = driver.findElement(By.cssSelector("#email"));
		// confirmEmail.sendKeys("MSTestEmail@charter.com");
		email.sendKeys("MSolutionsTestEmail@charter.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("testpwd@MS1");

		WebElement clickLogIn = driver.findElement(By.className("spp-btn"));
		clickLogIn.click();

	}

	/*
	 * @Then("^User should land on Request Dashboard page$")
	 * 
	 * public void requestDashboard_verification() { String expectedTitle =
	 * "SPP - Creative Requests"; String actualTitle = driver.getTitle();
	 * System.out.println("The Title this page is:" + actualTitle); if
	 * (expectedTitle == actualTitle) {
	 * System.out.println("You Have landed on the Request DashBoard Page"); } else {
	 * System.out.println("Please Revisit Log in to get started"); }
	 * 
	 * 
	 * System.out.println("The Title this page is:" + actualTitle); }
	 */

	@Then("^User should be able to Get started with the campaign$")

	public void start_campaign() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//*[@id=\"tv-main\"]/app-dashboard-new/div[1]/div[2]/div/app-empty-dashboard/div/div/div[1]/div[3]/button")));

		WebElement getStarted = driver.findElement(By.xpath(
				"//*[@id=\"tv-main\"]/app-dashboard-new/div[1]/div[2]/div/app-empty-dashboard/div/div/div[1]/div[3]/button"));
		getStarted.click();

		WebElement nextButton = driver.findElement(By
				.xpath("//*[@id=\"card-item-wrapper\"]/div/div[2]/div[1]/div/div[1]/app-goals-card[1]/div[2]/button"));
		nextButton.click();
		WebElement reach_RaiseAwareness = driver
				.findElement(By.xpath("//*[@id=\"card-item-wrapper\"]/div/div[2]/div[2]/div/div/span"));
		reach_RaiseAwareness.click();
		WebElement reach_Next_Button = driver
				.findElement(By.xpath("//*[@id=\"card-item-wrapper\"]/div/div[2]/div[2]/div[3]/div"));
		reach_Next_Button.click();

	}

	{
		// driver.close();
	}

}
