package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelDetails extends BasePage{
	
	public TravelDetails(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='country']")
	public WebElement SearchBar;
	
	
	@FindBy(xpath="//ul[@class='search-list']/li[1]")
	public WebElement Destination;
	
	
	
	@FindBy(xpath="//img[@src='https://static.pbcdn.in/travel-cdn/images/country/Germany.jpg']")
	public WebElement Germany;
	
	
	@FindBy(xpath="//label[text()='2']")
	public WebElement people;
	
	@FindBy(xpath="//div[text()='Select age of traveller 1']")
	public WebElement traveller1;
	
	@FindBy(xpath="//div[text()='Select age of traveller 2']")
	public WebElement traveller2;
	
	@FindBy(xpath="//label[text()='22 years']")
	public WebElement traveller1Age; 
	
	
	@FindBy(xpath="//label[text()='21 years']")
	public WebElement traveller2Age; 
	
	
	@FindBy(xpath="//label[text()='Start date']//parent::div")
	WebElement StartDateBox;
	
	@FindBy(xpath="//div[@class='MuiPickersDateRangeDay-rangeIntervalPreview']/button[@aria-label='Feb 22, 2024']")
	public WebElement StartDate;
	
	
	
	@FindBy(xpath="//label[text()='End date']//parent::div")
	WebElement EndDateBox;
	
	
	
	@FindBy(xpath="//div[@class='MuiPickersDateRangeDay-rangeIntervalPreview']/button[@aria-label='Feb 28, 2024']")
	public WebElement EndDate;
	
	
	@FindBy(xpath="//label[text()='No']")
	public WebElement Medical;
	
	
	@FindBy(xpath="//input[@id='mobileNumber']")
	public WebElement MobileNumber;
	
	
	@FindBy(xpath="//button[@class='travel_main_cta']")
	public WebElement NextButton;
	
	
	@FindBy(xpath="//label[@class='switch slBtn']//span")
	public WebElement Slider;
	
	
	@FindBy(xpath="//button[contains(text(),'View')]")
	public WebElement Plans;
	
	
	
	//Germany is selected 
	public void Germany_click()
	{
		Germany.click();
	}
	

	//two people selected
	public void PeopleNumber()
	{
		people.click();
	}
	
	//age of traveller1 selected
	public void Traveller1Age()
	{
		traveller1.click();
		traveller1Age.click();
	}
	
	
	//age of traveller2 selected
	public void Traveller2Age()
	{
		traveller2.click();
		traveller2Age.click();
	}
	
	
	//travel start date selection
	public void StartDateSelection()
	{
		StartDateBox.click();
		StartDate.click();
		
	}
	
	
	//travel end date selection
	public void EndDateSelection()
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",EndDateBox);
		js.executeScript("arguments[0].click();",EndDate);
	}
	
	
	//medical conditions selected 
	public void MedicalCondition()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Medical);
	}
	
	//mobile number given and notification deactivated
	public void MobileNumber()
	{
		MobileNumber.sendKeys("7980518221");
		Slider.click();
		Plans.click();
		
	}
	
	
	//clicked on next button
	public void Next() throws InterruptedException
	{
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",NextButton);
			} catch (StaleElementReferenceException e) {
			  // Refresh the page
			  driver.navigate().refresh();

			  // Try to locate the element again
			  JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();",NextButton);
			}        
		
	}
	
}
