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

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/AdportalRegressioin.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotLoginTest() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/AdPortalLoginTest.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotSSU_SignUp() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/SSU_SignUp.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotNewDashBoardView() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/NewDashBoardView.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotCreateCampaignDefault() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/DefaultCampaignTop.png"));
			System.out.println("Screenshot Taken for the top section of the page!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/DefaultCampaignBottom.png"));
			System.out.println("Screenshot Taken for Bottom section of the page!!!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Shutterbug.shootPage(driver,
		// ScrollStrategy.WHOLE_PAGE,true).save("/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/ShutterBugCampaignDefault.png");

		/*
		 * Screenshot screenshot; screenshot = new
		 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).
		 * takeScreenshot(driver);
		 * 
		 * try { ImageIO.write(screenshot.getImage(), "jpg", new File(
		 * "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/AshotCampaignDefault.png"
		 * )); } catch (IOException e1) {
		 * System.out.println("whole Page SscreenShot taken"); e1.printStackTrace(); }
		 */
	}

	public void takeScreenShotCreateCampaignUserInPut() {

		try {
			source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(
					"/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/CreateCampaignUserInPut.png"));
			System.out.println("Screenshot Taken!!!!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
