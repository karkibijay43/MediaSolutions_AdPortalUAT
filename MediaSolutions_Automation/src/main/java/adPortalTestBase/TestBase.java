package adPortalTestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class TestBase {
public  static WebDriver driver;


	static String driverPath = "/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver"; 
	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String SignUpURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(SignUpURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(SignUpURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching chrome as browser of choice..");
			driver = initChromeDriver(SignUpURL);
		}
	}

	private static WebDriver initChromeDriver(String SignUpURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(SignUpURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String SignUpURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(SignUpURL);
		return driver;
	}

	@Parameters({ "browserType", "SignUpURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String SignUpURL) {
		try {
			setDriver(browserType, SignUpURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

	
	/*
	 * public WebDriver selectBrowser(String browser) { if
	 * (System.getProperty("os.name").toLowerCase().contains(OperatingSystem.WINDOW.
	 * name().toLowerCase())) { if
	 * (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
	 * System.setProperty("webdriver.chrome.driver", System.getProperty
	 * ("/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver"
	 * )); driver = new ChromeDriver(); driver.manage().window().maximize(); } else
	 * if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
	 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
	 * "/src/test/resources/drivers/geckodriver.exe"); driver = new FirefoxDriver();
	 * } } else if
	 * (System.getProperty("os.name").toLowerCase().contains(OperatingSystem.MAC.
	 * name().toLowerCase())) { if
	 * (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
	 * System.setProperty("webdriver.chrome.driver", System.getProperty
	 * ("/Users/p2815492/git/MediaSolutionsRepo/MediaSolutions_Automation/chromedriver"
	 * )); driver = new ChromeDriver(); } else if
	 * (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
	 * System.setProperty("webdriver.firefox.marionette",
	 * System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
	 * driver = new FirefoxDriver(); } } return driver; }
	 */

