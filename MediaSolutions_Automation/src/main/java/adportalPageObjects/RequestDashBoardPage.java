package adportalPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestDashBoardPage {
	// WebDriver driver;
	public WebDriver driver;

	By button_GetStarted = By.className("spp-btn-large ng-star-inserted");
	By button_Continue = By.xpath(
			"//datatable-row-wrapper[1]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]");
	By continue_Draft = By.xpath(
			"//datatable-row-wrapper[3]//datatable-body-row[1]//div[2]//datatable-body-cell[6]//div[1]//button[1]");

	public RequestDashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void continue_Draft() {
		driver.findElement(continue_Draft).click();
	}

	public void get_Started_Or_ContinueCamapaign() {
		try {
			if (driver.findElement(button_Continue).isDisplayed()) {
				System.out.println("Continuing with the Draft Camapaign");
				driver.findElement(button_Continue).click();

			} else {

				System.out.println("This is you first camapaign creation, You are ready to get started");
				driver.findElement(button_GetStarted).click();
			}
		} catch (NoSuchElementException e) {
			driver.findElement(button_Continue).click();

		}

	}

	public void explicitly_Wait_For_GetStartedButton() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_GetStarted));
		WebElement getStartedButton = driver.findElement(button_GetStarted);
		 getStartedButton.click();
	}

	public void click_GetStarted() {
		driver.findElement(button_GetStarted).click();
	}

	public void explicitly_Wait_For_ContinueButton() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(button_Continue));

	}

	public void click_Continue() {
		driver.findElement(button_Continue).click();
	}

	public void dashBoardPage_Title_verification() {
		String expectedTitle = "SPP - Creative Requests";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You have landed on the Request DashBoard page");
		} else {
			System.out.println("Please revisit LogIn page and enter valid credentials");
		}
	}

	public void request_DashBoard_Verification() {
		driver.navigate().refresh();
		String expectedTitle = "Spectrum Reach Ad Portal";
		String actualTitle = driver.getTitle();
		System.out.println("The Title this page is:" + " " + actualTitle);

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("You have landed on the Request DashBoard Page");
		} else {
			System.out.println("Please revisit LogIn page and enter valid credentials");
		}

	}

}
