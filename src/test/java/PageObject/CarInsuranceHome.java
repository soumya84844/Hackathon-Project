package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsuranceHome extends BasePage{

	
	public CarInsuranceHome(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='show_text']/h2")
	WebElement CarInsuranceQuote;
	
	
	@FindBy(xpath="//div[@class='dont-know-number']/a")
	WebElement NoCarButton;
	
	
	public void CarInsuranceQuote()
	{
		System.out.println(CarInsuranceQuote.getText());
	}
	
	public void NoCar()
	{
		NoCarButton.click();
	}
	

}
