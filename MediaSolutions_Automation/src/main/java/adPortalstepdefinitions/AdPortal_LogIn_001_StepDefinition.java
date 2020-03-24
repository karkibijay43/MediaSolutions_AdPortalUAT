package adPortalstepdefinitions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import adPortalManagers.PageObjectManager;
import adPortalManagers.WebDriverManager;
import adportalPageObjects.LogInPage;
import adportalPageObjects.RequestDashBoardPage;
import adportalPageObjects.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import cucumber.api.java.en.Then;

public class AdPortal_LogIn_001_StepDefinition {
	WebDriver driver;
	ConfigFileReader configFileReader;
	JavascriptExecutor executor;
	LogInPage loginPage;
	SignUpPage signUpPage;
	RequestDashBoardPage requestDashBoardPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	
@Test
	@Given("^User is on AdPortal UAT SignUp Page and clicks Log in link$")
	public void user_is_on_AdPortal_UAT_SignUp_page() {

		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		configFileReader = new ConfigFileReader();
		pageObjectManager = new PageObjectManager(driver);
		configFileReader.getApplicationUrl();
		signUpPage = pageObjectManager.getSignUpPage();
		signUpPage.navigateTo_SignUpPage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		WebDriverWait logInLink = new WebDriverWait(driver, 30);
		logInLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='login-link']")));
		WebElement LogInLink = driver.findElement(By.xpath("//a[@class='login-link']"));
		LogInLink.click();

	}
@Test
	@When("^User enters username and password and clicks log in$")
	public void enter_UserName_and_Password() {
		LogInPage loginPage = new LogInPage(driver);
		loginPage.enter_LogInEmail("MSolutionsTestEmail@charter.com");
		loginPage.enter_LogInPassword("testpwd@MS1");
		loginPage.clickLogIn();
	}
@Test
	@Then("^User lands on request dashboard page$")

	public void requestDashboard_verification() {
		RequestDashBoardPage requestDashBoardPage = new RequestDashBoardPage(driver);
		requestDashBoardPage.dashBoardPage_Title_verification();
		WebDriverWait ContinueButton = new WebDriverWait(driver, 30);
		ContinueButton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]")));
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(src, new File("/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/LogInScreenShots1.png"));
			}

		catch (IOException e) {
			System.out.println(e.getMessage());

			 	
			 }
		driver.close();
	}

	
		
	

}
