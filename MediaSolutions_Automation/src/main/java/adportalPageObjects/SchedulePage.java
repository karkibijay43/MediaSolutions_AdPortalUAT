package adportalPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage {
	public SchedulePage (WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
}
