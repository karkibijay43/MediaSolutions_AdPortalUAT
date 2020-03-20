package adPortalFramework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWebElement {

	

		//Logger logger = LoggerHelper.getLogger(WaitHelper.class);
		
		public  WebDriver driver;
		
		public WaitForWebElement (WebDriver driver)
		{
			this.driver = driver;
		}
		
		
		 
		
		public void waitForElement(WebElement element,long timeOutInSeconds){
			//logger.info("waiting for element visibilityOf..");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			//logger.info("element is visible..");
		
		 }
}
