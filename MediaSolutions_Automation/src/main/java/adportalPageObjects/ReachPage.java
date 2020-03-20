package adportalPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ReachPage {
	WebDriver driver;
		 
		public ReachPage (WebDriver driver) {
			 this.driver = driver;
		 }
		
		
		By button_Next= By.xpath("//div[@class='spp-btn']");
		By button_RaiseAwareness = By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/app-order[1]/div[1]/div[2]/div[1]/div[1]/section[1]/app-goals[1]/app-card-item[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-goals-card[1]/div[2]/button[1]");
		By button_PromoteYourEvent = By.xpath("//button[@class='ap-btn-large d-none d-sm-flex']");
		By reachPage1_NextButton = By.xpath("//span[contains(text(),'Next')]");
		By AddressField = By.xpath("//input[@placeholder='Enter a location']");
		By headerTitle = By.xpath("//div[@class='header large ng-star-inserted']");
		By distanceArrowdropdown = By.xpath("//span[@class='ng-arrow-wrapper']");
		By miles_2 = By.xpath("//div[@class='ng-option ng-option-selected ng-star-inserted ng-option-marked']//span[@class='ng-option-label ng-star-inserted'][contains(text(),'2 miles')]");
		By defaultDistance_50 = By.xpath("//span[contains(text(),'50 miles')]");
		By miles_20 = By.xpath("//span[contains(text(),'20 miles')]");
		By miles_30 = By.xpath("//span[contains(text(),'30 miles')]");
		By miles_40 = By.xpath("//span[contains(text(),'40 miles')]");
		By reachPage2_NextButton = By.xpath("//span[contains(text(),'Next')]");
		By startAiring_CalenderArrow =By.xpath("//div[@id='schedule-date-budget-wrapper']//div[1]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
		By StopAiring_CalenderArrow = By.xpath("//body//div[@id='card-item-wrapper']//div//div//div[2]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
		By budgetAmount = By.xpath("//input[@id='budget']");
		By SchedulePage1_NextButton = By.className("spp-btn");
		
		
		
		}
	

