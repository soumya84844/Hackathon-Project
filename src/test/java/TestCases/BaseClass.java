package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.Takescreenshot;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger log;
	public Properties p;
	
	@BeforeTest(groups= {"Master"})
	@Parameters({"browser","os"})
	public void Setup(String br,String os) throws IOException
	{
		log=LogManager.getLogger(this.getClass());
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		ChromeOptions chromeoption=new ChromeOptions();
		//chromeoption.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		chromeoption.addArguments("--disable-notifications");
		EdgeOptions edgeoption=new EdgeOptions();
		edgeoption.addArguments("--disable-notifications");
		//Implementing selenium grid 
	    //If execution env is remote then run with selenium grid in different os
	    if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			return;
		}
		//browser
		switch(br.toLowerCase())
		{
		case "chrome" : capabilities.setBrowserName("chrome"); break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
		default: System.out.println("No matching browser.."); return;
		}
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	    }
	 //If execution_env is local then run in local system
	else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		//launching browser based on condition - locally
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(chromeoption); break;
		case "edge": driver=new EdgeDriver(edgeoption); break;
		default: System.out.println("No matching browser..");
					return;
		}
	}
		
		driver.get(p.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		log.info("Home page opened");
		Takescreenshot ts=new Takescreenshot(driver);
		ts.ScreenShot("HomePage");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	@AfterTest(groups= {"Master"})
	public void TearDown()
	{
		log.info("Page closed");
		driver.quit();
	}
}
