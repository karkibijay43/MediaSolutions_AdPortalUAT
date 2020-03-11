package adPortalstepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LogInStepDefinition {

	WebDriver driver;

	@Given("^User is on AdPortal UAT Login Page$")
	public void user_is_on_logIn_page() {

		System.setProperty("webdriver.chrome.driver","/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver");

		driver = new ChromeDriver();

		String LogInUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		driver.navigate().to(LogInUrl);
		// driver.get(LogInUrl);

		driver.manage().window().maximize();
		WebElement LogInLink = driver.findElement(By.xpath("//a[@class='login-link']"));
		LogInLink.click();
	}

	@When("^User enters Username and Password and clicks Log in$")
	public void enter_UserName_and_Password() {

		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.sendKeys("MSTestEmail@charter.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("testpwd@MS1");

		WebElement clickLogIn = driver.findElement(By.className("spp-btn"));
		clickLogIn.click();

	}

	@Then("^User lands on Request Dashboard page$")

	public void requestDashboard_verification() {
		String expectedTitle = "SPP - Creative Requests";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You Have landed on the Request DashBoard Page");
		} else {
			System.out.println("Please revisit LogIn page and enter valid credentials");
		}

		driver.close();

	}

}
