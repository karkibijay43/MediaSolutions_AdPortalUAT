package adPortalUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AdPortalScreenShots {
	private WebDriver driver;
	File source;
	
	public AdPortalScreenShots(WebDriver driver) {
		 this.driver = driver; 
		 }

	public void takeScreenshot() {

	    try {
	        source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(source, new File ("/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/target/ScreenShots/CreateCampaignScreenshot.png"));
	        System.out.println("Screenshot Taken!!!!");

	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	}

	}

