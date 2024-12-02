package com.SmartWorld.testClasses;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.SmartWorld.pompage.LoginPage;
import com.SmartWorld.utility.ReadConfig;
import org.apache.log4j.Logger;

public class BaseClass {
	public  static WebDriver driver;
	LoginPage loginPage;
	ReadConfig rf;
	public static Logger logger;

	

	@BeforeSuite
	public void initBrowser() {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("start-maximmized");
		op.addArguments("--incognito");
		op.addArguments("window-size=1400,3648");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	    rf=new ReadConfig();
	    String value=rf.getBaseUrl();
	    logger=Logger.getLogger("Shakti");
		PropertyConfigurator.configure("C:\\Users\\ernik\\eclipse-workspace\\Shakti\\configuration\\Log4j.properties");
		
	   
	   logger.info("opening url");
	    driver.get(value);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@BeforeClass
	public void createObject() {
	
		loginPage=new LoginPage(driver);
		
		rf=new ReadConfig();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
		logger.info("quit the browser");
	}
	
	public String   takesScreenshot() {
		String timeStamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String value="";
		try {
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);	
			 value="C:\\Users\\ernik\\eclipse-workspace\\Shakti\\screenshots\\"+timeStamp+".png";
			File path=new File(value);
			FileHandler.copy(source, path);
			}
			catch(Exception e) { 
				e.printStackTrace();
			}
		return value;
	}

}
