package adPortalstepdefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import adPortalTestBase.TestBase;
import adportalPageObjects.SignUpPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdPortal_SSU_LogIn_SignUp_001_StepDefinition extends TestBase {
	WebDriver driver ;
	
	SignUpPage signUpPage = new SignUpPage(driver);
	
@Given("^User is on AdPortal UAT sign up page$")
public void user_is_on_SignUp_page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver"); 
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(30,
	  TimeUnit.SECONDS); String SSO_SignUpUrl =
	  "https://adportal-uat.brandcdnstage.com/sign-up-1"; 
	  driver.get(SSO_SignUpUrl
	  ); driver.manage().window().maximize();
	 
}

@When("^User enters First Namme,Last Name,Business Name, Zip Code,Phone NUmbmer,Email and Password$")
public void enter_DataField() {
	
	
	SignUpPage signUpPage = new SignUpPage(driver);
	signUpPage.enter_FirstName("Media");
	signUpPage.enter_LastName("Solutions");
	signUpPage.enter_BusinessName("Spectrum Reach");
	signUpPage.enter_ZipCode("80111");
	signUpPage.enter_PhoneNumber("1234567890");
	signUpPage.enter_Email("MSTestEmail@charter.com");
	signUpPage.enter_ConfirmEmail("MSTestEmail@charter.com");
	signUpPage.enter_Password("testpwd@MS1");
	signUpPage.eneter_ConfirmPassword("testpwd@MS1");
	
	
	

		/*
		 * WebElement firstName = driver.findElement(By.id("firstName"));
		 * firstName.sendKeys("Media");
		 * 
		 * WebElement lastName = driver.findElement(By.id("lastName"));
		 * lastName.sendKeys("Solutions");
		 * 
		 * WebElement businessName =
		 * driver.findElement(By.xpath("//*[@id=\"businessName\"]"));
		 * businessName.sendKeys("Spectrum Reach");
		 * 
		 * WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"zipCode\"]"));
		 * zipCode.sendKeys(String.valueOf(80111));
		 * 
		 * WebElement phoneNumber =
		 * driver.findElement(By.xpath("//*[@id=\"businessPhone\"]"));
		 * phoneNumber.sendKeys(String.valueOf(1234567890));
		 * 
		 * WebElement email = driver.findElement(By.id("email"));
		 * email.sendKeys("MSTestEmail@charter.com");
		 * 
		 * WebElement confirmEmail = driver.findElement(By.id("confirm-email"));
		 * confirmEmail.sendKeys("MSTestEmail@charter.com");
		 * 
		 * WebElement password = driver.findElement(By.id("password"));
		 * password.sendKeys("testpwd@MS1");
		 * 
		 * WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
		 * confirmPassword.sendKeys("testpwd@MS1");
		 */
}

@Then("^User Reads and agrees Terms and conditions and clicks Next Step$")

public void read_Accept_licenseAgreement() {

 //WebDriverWait wait = new WebDriverWait(driver,20);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#isTermAccepted")));

	//WebElement checkBox = driver.findElement(By.className("is-term-accepted-label"));
	//checkBox.click();
	
	SignUpPage signUpPage = new SignUpPage(driver);
	signUpPage.click_CheckBox();
	
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

	driver.switchTo().window(tabs.get(1));

	driver.close();

	driver.switchTo().window(tabs.get(0));
	


	

}

@Then("^User should be able to create log in credentiasls for Adportal UAT$")
public void next_step_LogIn() {
	//WebElement nextStep = driver.findElement(By.className("spp-btn"));
	SignUpPage signUpPage = new SignUpPage(driver);
	signUpPage.click_nextStep();
}
}






/*extends TestBase {
	WebDriver driver;
	SignUpPage signUpPage = new SignUpPage(driver);
	//xsPageFactory.initElements driver, SignUpPage ;

	
	@Given("^User is on AdPortal UAT sign up page$")
	public void user_is_on_AdPortal_UAT_sign_up_page () throws Throwable {
		System.setProperty("webdriver.chrome.driver","/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver"); 
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 String SSO_SignUpUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
		 driver.get(SSO_SignUpUrl ); 
		 driver.manage().window().maximize();
	}

	@When("^User enters First Namme as \"([^\"]*)\" and Last Name as \"([^\"]*)\"$")
	public void user_enters_First_Namme_as_and_Last_Name_as(String arg1, String arg2) throws Throwable {
	   SignUpPage.txtBox_FirstName.isEnabled();
	   SignUpPage.enter_FirstName(arg1);
	   SignUpPage.enter_LastName(arg2);
	   
	    throw new PendingException();
	}

	@When("^User enters Business Name as \"([^\"]*)\"$")
	public void user_enters_Business_Name_as(String arg1) throws Throwable {
	  SignUpPage.enter_BusinessName(arg1);
	    throw new PendingException();
	}

	@When("^USer Enters Zip Code as \"([^\"]*)\" and Phone NUmbmer as \"([^\"]*)\"$")
	public void user_Enters_Zip_Code_as_and_Phone_NUmbmer_as(String arg1, String arg2) throws Throwable {
	  SignUpPage.enter_ZipCode(arg1);
	  SignUpPage.enter_PhoneNumber(arg2);
	    throw new PendingException();
	}

	@When("^User enters Email as \"([^\"]*)\" and confirms Email as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_confirms_Email_as(String arg1, String arg2) throws Throwable {
	   SignUpPage.enter_Email(arg1);
	   SignUpPage.enter_ConfirmEmail(arg2);
	    throw new PendingException();
	    
	}

	@When("^USer enter Password as \"([^\"]*)\" and confirms password as \"([^\"]*)\"$")
	public void user_enter_Password_as_and_confirms_password_as(String arg1, String arg2) throws Throwable {
	    SignUpPage.enter_Password(arg1);
	    SignUpPage.eneter_ConfirmPassword(arg2);
	    throw new PendingException();
	}
	@Then ("User Reads and agrees Terms and conditions and clicks Next Step$")
		public void read_Accept_licenseAgreement() {
		SignUpPage.click_CheckBox();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		driver.close();

		driver.switchTo().window(tabs.get(0));
	}
	
	@Then ("User should be able to create log in credentiasls for Adportal UAT$")
	public void next_step_LogIn() {
		WebElement nextStep = driver.findElement(By.className("spp-btn"));
		if (nextStep.isEnabled()) 
		{
			nextStep.click();
		} else 
		{
			System.out.println("Please enter required field and accept Licesne agreement");
		}
}
}
	
	*/
	
	
	
	

	