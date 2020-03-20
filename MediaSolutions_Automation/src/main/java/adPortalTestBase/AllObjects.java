package adPortalTestBase;

import adportalPageObjects.LogInPage;
import adportalPageObjects.CommercialPage;
import adportalPageObjects.ReachPage;
import adportalPageObjects.SchedulePage;
import adportalPageObjects.SignUpPage;


public interface AllObjects {
	public LogInPage loginPage = new LogInPage(TestBase.driver);
	static SignUpPage signupPage = new SignUpPage(TestBase.driver);
	
	static ReachPage reachPage = new ReachPage (TestBase.driver);
	static SchedulePage schedulePage  = new SchedulePage(TestBase.driver);
	static CommercialPage commercialPage  = new CommercialPage (TestBase.driver);
}
