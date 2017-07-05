
package com.ebay;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EbayHomePageTest {
	
	WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("before Suite");
		driver = getChromeDriver();
		driver.get("http://www.ebay.com");
		//driver.findElement(By.id("gh-ac")).sendKeys("laptop");
		//driver.findElement(By.id("gh-btn")).click();
	}

	@Test
	private void verifyTitle(){
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay", actualTitle);
		
	}
	
	private WebDriver getChromeDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    return driver;
	}
	
	private WebDriver getFirefoxDriver(){
		System.setProperty("webdriver.gecko.driver", "C:\\Deepti\\softwaresqa\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    return driver;
	    
	  
	    
	}

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite");
	  driver.close();
		driver.quit();
		
  }

}
