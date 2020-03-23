package adportalPageObjects;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigFileReader;



public class LogInPage {

	
	ConfigFileReader configFileReader;
	  WebDriver driver;
	  JavascriptExecutor executor ;

	 
	 By txtBox_LogInEmail = By.cssSelector("#email");
	 By txtBox_LogInPassword= By.id("password");
	 By clickLogIn = By.xpath("//input[@class='spp-btn']");
	
	 
	 

	 public LogInPage (WebDriver driver)
	 {this.executor = (JavascriptExecutor) this.driver;
		 this.driver = driver;
		 configFileReader= new ConfigFileReader();
	 }
	
	 public void enter_LogInEmail (String email) {
	driver.findElement(txtBox_LogInEmail).clear();
	driver.findElement(txtBox_LogInEmail).sendKeys(email);
	}
	 public  void userInPut_LogInEmail (){
		 driver.findElement(txtBox_LogInEmail).clear();
		 String enterEmail; 
		 enterEmail = JOptionPane.showInputDialog(null,"Enter your Email Address"); 
		 driver.findElement(txtBox_LogInEmail).sendKeys(enterEmail);
		 //driver.findElement(txtBox_LogInEmail).sendKeys(email);
	}
	 

	 public  void enter_LogInPassword (String password) {
		 driver.findElement(txtBox_LogInPassword).clear();
		 driver.findElement(txtBox_LogInPassword).sendKeys(password);
		
	 }
	 public void userInPut_LogInPassword() {
		 driver.findElement(txtBox_LogInPassword).clear();
		 String enterPassword; 
		 enterPassword = JOptionPane.showInputDialog(null, "Enter your Password"); 
				  driver.findElement(txtBox_LogInPassword).sendKeys(enterPassword);
	 }
	 

	 public  void clickLogIn () 
	 {
			driver.findElement(clickLogIn).click();
			
	 }	

	
	  
	  

	public void page_Scroll_Down() {
		
		executor.executeScript("window.scrollBy(0,100)");	
	}
	 
	 
	
	

}
