package adportalPageObjects;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ReachPage {
	WebDriver driver;
		 
		public ReachPage (WebDriver driver) {
			 this.driver = driver;
		 }
		
		
		By reachPage_NextButton= By.xpath("//div[@class='spp-btn']");
		By button_RaiseAwareness = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-order[1]/div[1]/div[2]/div[1]/div[1]/section[1]/app-goals[1]/app-card-item[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-goals-card[1]/div[2]/button[1]");
		By button_PromoteYourEvent = By.xpath("//button[@class='ap-btn-large d-none d-sm-flex']");
		By reachPage1_NextButton = By.xpath("//span[contains(text(),'Next')]");
		By txtBox_AddressField = By.xpath("//input[@placeholder='Enter a location']");
		By headerTitle = By.xpath("//div[@class='header large ng-star-inserted']");
		By distanceArrowdropdown = By.xpath("//span[@class='ng-arrow-wrapper']");
		By miles_2 = By.xpath("//div[@class='ng-option ng-option-selected ng-star-inserted ng-option-marked']//span[@class='ng-option-label ng-star-inserted'][contains(text(),'2 miles')]");
		By defaultDistance_50 = By.xpath("//span[contains(text(),'50 miles')]");
		By miles_20 = By.xpath("//span[contains(text(),'20 miles')]");
		By miles_30 = By.xpath("//span[contains(text(),'30 miles')]");
		By miles_40 = By.xpath("//span[contains(text(),'40 miles')]");
		By reachPage2_NextButton1 = By.xpath("//*[@id=\"card-item-wrapper\"]/div/div[2]/div[2]/div[3]/div/span");
		By reachPage2_NextButton2 = By.xpath("//span[contains(text(),'Next')]");
		By reachPage3_NextButton = /*By.xpath("//*[@id=\"card-item-wrapper\"]/div/div[2]/div[2]/div[3]/div/span");*/By.className("spp-btn");
		By startAiring_CalenderArrow =By.xpath("//div[@id='schedule-date-budget-wrapper']//div[1]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
		By calender_TagName = By.tagName("dp-day-calendar");
		By date_Button = By.tagName("button");
		By StopAiring_CalenderArrow = By.xpath("//body//div[@id='card-item-wrapper']//div//div//div[2]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
		By budgetAmount = By.xpath("//input[@id='budget']");
		By SchedulePage1_NextButton = By.className("spp-btn");
		By review_CamapaignTitle = By.className("header large ng-star-inserted");
		By yourBudget_Amount =By.cssSelector("body.white-background:nth-child(2) div.main app-order.ng-star-inserted:nth-child(2) div.order-comp:nth-child(1) div.main-section div.row-materialize.header-row-all:nth-child(2) div.row-materialize.s9.card-section section.section-container app-schedule-display.ng-star-inserted:nth-child(2) div.ng-animate-disabled div.card-item-position div.tv-commerical-question-card div.card.card-client.ng-star-inserted div.card-content.ng-star-inserted div.review-schedule.container-fluid.p-0.text-left.ng-star-inserted div.row.m-0.mb-4.pb-2 div.col.p-0.pr-3 app-commercial-schedule-overview:nth-child(2) div.ng-star-inserted div.d-flex.your-schedule-section > div.schedule-cost.d-flex.align-items-center");
		
		
		public void click_ReachPageNextButton () {
					driver.findElement(reachPage_NextButton).click();		
		}
		public void select_RaiseAwareness () {
			driver.findElement(button_RaiseAwareness).click();
		
		}		
		public void select_PromoteYourEvent () {
			driver.findElement(button_PromoteYourEvent).click();
		}
		public void click_ReachPage1NextButton () {
				driver.findElement(reachPage1_NextButton).click();
			
		}
		public void enter_Address(String address) {
			
			driver.findElement(txtBox_AddressField).clear();
			driver.findElement(txtBox_AddressField).sendKeys(address);
			try { Thread.sleep(3000);
			  
			  } catch (InterruptedException e) {
			 e.printStackTrace();
			 }
			driver.findElement(txtBox_AddressField).sendKeys(Keys.ARROW_DOWN);
			
		}
		public void UserInPut_Address () {
			driver.findElement(txtBox_AddressField).clear();
			//driver.findElement(txtBox_AddressField).sendKeys(address);
			String EnterAddress;
			EnterAddress = JOptionPane.showInputDialog(null, "Enter your Address");
			driver.findElement(txtBox_AddressField).sendKeys(EnterAddress);
			try { Thread.sleep(1000);
			  
			  } catch (InterruptedException e) {
			 e.printStackTrace();
			 }
			driver.findElement(txtBox_AddressField).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(txtBox_AddressField).sendKeys(Keys.ENTER);


		}
		
		
		public void click_HeaderTtile () {
			driver.findElement(headerTitle).click();
		
		}
		public void click_DropDownAroow () {
			driver.findElement(distanceArrowdropdown).click();
		
		}
		public void enter_Distance () {
			driver.findElement(defaultDistance_50).click();
		}
		 public void clickDistance_JSExecutor() {
			 WebElement defaultDistance = driver.findElement(defaultDistance_50);
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();", defaultDistance);
		 }
		public void UserInPut_Distance() {
			String enterDistance;
			enterDistance = JOptionPane.showInputDialog(null, "Enter your Distance in miles");
			//distance = Integer.parseInt(enterDistance);
			if (enterDistance.equals("2")) {
				driver.findElement(By.xpath(
						"//div[@class='ng-option ng-option-selected ng-star-inserted ng-option-marked']//span[@class='ng-option-label ng-star-inserted'][contains(text(),'2 miles')]")).click();

			} 
			else if (enterDistance.equals("20")) {
				driver.findElement(By.xpath("//span[contains(text(),'20 miles')]")).click();
			}

			else if (enterDistance.equals("30")) {
				driver.findElement(
						By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'30 miles')]")).click();
			} else if (enterDistance.equals("40")) {
				driver.findElement(By.xpath("//span[contains(text(),'40 miles')]")).click();
			}

			if (enterDistance.equals("50")) {
				driver.findElement(By.xpath("//span[contains(text(),'50 miles')]")).click();
			}

			else {
				System.out.println("Please enter valid Distance in miles");
			}

			
		}
		
		public void Select_2Miles () {
			driver.findElement(miles_2).click();
		
		}
		public void Select_50Miles () {
			driver.findElement(defaultDistance_50).click();
		
		}
		public void Select_20Miles () {
			driver.findElement(miles_20).click();
		
		}
		public void Select_30Miles () {
			driver.findElement(miles_30).click();
		
		}
		public void Select_40Miles () {
			driver.findElement(miles_40).click();
		
		}
		public void click_ReachPage2NextButton () {
			System.out.println("clicking on Next Button");
			WebElement reachPage2NextButton = driver.findElement(reachPage2_NextButton2);
			driver.findElement(reachPage2_NextButton2).click();
			if (reachPage2NextButton.isEnabled()) {
				reachPage2NextButton.click();
			} else {

				System.out.println("Next button is not enabled");
			}

			try {
				reachPage2NextButton.click();

			} catch (StaleElementReferenceException e) {
				driver.findElement(reachPage2_NextButton2).click();
			}
		
			//driver.findElement(reachPage2_NextButton2).click();
		}
		public void click_ReachPage3NextButton() {
			System.out.println("clicking on Next Button again");
			WebElement reachPage3NextButton = driver.findElement(reachPage3_NextButton);
			if (reachPage3NextButton.isEnabled()) {
				reachPage3NextButton.click();
			} else {

				System.out.println("Next button is not enabled");
			}

			try {
				reachPage3NextButton.click();

			} catch (StaleElementReferenceException e) {
				driver.findElement(reachPage3_NextButton).click();
			}
		
			//driver.findElement(reachPage3_NextButton).click();
		}
		
		public void click_ReachPage3NextButton_JSExecutor() {
			
			WebElement reachPage3NextButton = driver.findElement(reachPage3_NextButton);
			if (reachPage3NextButton.isEnabled()) {
				reachPage3NextButton.click();
			} else {

				System.out.println("Next button is not enabled");
			}

			try {
				reachPage3NextButton.click();

			} catch (StaleElementReferenceException e) {

				WebElement reachPage3NextBtn = driver.findElement(reachPage3_NextButton);
				 JavascriptExecutor executor = (JavascriptExecutor)driver;
				 executor.executeScript("arguments[0].click();", reachPage3NextBtn);
				//driver.findElement(reachPage3_NextButton).click();
			}
		}
			
		public void click_startCalednderArrow () {
			driver.findElement(startAiring_CalenderArrow).click();
			driver.findElement(calender_TagName).click();
			 
			 List<WebElement> allStartDates = driver.findElements(date_Button);
			 
			  for (WebElement dates : allStartDates) {
			  
			  String date = dates.getText();
			 
			  if (date.equalsIgnoreCase("6")) { 
				  dates.click(); 
				  break;
			  
			  }
			 
			  }
		
		}
		public void click_stopCalenderArrow () {
			driver.findElement(StopAiring_CalenderArrow).click();
			
			List<WebElement> allEndDates = driver.findElements(date_Button);

			for (WebElement dates : allEndDates) {

				String date = dates.getText();

				if (date.equalsIgnoreCase("12")) {
					dates.click();
					break;

				}
		
		}
		}
		public void enter_Budget () {
			driver.findElement(budgetAmount).clear();
			//driver.findElement(budgetAmount).sendKeys(budget);
			int Amount;
			String enterBudgetAmount;
			enterBudgetAmount = JOptionPane.showInputDialog(null, "Enter your budget amount");
			Amount = Integer.parseInt(enterBudgetAmount);
			driver.findElement(budgetAmount).sendKeys(String.valueOf(Amount));
			if (Amount > 10000) {
				JOptionPane.showMessageDialog(null, "Invalid Budget Amount, Budget Should be Between $250 and $10000");
			}

		
		}
		public void click_SchedulePage1NextButton () {
			driver.findElement(SchedulePage1_NextButton).click();
		
		}
		
		public void verify_BudgetAmount () {
			
			//String reviewCamapigntitle = driver.findElement(review_CamapaignTitle).getText();
			//System.out.println("The title of this page is :" + reviewCamapigntitle );
		String budgetValue = 	driver.findElement(yourBudget_Amount).getText();
			System.out.println("your Budget amount is :" + budgetValue);
		}	
			
			
		
}		
		




	

