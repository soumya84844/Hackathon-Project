package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObject.TravelDetails;
import PageObject.TravelPlans;
import Utilities.Takescreenshot;

public class TC002_TravelDetailsTest extends TC001_HomePageTest{

	@Test(priority=2,groups={"Master"})
	public void test2() throws InterruptedException, IOException
	{
		TravelDetails travel=new TravelDetails(driver);

		travel.Germany_click();
		
		log.info("Germany is selected");
		
		Takescreenshot ts=new Takescreenshot(driver);
		ts.ScreenShot("Destination");
		
		
		Thread.sleep(2000);
	}
	
	@Test(priority=3,groups= {"Master"})
	public void test3() throws InterruptedException
	{
		TravelDetails travel=new TravelDetails(driver);
		log.info("Continue button is clicked");
		travel.Next();
	}
	
	@Test(priority=4,groups= {"Master"})
	public void test4() throws InterruptedException, IOException
	{
		TravelDetails travel=new TravelDetails(driver);
		travel.StartDateSelection();
		log.info("Start Date selected");
		Thread.sleep(2000);
		travel.EndDateSelection();
		log.info("End Date selected");
		Thread.sleep(2000);
		Takescreenshot ts=new Takescreenshot(driver);
		ts.ScreenShot("Date");
		travel.Next();
	}
	
	
	@Test(priority=5,groups={"Master"})
	public void test5() throws InterruptedException, IOException
	{
		TravelDetails travel=new TravelDetails(driver);
		travel.PeopleNumber();
		log.info("two people selected");
		travel.Traveller1Age();
		log.info("Traveller1 age selected");
		travel.Traveller2Age();
		log.info("Traveller2 age selected");
		travel.Next();
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority=6,groups= {"Master"})
	public void test6() throws InterruptedException
	{
		TravelDetails travel=new TravelDetails(driver);
		travel.MedicalCondition();
		log.info("MedicalConditions selected");
//		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(20));
//		mywait.until(ExpectedConditions.elementToBeClickable(travel.NextButton));
		travel.Next();
	}
	
	@Test(priority=7,groups= {"Master"})
	public void test7() throws InterruptedException
	{
		TravelDetails travel=new TravelDetails(driver);
		travel.MobileNumber();
		log.info("MobileNumber given");
		travel.Next();
		log.info("continue button is clicked");
	}
	
	
	@Test(priority=8,groups= {"Master"})
	public void test8() throws InterruptedException, IOException
	{
		TravelPlans p=new TravelPlans(driver);
		try {
			p.Sort();
			log.info("sorted low to high");
			p.Low();
			Thread.sleep(4000);
			Takescreenshot ts=new Takescreenshot(driver);
			ts.ScreenShot("Sorting");
			p.Plan();
			
			log.info("Top 3 lowest travel plans");
			Thread.sleep(2000);
			
			ts.ScreenShot("Plans");
		}
		catch(Exception e)
		{
			p.Sort();
			p.Low();
			Thread.sleep(4000);
			p.Plan();
			Thread.sleep(2000);
		}
		
			
	}
	
	
	
}
