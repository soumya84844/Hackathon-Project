package PageObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class CarDetails extends BasePage{
	
	Properties p;
	public CarDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	String xlfile=System.getProperty("user.dir")+"\\TestData\\hack_excel.xlsx";
	
	
	@FindBy(xpath="//ul[@class='slideInRight animated5 rto-list']/li[1]/span[1]")
	public WebElement City;
	
	
	@FindBy(xpath="//div[@id='section1']//span[contains(text(),'KA43')]")
	public WebElement RTO;
	
	
	@FindBy(xpath="//ul[@class='slideInRight slideInRightanimated manufact-listcb']//li/span[@class='maruti']")
	public WebElement CarBrand;
	
	
	@FindBy(xpath="//div[@id='modelScroll']/li[3]")
	public WebElement CarModel;
	
	
	@FindBy(xpath="//span[@id='Petrol']")
	public WebElement FuelType;
	
	
	@FindBy(xpath="//ul[@class='varient_tab']/li[text()='Automatic']")
	public WebElement CarVariant;
	
	
	@FindBy(xpath="//div[@id='variantScroll']/li/span/b[1]")
	public WebElement CarVariantType;
	
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement Name;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@id='mobileNo']")
	public WebElement Phone;
	
	@FindBy(xpath="//div[@class='textinput']/div[contains(text(),'e-mail')][2]")
	public WebElement EmailErrorMessage;
	
	@FindBy(xpath="//div[@class='textinput']/div[contains(text(),'mobile')][2]")
	public WebElement PhoneErrorMessage;
	
	
	@FindBy(xpath="//button[@id='btnLeadDetails']")
	public WebElement Prices;
	
	
	@FindBy(xpath="//a[@class='pb-logo']")
	public WebElement logo;
	
	
	//City is selected
	public void CitySelection()
	{
		City.click();
	}
	
	//Rto number selected
	public void RtoSelection()
	{
		RTO.click();
	}
	
	//Car Brand selected
	public void BrandSelection()
	{
		CarBrand.click();
	}
	
	//Car Model selected
	public void ModelSelection()
	{
		CarModel.click();
	}
	
	//Fuel Type selected
	public void CarFuel()
	{
		FuelType.click();
	}
	
	//Variant Selection
	public void CarVariantSelection()
	{
		CarVariant.click();
	}
	
	//VariantType selection
	public void CarVariantTypeSelection()
	{
		CarVariantType.click();
	}
	
	//Name passed in input box
	public void Name() throws IOException
	{
		p=new Properties();
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		p.load(file);
		Name.sendKeys(p.getProperty("name"));
	}
	
	//Email passed to input box
	public void Email() throws IOException
	{
		
		Email.sendKeys(ExcelUtils.getCellData(xlfile, "Sheet2", 1, 0));
	}
	
	//Mobile number given
	public void Mobile() throws IOException
	{
		p=new Properties();
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		
		p.load(file);
		Phone.sendKeys(p.getProperty("phone"));
		

	}
	
	//Email error captured
	public void EmailError() throws IOException
	{
		//printed in console
		System.out.println(EmailErrorMessage.getText());
		
		//Email error written in excel
		ExcelUtils.setCellData1(xlfile,"Sheet2", 1, 1, EmailErrorMessage.getText());
	}
	
	//phone error captured
	public void PhoneError()
	{
		System.out.println( PhoneErrorMessage.getText());
	}
	
	public void ClickPrices()
	{


		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Prices);
	}
	
	
	//Back to home page
	public void logo_press()
	{
		logo.click();
	}
}
