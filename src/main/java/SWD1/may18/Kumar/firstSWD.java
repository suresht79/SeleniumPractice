package SWD1.may18.Kumar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class firstSWD {
	
	public void eBayInChrome()
	{
		//1. Open Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
		ChromeDriver oBrowser = new ChromeDriver();
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("http://www.ebay.com/");
		
		//3. Enter "laptop" in search text box
		//3.a ==> Recognize the text box ==> oBrowser.findElement(By.id("gh-ac"))
		//3.b then Enter value to the text box
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("laptop");
		
		//4. Click on "Search" button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		//5. Click on "Advanced" link
		oBrowser.findElement(By.linkText("Advanced")).click();
		
	}
	
	public void eBayInIE()
	{
		//1. Open Chrome Browser
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\IEDriverServer.exe");
		
		DesiredCapabilities ieBrwStngs = DesiredCapabilities.internetExplorer();
		ieBrwStngs.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		InternetExplorerDriver oBrowser = new InternetExplorerDriver(ieBrwStngs);
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("http://www.ebay.com/");
		
		//3. Enter "laptop" in search text box
		//3.a ==> Recognize the text box ==> oBrowser.findElement(By.id("gh-ac"))
		//3.b then Enter value to the text box
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("laptop");
		
		//4. Click on "Search" button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		//5. Click on "Advanced" link
		oBrowser.findElement(By.linkText("Advanced")).click();
		
	}

	public void eBayInFirefox()
	{
		//1. Open Chrome Browser
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\FFGeckoDriver.exe");
		
		FirefoxDriver oBrowser = new FirefoxDriver();
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("http://www.ebay.com/");
		
		//3. Enter "laptop" in search text box
		//3.a ==> Recognize the text box ==> oBrowser.findElement(By.id("gh-ac"))
		//3.b then Enter value to the text box
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("laptop");
		
		//4. Click on "Search" button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		//5. Click on "Advanced" link
		oBrowser.findElement(By.linkText("Advanced")).click();
		
	}

	@Test
	public void eBayHandlingMultipleBrowsers()
	{
		WebDriver oBrowser=null;
		String sBrowserType = "Firefox";
		
		
		//1. Open Browser		
		if(sBrowserType.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\FFGeckoDriver.exe");
			oBrowser = new FirefoxDriver();
		}
		else if(sBrowserType.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
			oBrowser = new ChromeDriver();	
		}
		else if(sBrowserType.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\IEDriverServer.exe");		
			DesiredCapabilities ieBrwStngs = DesiredCapabilities.internetExplorer();
			ieBrwStngs.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);			
			oBrowser = new InternetExplorerDriver(ieBrwStngs);		
		}
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("http://www.ebay.com/");
		
		//3. Enter "laptop" in search text box
		//3.a ==> Recognize the text box ==> oBrowser.findElement(By.id("gh-ac"))
		//3.b then Enter value to the text box
		oBrowser.findElement(By.id("gh-ac")).clear();
		oBrowser.findElement(By.id("gh-ac")).sendKeys("laptop");
		
		//4. Click on "Search" button
		oBrowser.findElement(By.id("gh-btn")).click();
		
		//5. Click on "Advanced" link
		oBrowser.findElement(By.linkText("Advanced")).click();
		
	}
	
}

