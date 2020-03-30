package cucmberTestNGTestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import adPortal.extentReporter.TestListener;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(

			features = "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/src/main/java/adportalfeatures", 
			glue = {"adPortalstepdefinitions" },
			plugin = {//"com.cucumber.listener.ExtentCucumberFormatter:AdPortalRegressionTestReport/RegressionSuite_Test_Report.html"
					"com.cucumber.listener.ExtentCucumberFormatter:/Users/p2815492/Syncplicity Folders/Media Solutions (James.A.Harris@charter.com )/Quality Assurance/Automation Testing Repo/Adportal Automation Test Report/RegressionSuite_Test_Report.html"
			},
			
					tags = {"@AdPortalLogInDefault,@SSULogIn,@DashBoardView,@CreateCampaignDefault"
					//  "@DashBoardView",@CreateCampaignUserInPut,
					},
							
						
							monochrome = true

	)

 
		public class RegressionTestRunner extends TestListener  {
		
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
		 




