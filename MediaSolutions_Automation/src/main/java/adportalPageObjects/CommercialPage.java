package adportalPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommercialPage {
	public CommercialPage (WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
}
