package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

	WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
		
	@Test
	public void forgotpassowrdlinkTest() throws InterruptedException {
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys("rimjhim411@gmail.com");
	    Assert.assertTrue(driver.findElement(By.id("auth-fpp-link-bottom")).isDisplayed());
	    
	}
	
	@Test
	public void passwordAssisatancePageLoad() throws InterruptedException {
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys("rimjhim411@gmail.com");
	    driver.findElement(By.id("auth-fpp-link-bottom")).click();
	    Assert.assertTrue(driver.getTitle().startsWith("Amazon Password Assistance"));
	}


}

