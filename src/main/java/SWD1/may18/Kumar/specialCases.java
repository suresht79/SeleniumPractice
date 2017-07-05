package SWD1.may18.Kumar;


import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class specialCases {

	WebDriver oBrowser=null;
	
	public void openApplication(String sBrowserType, String sURL)
	{	
		//1. Open Browser		
		if(sBrowserType.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Deepti\\softwaresqa\\geckodriver.exe");
			oBrowser = new FirefoxDriver();
		}
		else if(sBrowserType.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
			oBrowser = new ChromeDriver();	
		}
		else if(sBrowserType.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\IEDriverServer.exe");		
			DesiredCapabilities ieBrwStngs = DesiredCapabilities.internetExplorer();
			ieBrwStngs.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);			
			oBrowser = new InternetExplorerDriver(ieBrwStngs);		
		}
		
		//2. Launch ==> URL
		oBrowser.get(sURL);
		
		oBrowser.manage().window().maximize();
		
	}
	@Test
	public void handlingMenus() throws InterruptedException
	{
		openApplication("Chrome", "https://www.ratehub.ca/");
		
		Actions oAct = new Actions(oBrowser);
		oAct.moveToElement(oBrowser.findElement(By.xpath("//span[contains(text(),'Mortgages')]/ancestor::a")));
		//oAct.moveToElement(oBrowser.findElement(By.xpath("//span[contains(text(),'Mortgage Providers')]/ancestor::a")));
		oAct.build().perform();
		
		Thread.sleep(5000);
		
		oBrowser.findElement(By.linkText("Fixed Mortgage Rates")).click();
	}

	@Test
	public void exForDragAndDrop() throws InterruptedException
	{
		openApplication("Chrome", "https://www.ratehub.ca/");
				
		WebElement uiSource = oBrowser.findElement(By.xpath("//span[contains(text(),'Mortgages')]/ancestor::a"));
		WebElement uiTarget = oBrowser.findElement(By.xpath("//span[contains(text(),'Mortgage Providers')]/ancestor::a"));
		
		Actions oAct = new Actions(oBrowser);
		oAct.dragAndDrop(uiSource, uiTarget).build().perform();
		oBrowser.close();
		
	}

	@Test
	public void exForScreenshot() throws InterruptedException, IOException
	{
				
		openApplication("Chrome", "https://www.ratehub.ca/");
		
		//Type Casting
		TakesScreenshot oScn = (TakesScreenshot) oBrowser;
		
		//the screenshot information is saving into oSrc object/varible - this is not a physical file
		File oSrc = oScn.getScreenshotAs(OutputType.FILE);
		
		//oDst - Creating empty physical image file
		File oDst = new File("C:\\Selenium\\Selenium Docs\\P2S1 Class Notes\\screenshot.jpeg");
		
		//Copy oSrc information to oDst
		FileUtils.copyFile(oSrc, oDst);
		
		
	}

	
}










