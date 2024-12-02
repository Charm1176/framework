package com.SmartWorld.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic {
	public static void main(String [] args) {
	

	
		        // Set up ChromeDriver (path to your ChromeDriver executable)
		    

		        WebDriver driver = new ChromeDriver();

		        // Navigate to the page with the table
		        driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
                 //(//*[@class='two-column td-red']//tr//th[text()='Country'])[1]
		        // Define the country name dynamically
		        String countryName = "France";
		        String xpath = "//table[@id='countries']//tr[td[text()='" + countryName + "']]/td[2]";

		        // Locate the capital cell using the dynamic XPath
		        WebElement capitalElement = driver.findElement(By.xpath(xpath));
		        String capital = capitalElement.getText();

		        System.out.println("The capital of " + countryName + " is " + capital);

		        // Close the browser
		        driver.quit();
		    }
		}

		


