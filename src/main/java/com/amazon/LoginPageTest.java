package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	WebDriver driver;
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void amazonHomeLoginPageLoadTest() throws InterruptedException {

	
		// login
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("nav-link-accountList")).click();
		Assert.assertTrue(driver.getTitle().equals("Amazon Sign In"));
		
	}

	@Test
	public void amazonHomeLoginSuccessfulTest() throws InterruptedException {

		
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys("rimjhim411@gmail.com");
		//driver.findElement(By.id("ap_password")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Shoponline1#");
		driver.findElement(By.id("signInSubmit")).click();
		Assert.assertTrue(driver.getTitle().startsWith("Amazon.com: Online "));
		
	}
	

	@Test
	public void amazonHomeLoginFailedTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys("rimjhim411@gmail.com");
		//driver.findElement(By.id("ap_password")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Shoponline1");
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("auth-error-message-box")).isDisplayed();
	    Assert.assertTrue(driver.findElement(By.id("auth-error-message-box")).isDisplayed());
		

}}
