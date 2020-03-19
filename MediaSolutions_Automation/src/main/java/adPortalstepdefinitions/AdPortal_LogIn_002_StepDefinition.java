package adPortalstepdefinitions;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_LogIn_002_StepDefinition {
	
	WebDriver driver;

	@Given("^User is on AdPortal UAT SignUp Page and clicks LogIn link$")
	public void user_is_on_logIn_page() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver");

		driver = new ChromeDriver();
		  JavascriptExecutor js = (JavascriptExecutor) driver;

		String LogInUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		driver.navigate().to(LogInUrl);
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,100)");
		WebDriverWait logInLink = new WebDriverWait(driver, 30);
	logInLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='login-link']")));
		WebElement LogInLink = driver.findElement(By.xpath("//a[@class='login-link']"));
		LogInLink.click();
	}

	@When("^User enters Existing Email and password and clicks Log in Button$")
	public void enter_UserName_and_Password() {
		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.clear();
		
		String enterEmail;
		enterEmail = JOptionPane.showInputDialog(null, "Enter your Email Address");
		email.sendKeys(enterEmail);
		
		
		String enterPassword;
		enterPassword = JOptionPane.showInputDialog(null, "Enter your Password");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(enterPassword);

		WebElement clickLogIn = driver.findElement(By.xpath("//input[@class='spp-btn']"));
		clickLogIn.click();

	}

	@Then("^User lands on Request Dashboard page$")

	public void requestDashboard_verification() {
		String expectedTitle = "SPP - Creative Requests";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You have landed on the Request DashBoard page");
		} else {
			System.out.println("Please revisit LogIn page and enter valid credentials");
		}

		//driver.close();

	}

}


