package adPortalstepdefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_NewCustomerDashboardView_001_StepDefinition {
	WebDriver driver;

	@Given("^A new User is on AdPortal UAT SignUP page$")
	public void user_is_on_SignUp_page() {
		System.setProperty("webdriver.chrome.driver", "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS);
		String SSO_SignUpUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		driver.get(SSO_SignUpUrl );
		driver.manage().window().maximize();
	}

	@When("^User enters all required fields$")
	public void enter_DataField() {

		WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
		firstName.sendKeys("Spectrum");

		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Reach");

		WebElement businessName = driver.findElement(By.xpath("//*[@id=\"businessName\"]"));
		businessName.sendKeys("Spectrum Reach");

		WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"zipCode\"]"));
		zipCode.sendKeys(String.valueOf(80111));

		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"businessPhone\"]"));
		phoneNumber.sendKeys(String.valueOf(1234567890));

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("SRTestEmail@charter.com");

		WebElement confirmEmail = driver.findElement(By.id("confirm-email"));
		confirmEmail.sendKeys("SRTestEmail@charter.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("testpwd@MS1");

		WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
		confirmPassword.sendKeys("testpwd@MS1");

	}

	@Then("^User accepts licesne agreement and clicks Next Step$")

	public void read_Accept_licenseAgreement() {
		WebElement checkBox = driver.findElement(By.className("is-term-accepted-label"));
		checkBox.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		driver.close();

		driver.switchTo().window(tabs.get(0));
		
		WebElement nextStep = driver.findElement(By.className("spp-btn"));
		if (nextStep.isEnabled()) 
		{
			nextStep.click();
		} 
		else 
		{
			System.out.println("Please enter required field and accept License Agreement");
		}

		

	}
	
	@Then ("^User should be able to see blank dashboard page wtih no campaigns$")
	public void requestDashboard_verification() {
		
		WebDriverWait wait = new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Get Started')]")));
		WebElement getStarted = driver.findElement(By.xpath("//span[contains(text(),'Get Started')]"));
		getStarted.click();
				
		String expectedTitle = "SPP - Creative Requests";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You Have landed on the Request DashBoard Page");
		} else {
			System.out.println("Please revisit LogIn page and enter valid credentials");
		}
		
			

	}

	
	@Then("^User will be taken to the Reach page$")
	public void reachPage_verification () {
		String expectedTitle = "SPP - Creative Requests";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You have landed on the reach page");
		} else {
			System.out.println("This is not a reach page");
		}
		
		//driver.close();
	
		
	}

		

	
	
}


