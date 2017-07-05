package com.amazon;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomePageTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void amazonHomePageLoadSuccessfullyTest() throws InterruptedException {

		// launch Amazon.com
		driver.get("https://www.amazon.com");
		assertTrue(driver.getTitle()
				.contains("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
		driver.findElement(By.className("nav-input")).click();
		Thread.sleep(2000);
		assertTrue(driver.getTitle().startsWith("Amazon.com: Laptop"));

	}
	
	 @Test(priority=2)
	public void amazonLogoPresentTest() throws InterruptedException {
        // launch Amazon.com
		driver.get("https://www.amazon.com");
		assertTrue(driver.findElement( By.xpath("//*[@id='nav-logo']/a[1]/span[1]")).isDisplayed());
		

		
	
			
			
		
}
	
}
	
	
		
	
	
	

