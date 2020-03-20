package adportalPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class SignUpPage {
	

 public  WebDriver driver;

	 By txtBox_FirstName = By.id("firstName");
	 By txtBox_LastName = By.id("lastName");
	 By txtBox_BusinessName = By.xpath("//input[@id='businessName']");
	 By txtBox_ZipCode = By.xpath("//*[@id=\"zipCode\"]");
	 By txtBox_PhoneNumber = By.xpath("//*[@id=\"businessPhone\"]");
	 By txtBox_Email = By.id("email");
	 By txtBox_confirmEmail = By.id("confirm-email");
	 By txtBox_Password = By.id("password");
	 By txtBox_ConfirmPassword = By.id("confirm-password");
	 By WebElement_checkBox = By.id("terms-condition_span");
	 By WebElement_nextStep = By.className("spp-btn");
	  By signuplogInLink = By.xpath("//a[@class='login-link']");

	


	

	
	
	 public SignUpPage (WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void  enter_FirstName (String firstname) {
			driver.findElement(txtBox_FirstName).sendKeys(firstname);
		}
		
		public  void enter_LastName (String lastname) {
			driver.findElement(txtBox_LastName).sendKeys(lastname);
		}
		
		public  void enter_BusinessName(String businessName) {
			driver.findElement(txtBox_BusinessName).sendKeys(businessName);
		}
		
		public   void enter_ZipCode(String zipCode) {
			driver.findElement(txtBox_ZipCode).sendKeys(String.valueOf(zipCode));
		}
		public   void enter_PhoneNumber (String phoneNumber) {
			driver.findElement(txtBox_PhoneNumber).sendKeys(phoneNumber);
		}
		public    void enter_Email (String email) {
			driver.findElement(txtBox_Email).sendKeys(email);
			}
		public  void enter_ConfirmEmail (String confirmEmail) {
			driver.findElement(txtBox_confirmEmail).sendKeys(confirmEmail);
			}
		
		public  void enter_Password (String password) {
			driver.findElement(txtBox_Password).sendKeys(password);
		}
		
		public  void eneter_ConfirmPassword (String confirmpassword) {
			driver.findElement(txtBox_ConfirmPassword).sendKeys(confirmpassword);
		}
		public  void click_CheckBox () {
			driver.findElement(WebElement_checkBox).click();
		}
		
      	public void click_nextStep() {
			
			System.out.println("clicking on Next Step button");
			WebElement nextStep = driver.findElement(WebElement_nextStep);
			if(nextStep.isDisplayed()||nextStep.isEnabled())
				nextStep.click();
			else System.out.println("Element not found");	
		}
	 
      	 public  void click_SignuplogInLink() {
			driver.findElement(signuplogInLink).click();
		}
      	
      	
} 

	 
	 
	 
	 
	
		
		
		
		
		/*@FindBy(how = How.ID, using = "firstName")
		public static WebElement txtBox_FirstName;
		
		@FindBy(how = How.ID, using = "lastName") 
		public static WebElement txtBox_LastName;
		
		@FindBy(how = How.XPATH, using = "#[@id=\\\"businessName\\\"]") 
		public static  WebElement txtBox_BusinessName;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\\\"zipCode\\\"]") 
		public static WebElement txtBox_ZipCode;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\\\"businessPhone\\\"]") 
		public static WebElement txtBox_PhoneNumber;
		
		@FindBy(how = How.ID, using = "email") 
		public static WebElement txtBox_Email;
		
		@FindAll(@FindBy(how = How.ID, using = "confirm-email"))
		public static WebElement txtBox_confirmEmail;	
		
		@FindBy(how = How.ID, using = "password") 
		public static WebElement txtBox_Password;
		
		@FindBy(how = How.ID, using = "confirm-password") 
		public static WebElement txtBox_ConfirmPassword;
		
		@FindBy(how = How.CLASS_NAME, using = "is-term-accepted-label") 
		public static WebElement checkBox;
		
		@FindBy(how = How.CLASS_NAME, using = "spp-btn") 
		private static WebElement nextStep;*/
		
		
		

		
		
		
		

	