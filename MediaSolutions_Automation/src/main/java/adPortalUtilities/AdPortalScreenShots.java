package adPortalUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AdPortalScreenShots {
	private WebDriver driver;
	File source;
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public AdPortalScreenShots(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenShot() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdportalRegressioin_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotLoginTest() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_LogIn_feature/AdPortalLoginTest_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotSSU_SignUp() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_SSU_LogIn_feature/SSU_SignUp"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotNewDashBoardView() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_DashBoardView_feature/NewDashBoardView_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignDefault_RewviewPage() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_CreateCampaign_feature/Review_YourCampaign_Top_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_CreateCampaign_feature/Review_YourCampaign_Bottom_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void takeScreenShotCreateCampaignDefault_RewviewOrderPage() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_CreateCampaign_feature/ReviewYourOrder_Top_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_CreateCampaign_feature/ReviewYourOrder_Bottom_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void takeScreenShotCreateCampaignUserInPut() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_CreateCampaign_feature/CreateCampaignUserInPut_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignDefault_CheckOutPage() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_CreateCampaign_feature/CheckOutPage_Top_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortal_CreateCampaign_feature/CheckOutPage_Bottom_"
							+ timeStamp + ".png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
