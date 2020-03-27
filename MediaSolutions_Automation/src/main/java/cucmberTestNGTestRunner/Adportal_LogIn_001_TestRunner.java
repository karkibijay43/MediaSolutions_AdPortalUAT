package cucmberTestNGTestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import adPortalManagers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(

		features = "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/src/main/java/adportalfeatures/AdPortal_LogIn_001.feature", 
		glue = {
				"adPortalstepdefinitions" }, 
		plugin = {"pretty", "html:target/cucumber-reports",
				"json:target/cucumber-reports/AdPortal_LogIn_001_Report.json",
				//"com.cucumber.listener.ExtentCucumberFormatter"
				}, 
				tags = {"@AdPortalLogInDefault"
		},
				
					monochrome = true

)

public class Adportal_LogIn_001_TestRunner  {

	
	  static TestNGCucumberRunner testNGCucumberRunner;
	  
	  @BeforeClass(alwaysRun = true) 
	  public void setUpClass() {
	  testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	  }
	  
	  @Test(groups = "cucumber", description = "Runs cucmber Features",
	  dataProvider = "features") public void feature(CucumberFeatureWrapper
	  cucumberFeature) {
	  testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature()); }
	  
	
	  @DataProvider public Object[][] features() { return
	  testNGCucumberRunner.provideFeatures(); }
	 

	
	  @AfterClass(alwaysRun = true) public void testDownClass() {
	  testNGCucumberRunner.finish(); }
	
	  }
	 


