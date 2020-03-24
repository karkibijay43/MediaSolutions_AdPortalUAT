package cucumberTestRunner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/src/main/java/adportalfeatures/AdPortal_LogIn_001.feature", 
		glue = {"adPortalstepdefinitions" },
		plugin = { "pretty", "json:target/cucumber-reports/AdPortal_LogIn_001_Report.json",
				//"\"com.cucumber.listener.ExtentCucumberFormatter"},
				monochrome = true
				
		
		)

public class AdPortal_LogIn_001_TestRunner {
	@BeforeClass
    public static void setup() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("cucumber-reports/"+timeStamp.replace(":","_").replace(".","_")+".html");
	}
	 @AfterClass
	 public static void writeExtentReport() {
	 //Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 Reporter.loadXMLConfig(new File( "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/configs/extent-config.xml"));
	 }
	} 
	 

