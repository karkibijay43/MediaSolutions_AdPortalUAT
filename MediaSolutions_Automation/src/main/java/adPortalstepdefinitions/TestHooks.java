package adPortalstepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestHooks {
	WebDriver driver;
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
	public void AfterScenario(Scenario scenario) {
		System.out.println("Completed execution for the scenario :" + scenario.getName());
	}
	
	
	/*
	 * @AfterStep () public void getscreenshot(WebDriver driver) throws Exception {
	 * File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); File
	 * dest = new File(("user.dir")+"screenshot" + ".png"); FileUtils.copyFile(scr,
	 * dest); }
	 */
	}
