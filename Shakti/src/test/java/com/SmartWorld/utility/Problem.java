package com.SmartWorld.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Problem {
	static WebDriver driver;
	static WebElement capitalName;
    public static  void getTextOfCapital(String countryName) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebElement capitalName=driver.findElement(By.xpath("//table[@class='two-column td-red'][1]/descendant::tr[contains(text(),'"+countryName+"')]/following-sibling::td"));
    	capitalName=driver.findElement(By.xpath("//td[normalize-space()='"+countryName+"']/following-sibling::td"));
    	String name=capitalName.getText();
    	System.out.println(name);
    }
	public static void main(String[] args) {
	    driver=new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getTextOfCapital("Afghanistan");
	

	}

}
