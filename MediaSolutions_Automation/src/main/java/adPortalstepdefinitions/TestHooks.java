package adPortalstepdefinitions;


import org.openqa.selenium.WebDriver;

import adPortalUtilities.AdPortalScreenShots;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class TestHooks {
	WebDriver driver;
	AdPortalScreenShots adPortalScreenShots;
	
	@Before
	public void beforeScenario(Scenario scenario) {		
		System.out.println("Started execution for the scenario : " + scenario.getName());
	}
	
	@Before("@AdPortalLogInDefault")
	public void AdPortalLogInDefault(Scenario scenario) {		

		System.out.println("=========================================");
		System.out.println("Executing before AdPortalLogInDefault");
		System.out.println("=========================================");
		
	}
	
	@Before("@AdPortalLogInUserInPut")
	public void AdPortalLogInUserInPut(Scenario scenario) {		

		System.out.println("=========================================");
		System.out.println("Executing before AdPortalLogInUserInPut");
		System.out.println("=========================================");
		
	}
	@Before("@SSULogIn")
	public void SSULogIn(Scenario scenario) {		

		System.out.println("=========================================");
		System.out.println("Executing before SSULogIn");
		System.out.println("=========================================");
		
	}

	

	@Before("@CreateCampaignDefault")
	public void CreateCampaignDefault(Scenario scenario) {		

		System.out.println("=========================================");
		System.out.println("Executing before CreateCampaignDefault");
		System.out.println("=========================================");
		
	}
	@Before("@DashBoardView")
	public void DashBoardView(Scenario scenario) {		

		System.out.println("=========================================");
		System.out.println("Executing before DashBoardView");
		System.out.println("=========================================");
		
	}
	@After ()
	public void afterScenario(Scenario scenario) {
		System.out.println("Completed execution for the scenario :" + scenario.getName());
	}
	

	
	  @After ("@AdPortalLogInDefault")
	  public void screenShotTaker (Scenario scenario) {
		  adPortalScreenShots = new AdPortalScreenShots(driver);
		  adPortalScreenShots.takeScreenshot();
	 
	}
}
