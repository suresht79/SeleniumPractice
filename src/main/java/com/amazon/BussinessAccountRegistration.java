package com.amazon;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BussinessAccountRegistration {

WebDriver driver;
	
@Test
public void amazonHomeLoginFailedTest() throws InterruptedException {

	System.setProperty("webdriver.chrome.driver",
			"C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.com");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Actions actions = new Actions(driver); 
	   WebElement menuHoverLink = driver.findElement(By.id("nav-link-accountList"));
	   actions.moveToElement(menuHoverLink).perform();
	   
	   WebElement submenu1=  driver.findElement(By.xpath("//span[text()='Register for a Business Account']")); //Find the submenu
	   actions.moveToElement(submenu1).click().build().perform();
	   Assert.assertEquals("Amazon Business", driver.getTitle());
	   driver.findElement(By.id("B2B-Full-1-heroctavideo-register-announce")).click();
	   
	   Assert.assertTrue(driver.getPageSource().contains("register your business"));
	   driver.findElement(By.id("a-autoid-0-announce")).click();
	   driver.findElement(By.id("ap_email")).sendKeys("rimjhim411@gmail.com");
	   driver.findElement(By.id("ap_password")).sendKeys("Shoponline1#");
	   driver.findElement(By.id("signInSubmit")).click();
	 Assert.assertTrue(driver.findElement(By.cssSelector("div.a-section.a-spacing-none.step-indicator-wrap")).isDisplayed());
	   
	 try {
		 ArrayList<Map<String,String>> testCaseData = SaberLibraryTest.getTestCaseData("C:\\Deepti\\softwaresqa\\AmazonTestData.xls", "AmazonTestData", "BussinessAccountRegistration");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	 
}}
	

		
		
		    
		    
	


