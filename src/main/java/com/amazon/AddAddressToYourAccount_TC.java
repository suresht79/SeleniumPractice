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

public class AddAddressToYourAccount_TC {
	WebDriver driver;

	@Test
	public void addAddressToYourAccountTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id("nav-link-accountList"));
		actions.moveToElement(menuHoverLink).perform();
		driver.findElement(By.xpath("//span[text()='Your Account']")).click();
		Assert.assertEquals(driver.getTitle(), "Your Account");
		driver.findElement(By.xpath("//span[text()='Edit addresses for orders and gifts']")).click();
		ArrayList<Map<String, String>> testCaseData = null;
		try {
			testCaseData = ExcelFileReader.getTestCaseData("C:\\Deepti\\softwaresqa\\AmazonTestData.xls",
					"AmazonTestData", "AddAddressToYourAccount_TC");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, String> data1 = testCaseData.get(0);
		driver.findElement(By.id("ap_email")).sendKeys(data1.get("Email"));
		driver.findElement(By.id("ap_password")).sendKeys(data1.get("Password"));
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(data1.get("FullName"));
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys(data1.get("StreetAddress"));
		driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys(data1.get("Apartment"));
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(data1.get("City"));
		driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion")).sendKeys(data1.get("State"));
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(data1.get("ZipCode"));
		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys(data1.get("PhoneNumber"));
		
		
		
		

}}
