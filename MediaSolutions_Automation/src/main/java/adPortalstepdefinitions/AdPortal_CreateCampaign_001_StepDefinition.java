package adPortalstepdefinitions;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_CreateCampaign_001_StepDefinition {
	WebDriver driver;

	@Given("^User is on AdPortal UAT SignUp page and clicks log in$")
	public void user_is_on_logIn_page() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

		String LogInUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		driver.navigate().to(LogInUrl);
		driver.manage().window().maximize();
		WebElement LogInLink = driver.findElement(By.className("login-link"));
		LogInLink.click();
	}

	@When("^User enters Email and Password and clicks LogIn$")
	public void enter_UserName_and_Password() {

		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.sendKeys("MSTestEmail@charter.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("testpwd@MS1");

		WebElement clickLogIn = driver.findElement(By.className("spp-btn"));
		clickLogIn.click();

		WebDriverWait newRequest = new WebDriverWait(driver, 30);
		newRequest.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='new-request-btn']")));

	}

	@Then("^User should land on Request Dashboard page$")

	public void requestDashboard_verification() {
		driver.navigate().refresh();
		String expectedTitle = "Spectrum Reach Ad Portal";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You have landed on the Request DashBoard Page");
		} else {
			System.out.println("Please revisit LogIn page and enter valid credentials");
		}

	}

	@Then("^User should be able to Get started with the campaign$")

	public void start_campaign() {
		// If the user has already started creating campaign, and needs to continue with
		// the camapign details

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]")));

		WebElement continueButton = driver.findElement(By.xpath(
				"//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]"));
		continueButton.click();

		WebDriverWait waitForNextButton = new WebDriverWait(driver, 30);
		waitForNextButton
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));

		WebElement nextButton = driver.findElement(By.xpath("//div[@class='spp-btn']"));
		nextButton.click();

		WebDriverWait waitForRaiseAwareNessButton = new WebDriverWait(driver, 30);
		waitForRaiseAwareNessButton.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/app-order[1]/div[1]/div[2]/div[1]/div[1]/section[1]/app-goals[1]/app-card-item[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-goals-card[1]/div[2]/button[1]")));

		WebElement reach_RaiseAwareness = driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/app-order[1]/div[1]/div[2]/div[1]/div[1]/section[1]/app-goals[1]/app-card-item[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-goals-card[1]/div[2]/button[1]"));
		reach_RaiseAwareness.click();

		WebElement reach_Next_Button = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		reach_Next_Button.click();

	}

	@Then("^User enters the address on the address field and selects the distance and clicks Next$")
	public void enter_Address_and_Distance() throws InterruptedException

	{
		WebDriverWait waitForAddressEntry = new WebDriverWait(driver, 10);
		waitForAddressEntry.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter a location']")));

		WebElement AddressField = driver.findElement(By.xpath("//input[@placeholder='Enter a location']"));
		AddressField.clear();
		AddressField.sendKeys("Austin");
		

		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		AddressField.sendKeys(Keys.ARROW_DOWN);
		WebElement headerTitle = driver.findElement(By.xpath("//div[@class='header large ng-star-inserted']"));
		headerTitle.click();

		WebElement distanceArrowdropdown = driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']"));
		distanceArrowdropdown.click();		

		WebElement defaultDistance = driver.findElement(By.xpath("//span[contains(text(),'50 miles')]"));
		defaultDistance.click();

		WebElement reachNextButton = driver.findElement(By.className("spp-btn"));

		if (reachNextButton.isEnabled()) {
			reachNextButton.click();
		} else {

			System.out.println("Next button is not enabled");
		}

		try {
			reachNextButton.click();

		} catch (StaleElementReferenceException e) {
			driver.findElement(By.className("spp-btn")).click();
		}
	}

	

	@Then("^User should be able to schedule a campaign")
	public void Schedule_Campaign() {
		WebElement StartCalenderArrow = driver.findElement(By.xpath(
				"//div[@id='schedule-date-budget-wrapper']//div[1]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]"));
		StartCalenderArrow.click();

		driver.findElement(By.tagName("dp-day-calendar"));

		List<WebElement> allStartDates = driver.findElements(By.tagName("button"));

		for (WebElement dates : allStartDates) {

			String date = dates.getText();

			if (date.equalsIgnoreCase("30")) {
				dates.click();
				break;

			}
		}

		WebElement EndCalenderArrow = driver.findElement(By.xpath(
				"//body//div[@id='card-item-wrapper']//div//div//div[2]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]"));
		EndCalenderArrow.click();
		driver.findElement(By.tagName("dp-day-calendar"));

		List<WebElement> allEndDates = driver.findElements(By.tagName("button"));

		for (WebElement dates : allEndDates) {

			String date = dates.getText();

			if (date.equalsIgnoreCase("5")) {
				dates.click();
				break;

			}
		}

		WebElement budgetAmount = driver.findElement(By.xpath("//input[@id='budget']"));
		budgetAmount.clear();
		budgetAmount.sendKeys(String.valueOf(500));
		WebElement ScheduleNextButton = driver.findElement(By.className("spp-btn"));
		ScheduleNextButton.click();
	}
	
	

}
