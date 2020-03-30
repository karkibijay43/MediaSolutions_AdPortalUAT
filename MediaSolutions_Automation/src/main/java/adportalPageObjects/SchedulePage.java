package adportalPageObjects;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchedulePage {
	//WebDriver driver;
	public WebDriver driver; 
		public SchedulePage (WebDriver driver) {
			 this.driver = driver;
		 }
	By startAiring_CalenderArrow =By.xpath("//div[@id='schedule-date-budget-wrapper']//div[1]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
	By calender_TagName = By.tagName("dp-day-calendar");
	By date_Button = By.tagName("button");
	By StopAiring_CalenderArrow = By.xpath("//body//div[@id='card-item-wrapper']//div//div//div[2]//div[1]//app-date-picker[1]//div[1]//span[1]//i[2]");
	By budgetAmount = By.xpath("//input[@id='budget']");
	By SchedulePage1_NextButton = By.className("spp-btn");
	By review_CamapaignTitle = By.className("header large ng-star-inserted");
	By yourBudget_Amount =By.cssSelector("body.white-background:nth-child(2) div.main app-order.ng-star-inserted:nth-child(2) div.order-comp:nth-child(1) div.main-section div.row-materialize.header-row-all:nth-child(2) div.row-materialize.s9.card-section section.section-container app-schedule-display.ng-star-inserted:nth-child(2) div.ng-animate-disabled div.card-item-position div.tv-commerical-question-card div.card.card-client.ng-star-inserted div.card-content.ng-star-inserted div.review-schedule.container-fluid.p-0.text-left.ng-star-inserted div.row.m-0.mb-4.pb-2 div.col.p-0.pr-3 app-commercial-schedule-overview:nth-child(2) div.ng-star-inserted div.d-flex.your-schedule-section > div.schedule-cost.d-flex.align-items-center");
	By reviewPage_NextButton = By.xpath("//span[contains(text(),'Next')]");
	
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
	public void enter_Budget (String budget ) {
		driver.findElement(budgetAmount).clear();
		driver.findElement(budgetAmount).sendKeys(budget);
		
		
	}
	public void enter_Budget_UserInput () {
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
		public void explicitly_Wait_For_ReviewPageNextButton () {
			 WebDriverWait wait = new WebDriverWait(driver, 30);
			  wait.until(ExpectedConditions.presenceOfElementLocated(reviewPage_NextButton)); 
		}
		
	public void click_ReviewPage_NextButton () {
		driver.findElement(reviewPage_NextButton).click();
	
	
	}
	
}
