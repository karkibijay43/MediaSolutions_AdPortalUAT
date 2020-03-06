package StepDefinitions;

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

public class SSOSignUpStepDefinition {
	WebDriver driver;

	@Given("^User is on AdPortalUAT signUP Page$")
	public void User_is_on_SignUp_page() {
		System.setProperty("webdriver.chrome.driver", "/Users/p2815492/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String baseUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";

		// launch Chrome browser and direct it to the Base URL
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@When("^User enters First Namme,Last Name,Business Name, Zip Code,Phone NUmbmer,Email and Password$")
	public void enter_DataField() {

		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		firstName.sendKeys("Media");

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		lastName.sendKeys("Solutiions");

		WebElement businessName = driver.findElement(By.xpath("//*[@id=\"businessName\"]"));
		businessName.sendKeys("Spectrum_Reach");

		WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"zipCode\"]"));
		zipCode.sendKeys(String.valueOf(80111));

		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"businessPhone\"]"));
		phoneNumber.sendKeys(String.valueOf(1234567890));

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("MSTestEmail@charter.com");

		WebElement confirmEmail = driver.findElement(By.id("confirm-email"));
		confirmEmail.sendKeys("MSTestEmail@charter.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("testpwd@MS1");

		WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
		confirmPassword.sendKeys("testpwd@MS1");

	}

	@Then("^User Accepts Licesne Agreement and clicks Next Step$")

	public void Read_Accept_licenseAgreement() {

		// WebDriverWait wait = new WebDriverWait(driver,20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#isTermAccepted")));
		WebElement checkBox = driver.findElement(By.className("is-term-accepted-label"));
		// WebElement checkBox = driver.findElement(By.cssSelector("#isTermAccepted"));
		checkBox.click();
		
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//below code will switch to new tab
		driver.switchTo().window(tabs.get(1));
		//perform whatever actions you want in new tab then close it
		driver.close();
		//Switch back to your original tab
		driver.switchTo().window(tabs.get(0));
		
		//driver.switchTo().defaultContent();

		if (checkBox.isSelected()) { 

			System.out.println("You have accepted Spectrum Reach Ad Portal Terms And Conditions");

		}

		else {
			System.out.println("You have Not accepted Spectrum Reach Ad Portal Terms And Conditions");

		}

	}

//	@Then("^User should be able to create log in credentiasls for AdportalUAT$")
//
//	public void next_step_LogIn() {
//		WebElement nextStep = driver.findElement(By.className("spp-btn"));
//		if (nextStep.isEnabled()) {
//			nextStep.click();
//		} else {
//			System.out.println("Please Enter Reqjuired field and accept Licesne Agreement");
//		}
	//}
}
