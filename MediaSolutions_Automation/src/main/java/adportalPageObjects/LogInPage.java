package adportalPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import adPortalFramework.helper.WaitForWebElement;


public class LogInPage {

	
	
	 WebDriver driver;

	 public By signuplogInLink = By.xpath("//a[@class='login-link']");
	 By txtBox_LogInEmail = By.cssSelector("#email");
	 By txtBox_LogInPassword= By.id("password");
	 By clickLogIn = By.xpath("//input[@class='spp-btn']");
	
	 
	 

	 public LogInPage (WebDriver driver)
	 {
		 this.driver = driver;
	 }
	

	 public    void enter_LogInEmail (String email)
	 {
	driver.findElement(txtBox_LogInEmail).sendKeys(email);
	}

	 public  void enter_LogInPassword (String password) {
	driver.findElement(txtBox_LogInPassword).sendKeys(password);
	
	 }

	 public  void clickLogIn () 
	 {
			driver.findElement(clickLogIn).click();
			
	 }	

	 public void page_Scroll_Down() 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

			String LogInUrl = "https://adportal-uat.brandcdnstage.com/sign-up-1";
			driver.navigate().to(LogInUrl);
			driver.manage().window().maximize();
			js.executeScript("window.scrollBy(0,100)");	
	 }
	 
	/*
	 * public void explicitly_wait() {
	 * WaitForWebElement.waitForElement(signuplogInLink, 20);
	 * 
	 * 
	 * }
	 */
	
	  public void explicitly_Wait_ForLogInLink() 
	  { WebDriverWait wait = new
	  WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(signuplogInLink)); }
	 
		
	
	
	
}
