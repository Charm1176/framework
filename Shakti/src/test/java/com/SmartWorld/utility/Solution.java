package com.SmartWorld.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Solution {
	static WebDriver driver;
	static WebElement webElement;
	public static void entersDetail(String locator,String value) {
		//driver.findElement(By.xpath("//label[contains(text(),'"+ locator +"')]")).sendKeys(value);
		driver.findElement(By.xpath("//input[@type='text' and  @name='"+locator+"']")).sendKeys(value);
		
	}
	
	public static void main(String [] args) {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/en/book-a-free-demo");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement button=driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonAccept']"));
		wait.until(ExpectedConditions.visibilityOf(button));
		button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		entersDetail("FullName","champion");
		entersDetail("Contact","14326999");
		//entersDetail("Email","abc@gmail.com");
	}

}
