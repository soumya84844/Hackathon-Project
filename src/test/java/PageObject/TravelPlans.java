package PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtils;

public class TravelPlans extends BasePage{

	public TravelPlans(WebDriver driver)
	{
		super(driver);
	}
	
	//path of excel file
	String xlfile=System.getProperty("user.dir")+"\\TestData\\hack_excel.xlsx";
	
	//explicit wait
	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	
	@FindBy(xpath="//section[@class='newFilterSection sort']")
	public WebElement SortButton;
	
	@FindBy(xpath="//label[contains(text(),'Premium low')]")
	public WebElement LowToHigh;
	
	
	@FindBy(xpath="//div[@class='quotesCard']//div[@class='quotesCard__planName']/div/p")
	List<WebElement>Plans;
	
	@FindBy(xpath="//span[@class='premiumPlanPrice']")
	List<WebElement>PlanPrice;
	
	
	@FindBy(xpath="//a[contains(text(),'Policybazaar')]")
	public WebElement Title;
	
	@FindBy(xpath="//span[@class='exitIntentPopup__box__closePop']")
	public WebElement popup;
	
	
	public void PopupClose()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",popup);
		//popup.click();
	}
	
	
	//sort button is clicked
	public void Sort()
	{
	    mywait.until(ExpectedConditions.elementToBeClickable(SortButton));
		SortButton.click();
	}
	
	//low to high filter selected
	public void Low()
	{
		LowToHigh.click();
	}
	
	//First 3 lowest plans name and prices captured
	public void Plan() throws IOException, InterruptedException
	{
		//only the first 3 lowest travel plans
		for(int i=0;i<3;i++)
		{
			//writing plan names in excel sheet
			ExcelUtils.setCellData(xlfile,"Sheet1", i+1, 0, Plans.get(i).getText());
			System.out.println(Plans.get(i).getText());
			System.out.println("Price:");
			System.out.println(PlanPrice.get(i).getText());
			//writing prices in excel sheet
			ExcelUtils.setCellData1(xlfile,"Sheet1", i+1, 1, PlanPrice.get(i).getText());
		}
		
		//back to home page
		Title.click();
	}
	
}
