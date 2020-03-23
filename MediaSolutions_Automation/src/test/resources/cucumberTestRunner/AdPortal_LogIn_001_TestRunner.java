package cucumberTestRunner;

import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import adPortalManagers.FileReaderManager;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/src/main/java/adportalfeatures/AdPortal_LogIn_001.feature", 
		glue = {"adPortalstepdefinitions" },
		plugin = { "pretty", "json:target/cucumber-reports/AdPortal_LogIn_001_Report.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				monochrome = true
				
		
		)

public class AdPortal_LogIn_001_TestRunner {
	
	  @AfterClass public static void writeExtentReport() {
	  Reporter.loadXMLConfig(new
	  File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath())
	  ); }
	 
}
