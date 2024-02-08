package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageObject.BasePage;

public class Takescreenshot extends BasePage {
	
public Takescreenshot(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Taking screenshot of full webpage
	public String ScreenShot(String path) throws IOException {
		String p = System.getProperty("user.dir")+"\\Screenshots\\";
		p+=path+".png";
		//creating a object of TakeScreenshot interface
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(p);
		//copying the src file to trg file
		FileUtils.copyFile(src, trg);
		return p;
	}
}
