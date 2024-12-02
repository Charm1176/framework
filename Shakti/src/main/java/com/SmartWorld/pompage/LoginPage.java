package com.SmartWorld.pompage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userNameElement;
	
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordElement;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButtonElement;
	
	
	public LoginPage(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void enteringUsername(String name) {
		userNameElement.sendKeys(name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void enteringPassowrd(String password) {
		passwordElement.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public String fetchTitle() {
		String value=driver.getTitle();
		return value;
	}
	
	public void clickingLoginButton() {
		loginButtonElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
}