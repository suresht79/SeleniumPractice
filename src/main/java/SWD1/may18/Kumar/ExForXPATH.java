package SWD1.may18.Kumar;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExForXPATH {
	@Test
	public void eBayInChrome()
	{
		//1. Open Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
		ChromeDriver oBrowser = new ChromeDriver();
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("https://www.ratehub.ca/credit-cards/best-credit-cards");
		
		String sAnnualFee = oBrowser.findElement(By.xpath("//a[contains(text(),'SimplyCash Card from American Express')]/ancestor::td/following-sibling::td[2]/span")).getText();
		
		System.out.println(sAnnualFee);
		
	}
}
