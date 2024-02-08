package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;


import PageObject.HealthInsuranceNew;
import Utilities.Takescreenshot;

public class TC006_HealthInsuranceNewTest extends TC003_CarInsuranceTest {
	
	
	@Test(priority=12,groups= {"Master"})
	public void test12() throws IOException, InterruptedException
	{
		HealthInsuranceNew h=new HealthInsuranceNew(driver);
		h.getHealthInsuranceList();
		log.info("health insurance menu items listed");
		
		Takescreenshot ts=new Takescreenshot(driver);
		ts.ScreenShot("Health");
		Thread.sleep(5000);
	}

}
