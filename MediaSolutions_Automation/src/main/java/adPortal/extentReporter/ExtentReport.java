package adPortal.extentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

public class ExtentReport {
	 public static WebDriver Driver;

	    public ExtentReports extent;

	    public static ExtentTest scenarioDef;

	    public static ExtentTest features;

	    public static String reportLocation = "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/src/main/java/testReports/ReportsOutput";

	    String fileName = reportLocation + "extentreport.html";


	    public ExtentReport() {
	        //First is to create Extent Reports
	        extent = new ExtentReports();

	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle("Test report for Selenium Basic");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("Test report");

	        extent.attachReporter(htmlReporter);

	    }

	    public void ExtentReportScreenshot() throws IOException {

	        var scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
	        Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
	        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
	    }


	    public void FlushReport(){
	        extent.flush();
	    }


}
