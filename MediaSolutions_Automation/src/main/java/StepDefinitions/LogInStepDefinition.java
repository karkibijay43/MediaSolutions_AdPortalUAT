package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LogInStepDefinition {

	WebDriver driver;

	@Given("^User is on AdPortal Login Page$")
	public void User_is_on_logIn_page() {
		System.setProperty("webdriver.chrome.driver", "/Users/p2815492/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String baseUrl = "https://adportal-uat.brandcdnstage.com/login";

		// launch Chrome browser and direct it to the Base URL
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@When("^User enters Username and Password$")
	public void enter_UserName_and_Password() {

		driver.findElement(By.className("login-link")).click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("email")).sendKeys("c-bijay.karki@charter.com");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("password")).sendKeys("Metallica@8848");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.className("spp-btn")).click();

		// driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}

	@Then("^User should land on Request Dashboard page$")

	public void requestDashboard_verification() {

		// String DashboardURL = "https://adportal-uat.brandcdnstage.com/dashboard";

		String actualURL = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/*
		 * if (actualURL.contentEquals(DashboardURL)) {
		 * System.out.println("TestPassed!"); }
		 * 
		 * else { System.out.println("TestFailed");
		 * System.out.println("The URL of this page is:" + actualURL);
		 * 
		 * }
		 */
		System.out.println("The URL of this page is:" + actualURL);
	}

	@Then("^User should be able to Get started with the campaign$")

	public void start_campaign() {
		driver.findElement(By.id("new-request-btn")).click();

	}

	{
		// driver.close();
	}

}
