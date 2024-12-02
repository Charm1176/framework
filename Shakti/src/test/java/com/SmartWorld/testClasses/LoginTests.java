package com.SmartWorld.testClasses;






import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseClass  {

	
	public  WebDriver driver;
    
	
	
	@Test(priority=1)
	public void enteringDetails() {
		logger.info("entering details");
		String username=rf.getUsername();
		String password=rf.getPassword();
		loginPage.enteringUsername(username);
		loginPage.enteringPassowrd(password);
		
		
	
	}
	
	
	@Test(priority=2)
	public void loginButtonClick()  {
		logger.info("clicking on the login button");
		loginPage.clickingLoginButton();
	   
	
	} 
	
	@Test(priority=3) 
	public void screenshot() {
		
		/*
		try {
			TakesScreenshot  ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);	
		File path=new File("C:\\Users\\ernik\\eclipse-workspace\\Shakti\\screenshots\\"+timeStamp+".png");
		FileHandler.copy(source, path);
		}
		catch(Exception e) { 
			e.printStackTrace();
		} */
		
		logger.info("asserting the title");
	
	Assert.assertEquals(loginPage.fetchTitle(),"Orangehrm");
		
	}
}


