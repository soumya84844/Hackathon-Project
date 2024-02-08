package PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtils;



public class HealthInsuranceNew extends BasePage{

	public HealthInsuranceNew(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    String xl=System.getProperty("user.dir")+"\\TestData\\hack_excel.xlsx";
	@FindBy(xpath = "//li[@class=\"ruby-menu-mega shade mr\"]/child::a")
	private WebElement insuranceDropDown;
	
	
	@FindBy(xpath = "//a[@class='headlink' and contains(text(),'Health Insurance')]/parent::h3/following-sibling::ul/li/a/span")
	private List<WebElement> healthInsuranceList;
	
	public void getHealthInsuranceList() throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(insuranceDropDown).perform();

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < healthInsuranceList.size(); i++) {
			String msg = healthInsuranceList.get(i).getText();
            ExcelUtils.setCellData(xl,"Sheet3", i+1, 0, msg);
			System.out.println(msg);
			
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	

}
