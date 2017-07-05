package SWD1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class FirstSWD {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void ebayTest()
	{
		// 1. Open Chrome Browser
		FirstSWD firstSWD = new FirstSWD();
		driver = firstSWD.getChromeDriver();

		
		
		driver.get("http://www.ebay.com");
		//driver.findElement(By.id("gh-ac")).sendKeys("laptop");
		//driver.findElement(By.id("gh-btn")).click();
		
		
		
		driver.close();
		driver.quit();
        

	}

	@Test
	private void verifyTitle(){
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals("1Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay", actualTitle);
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
		
	  
	    
				
}
	
	


