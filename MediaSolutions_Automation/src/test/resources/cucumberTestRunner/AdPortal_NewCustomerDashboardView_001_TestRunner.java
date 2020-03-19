package cucumberTestRunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/src/main/java/adportalfeatures/AdPortal_NewCustomerDashboardView_001.feature",
		glue= {"adPortalstepdefinitions"},
		plugin = { "pretty", "json:target/cucumber-reports/AdPortal_NewCustomerDashboardView_001_Report.json" },
		monochrome = true
		
 )

public class AdPortal_NewCustomerDashboardView_001_TestRunner {

}
