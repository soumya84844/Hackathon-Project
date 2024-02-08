package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.CarDetails;
import PageObject.CarInsuranceHome;
import PageObject.HomePage;
import PageObject.TravelPlans;
import Utilities.Takescreenshot;

public class TC003_CarInsuranceTest extends TC002_TravelDetailsTest {

	
	@Test(priority=9,groups= {"Master"})
	public void test9() throws InterruptedException
	{
		HomePage home=new HomePage(driver);
		home.CarInsurance_click();
		Thread.sleep(2000);
		CarInsuranceHome car=new CarInsuranceHome(driver);
		car.CarInsuranceQuote();
		car.NoCar();
	}
	
	@Test(priority=10,groups= {"Master"})
	public void test10() throws InterruptedException, IOException
	{
		CarDetails car=new CarDetails(driver);
		car.CitySelection();
		log.info("city selected");
		Takescreenshot ts=new Takescreenshot(driver);
		ts.ScreenShot("City");
		
		car.RtoSelection();
		log.info("Rto selected");
		Thread.sleep(2000);
		car.BrandSelection();
		
		log.info("Brand selection");
		ts.ScreenShot("Brand");
		
		
		
		Thread.sleep(2000);
		car.ModelSelection();
		log.info("Model Selection");
		
		ts.ScreenShot("Model");
		Thread.sleep(2000);
		car.CarFuel();
		log.info("Fuel Type Selection");
		
		ts.ScreenShot("Fuel");
		Thread.sleep(2000);
		car.CarVariantSelection();
		car.CarVariantTypeSelection();
		
		log.info("Car variant selection");
		
		
		ts.ScreenShot("Variant");
		Thread.sleep(2000);
	}
	@Test(priority=11,groups= {"Master"})
	public void test11() throws InterruptedException, IOException
	{
		CarDetails car=new CarDetails(driver);

		car.Name();
		log.info("Name given");
		
		car.Email();
		log.info("Email given");
		
		car.Mobile();
		log.info("phone number  given");
		
		
		Thread.sleep(5000);
		car.ClickPrices();
		Thread.sleep(3000);
		
	    car.EmailError();
		car.PhoneError();
		
		Takescreenshot ts=new Takescreenshot(driver);
		ts.ScreenShot("Email Error");
		
		log.info("Email error screenshot taken");
		
		
		car.logo_press();
		Thread.sleep(2000);
		
	}
}
