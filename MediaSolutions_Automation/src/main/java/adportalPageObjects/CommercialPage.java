package adportalPageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommercialPage {
	WebDriver driver;

	public CommercialPage(WebDriver driver) {
		this.driver = driver;
	}

	By campaignName_AlertBox = By.xpath("//input[@placeholder='My Campaign Name']");
	By click_Next_Alert = By.id("submit");
	By commercialPage_NextButton = By.xpath("//button[contains(text(),'Next')]");
	By txtBox_Things_To_KnowAbout1 = By.id("brandInfo0");
	By txtBox_Things_To_KnowAbout2 = By.id("brandInfo1");
	By txtBox_Things_To_KnowAbout3 = By.id("brandInfo2");
	By txtBox_commercial_TagLine = By.id("commercialTagline");
	By commercial_Upload_Box = By.xpath("//body/app-root/div[@id='tv-main']/app-order/div/div/div/div/section/app-creative-business-description/app-card-item[@id='creative-upload-logo']/div[@id='card-item-wrapper']/div/div/div/div/div/div/div/div/app-upload-creatives/div/div/label/div[1]");			
	//By.id("//span[contains(text(),'Drop file here or click to upload')]");
	
	public void explicitly_Wait_For_campaignNname_AlertBox() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(campaignName_AlertBox));
	}
	public void click_commercialPage_NextButton() {
	driver.findElement(commercialPage_NextButton).click();
	}
	public void enter_CampaignName_Or_Continue_With_Commercial(String campaignName) {
	try {
	if (driver.findElement(campaignName_AlertBox).isDisplayed()) {  
			  driver.findElement(campaignName_AlertBox).sendKeys(campaignName);
			  driver.findElement(campaignName_AlertBox).sendKeys(campaignName);	
			 // driver.findElement(campaignName_AlertBox).click();
			  driver.findElement(click_Next_Alert).click();
			  
	}
		  else
		  {
		  
		  System.out.println("You have already Named your campaign continuing with uploading the commercial");
	  }
	}
	catch (NoSuchElementException e) {
		driver.findElement(commercialPage_NextButton).click();
	
	  }
	
	}

	public void enter_Things_To_KnowAbout1(String text1) {
		driver.findElement(txtBox_Things_To_KnowAbout1).sendKeys(text1);
		}
	public void enter_Things_To_KnowAbout2(String text2) {
		driver.findElement(txtBox_Things_To_KnowAbout2).sendKeys(text2);
		}
	public void enter_Things_To_KnowAbout3(String text3) {
		driver.findElement(txtBox_Things_To_KnowAbout3).sendKeys(text3);
		}
	public void enter_Commercial_TagLine(String text4) {
		driver.findElement(txtBox_commercial_TagLine).sendKeys(text4);
		}
	public void click_commercial_UploadBox() throws AWTException, InterruptedException {
		WebElement uploadBox = driver.findElement(commercial_Upload_Box);
		uploadBox.click();
		
		  Robot robot;
		 robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN);
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN); 
		  robot.setAutoDelay(1000);
		   
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN); 
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN); 
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_RIGHT);
		  robot.keyRelease(KeyEvent.VK_RIGHT);
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN); 
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_RIGHT);
		  robot.keyRelease(KeyEvent.VK_RIGHT);
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_DOWN);
		  robot.keyRelease(KeyEvent.VK_DOWN); 
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(commercial_Upload_Box).sendKeys("/Users/p2815492/Desktop/AdPortalUAT_Automation_Ad_samples/Volcano_HD_30.mp4");
		  //StringSelection ss = new StringSelection("/Users/p2815492/Desktop/AdPortalUAT_Automation_Ad_samples/Volcano_HD_30.mp4");
	       // Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //copy the above string to clip board     
	        
	        
	}
	
}
