package adPortalstepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_CreateCampaign_002_StepDefinition {
	WebDriver driver;

	@Given("^User is on AdPortal UAT SignUp page and clicks Log in$")
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

	@When("^User enters Existing Email and Password and clicks LogIn$")
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

	@Then("^User should land on Request Dashboard page with Campaign drafts$")

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

	@Then("^User should be able to Get started or continue with the campaign$")

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

	@Then("^User enters the address on the address field and selects the distance in miles and clicks Next$")
	public void enter_Address_and_Distance() throws InterruptedException

	{
		WebDriverWait waitForAddressEntry = new WebDriverWait(driver, 10);
		waitForAddressEntry.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Enter a location']")));

		WebElement AddressField = driver.findElement(By.xpath("//input[@placeholder='Enter a location']"));
		AddressField.clear();

		// prompt the user to enter their Address

		String EnterAddress;
		EnterAddress = JOptionPane.showInputDialog(null, "Enter your Address");

		/*
		 * Scanner AddressScanner = new Scanner(System.in);
		 * System.out.println("please enter the address for your commercial to air:");
		 * String EnterAddress = AddressScanner.nextLine(); AddressScanner.close();
		 */
		AddressField.sendKeys(EnterAddress);

		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		AddressField.sendKeys(Keys.ARROW_DOWN);
		// AddressField.sendKeys(Keys.RETURN);

		WebElement headerTitle = driver.findElement(By.xpath("//div[@class='header large ng-star-inserted']"));
		headerTitle.click();

		WebElement distanceArrowdropdown = driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']"));
		distanceArrowdropdown.click();
		// driver.findElement(By.id("a67b21b5bfa9"));

		// int distance;
		String enterDistance;
		enterDistance = JOptionPane.showInputDialog(null, "Enter your Distance in miles");
		// distance = Integer.parseInt(enterDistance);

		driver.findElement(By.xpath("//span[contains(text(),'50 miles')]"));

		if (enterDistance.equals("2")) {
			driver.findElement(By.xpath(
					"//div[@class='ng-option ng-option-selected ng-star-inserted ng-option-marked']//span[@class='ng-option-label ng-star-inserted'][contains(text(),'2 miles')]"))
					.click();

		} else if (enterDistance.equals("20")) {
			driver.findElement(By.xpath("//span[contains(text(),'20 miles')]")).click();
		}

		else if (enterDistance.equals("30")) {
			driver.findElement(
					By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'30 miles')]")).click();
		} else if (enterDistance.equals("40")) {
			driver.findElement(By.xpath("//span[contains(text(),'40 miles')]")).click();
		}

		if (enterDistance.equals("50")) {
			driver.findElement(By.xpath("//span[contains(text(),'50 miles')]")).click();
		}

		else {
			System.out.println("Please enter valid Distance in miles");
		}

		/*
		 * else if (distance ==4) {
		 * 
		 * driver.findElement(By.
		 * xpath("//div[@class='ng-option ng-option-selected ng-star-inserted']//span[@class='ng-option-label ng-star-inserted'][contains(text(),'4 miles')]"
		 * )).click(); }
		 * 
		 * else if (distance ==6) { driver.findElement(By.
		 * xpath("//div[@class='ng-option ng-option-selected ng-star-inserted ng-option-marked']//span[@class='ng-option-label ng-star-inserted'][contains(text(),'6 miles')]"
		 * )); } else if (distance ==8) { driver.findElement(By.
		 * xpath("//div[@class='ng-option ng-star-inserted ng-option-marked']//span[@class='ng-option-label ng-star-inserted'][contains(text(),'8 miles')]"
		 * )); } else if (distance == 10) { driver.findElement(By.
		 * xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'10 miles')]"
		 * )); } else if (distance ==12) {
		 * driver.findElement(By.xpath("//span[contains(text(),'12 miles')]")); } else
		 * if (distance ==14) { driver.findElement(By.
		 * xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'14 miles')]"
		 * )); } else if (distance ==16) {
		 * driver.findElement(By.xpath("//span[contains(text(),'16 miles')]")); } else
		 * if (distance ==18) {
		 * driver.findElement(By.xpath("//span[contains(text(),'18 miles')]")); } else
		 */

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

	/*
	 * WebDriverWait waitForGenderSelect = new WebDriverWait(driver, 10);
	 * waitForGenderSelect.until(ExpectedConditions.presenceOfElementLocated(By.
	 * xpath(
	 * "//*[@id=\"card-item-wrapper\"]/div/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div[2]/div[2]/label/span"
	 * )));
	 * 
	 * WebElement genderSelect = driver.findElement(By.xpath(
	 * "//*[@id=\"card-item-wrapper\"]/div/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div[2]/div[2]/label/span"
	 * )); genderSelect.click();
	 * 
	 * reachNextButton.click();
	 */

	@Then("^User should be able to create a campaign ofor selected Dates$")
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
		int Amount;
		String enterBudgetAmount;
		enterBudgetAmount = JOptionPane.showInputDialog(null, "Enter your budget amount");
		Amount = Integer.parseInt(enterBudgetAmount);
		budgetAmount.sendKeys(String.valueOf(Amount));
		if (Amount > 10000) {
			JOptionPane.showMessageDialog(null, "Invalid Budget Amount, Budget Should be Between $250 and $10000");
		}

		WebElement ScheduleNextButton = driver.findElement(By.className("spp-btn"));
		ScheduleNextButton.click();
	}

}

