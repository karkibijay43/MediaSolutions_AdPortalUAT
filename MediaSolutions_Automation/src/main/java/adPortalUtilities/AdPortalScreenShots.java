package adPortalUtilities;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AdPortalScreenShots {
	private WebDriver driver;
	File source;

	public AdPortalScreenShots(WebDriver driver) {
		this.driver = driver;
	}

	
	  public void takeScreenShot() {
	  
	  try { source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(source, new File(
			  "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdportalRegressioin.png"
	  )); System.out.println("Screenshot Taken!!!!");
	  
	  } catch (IOException e) { e.printStackTrace(); } }
	 
	/*
	 * public void takeScreenShot(String test) {
	 * 
	 * try { source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(source, new File(
	 * "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/"
	 * +test+".png")); System.out.println("Screenshot Taken!!!!");
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } }
	 */
	
	public void takeScreenShotLoginTest() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/AdPortalLoginTest.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotSSU_SignUp() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/SSU_SignUp.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotNewDashBoardView() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/NewDashBoardView.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignDefault_RewviewPage() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot//DefaultCampaign_Top.png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/DefaultCampaign_Bottom.png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

		
	}
	
	public void takeScreenShotCreateCampaignDefault_RewviewOrderPage() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot//ReviewYourOrder_Top.png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/ReviewYourOrder_Bottom.png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

		
	}

	public void takeScreenShotCreateCampaignUserInPut() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/CreateCampaignUserInPut.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void takeScreenShotCreateCampaignDefault_CheckOutPage() {
		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot//CheckOutPage_Bottom.png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					 "/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Atuomation Test Screenshot/CheckOutPage_Bottom.png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

}
