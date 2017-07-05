package com.amazon;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id("nav-link-accountList"));
		actions.moveToElement(menuHoverLink).perform();

		WebElement submenu1 = driver.findElement(By.xpath("//span[text()='Register for a Business Account']")); // Find
																												// the
																												// submenu
		actions.moveToElement(submenu1).click().build().perform();
		Assert.assertEquals(driver.getTitle(), "Amazon Business");
		driver.findElement(By.id("B2B-Full-1-heroctavideo-register-announce")).click();

		Assert.assertTrue(driver.getPageSource().contains("register your business"));
		driver.findElement(By.id("a-autoid-0-announce")).click();
		driver.findElement(By.id("ap_email")).sendKeys("rimjhim411@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Shoponline1#");
		driver.findElement(By.id("signInSubmit")).click();
		Assert.assertTrue(
				driver.findElement(By.cssSelector("div.a-section.a-spacing-none.step-indicator-wrap")).isDisplayed());

		ArrayList<Map<String, String>> testCaseData = null;
		try {
			testCaseData = SaberLibraryTest.getTestCaseData("C:\\Deepti\\softwaresqa\\AmazonTestData.xls",
					"AmazonTestData", "BussinessAccountRegistration");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, String> data = testCaseData.get(0);
		driver.findElement(By.id("input_addressName")).sendKeys(data.get("BusinessName"));
		// driver.findElement(By.id("native_Industry")).s
		Select dropdown = new Select(driver.findElement(By.id("native_Industry")));
		dropdown.selectByVisibleText(data.get("Industry"));
		driver.findElement(By.id("input_address1")).sendKeys(data.get("StreetAddress1"));
		driver.findElement(By.id("input_city")).sendKeys(data.get("City"));
		Select stateDropdown = new Select(driver.findElement(By.id("native_State")));
		stateDropdown.selectByVisibleText(data.get("State"));
		driver.findElement(By.id("input_zip")).sendKeys(data.get("Zip"));
		driver.findElement(By.name("useAddressForShipping")).click();

	}}
	

		
		
		    
		    
	


