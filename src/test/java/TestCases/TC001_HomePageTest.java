package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.HomePage;
import Utilities.Takescreenshot;

public class TC001_HomePageTest extends BaseClass{

	
	@Test(priority=1,groups= {"Master"})
	public void test1() throws InterruptedException, IOException
	{
		HomePage home=new HomePage(driver);
		home.TravelInsurance_click();
		Thread.sleep(5000);
		log.info("Travelinsurance clicked");
		Takescreenshot ts=new Takescreenshot(driver);
		ts.ScreenShot("TravelInsurance");
	}
}
