package com.sabre.dxp.webdriver.onewayflight;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class automationPractice {

	WebDriver driver;
	
   @Test
	public void phpTravelOnewayFlight() throws InterruptedException{
	   
	   System.setProperty("webdriver.chrome.driver","C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver();
	   	
	   driver.get("http://automationpractice.com/index.php");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Actions actions = new Actions(driver); 
	   WebElement menuHoverLink = driver.findElement(By.linkText("DRESSES"));
	   actions.moveToElement(menuHoverLink).perform();
	   
	   //driver.findElement(By.cssSelector("a[href='nemc.com/rentals/easy-rent']")).click();
	   WebElement submenu1=  driver.findElement(By.linkText("EVENING DRESSES")); //Find the submenu
	   actions.moveToElement(submenu1).click().build().perform();
	   
   }
   
	 @AfterClass
	  public void closebrowser(){
		 //driver.quit();
	  }
   
	
}



