package SWD1.may18.Kumar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupOfUIObjs {


	public void rateHub()
	{
		//1. Open Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
		ChromeDriver oBrowser = new ChromeDriver();
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("https://www.ratehub.ca/credit-cards/best-credit-cards");
				 
		List<WebElement> uiAllObjs = oBrowser.findElements(By.className("col-card"));
		
		//How many
		int iTotalBestCC = uiAllObjs.size();
		
		System.out.println("Total Best Credit Cards: " + iTotalBestCC);
		
		for(int iUIObjIndex=0; iUIObjIndex<iTotalBestCC; iUIObjIndex++)
		{
			System.out.println(uiAllObjs.get(iUIObjIndex).getText());
		}
		
	}
	
	@Test
	public void rateHubTextFile() throws FileNotFoundException
	{
		//1. Open Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium Docs\\BrowserDrivers\\ChromeDriver.exe");
		ChromeDriver oBrowser = new ChromeDriver();
		
		//2. Launch ==> www.ebay.com
		oBrowser.get("https://www.ratehub.ca/credit-cards/best-credit-cards");
				 
		List<WebElement> uiAllObjs = oBrowser.findElements(By.className("col-card"));
		
		//Empty Text file
		File oFile = new File("C:\\Selenium\\Selenium Docs\\P2S1 Class Notes\\saveToText.txt");
		
		//Helps in Writing to a text file
		PrintWriter oPW = new PrintWriter(oFile);
		
		for(WebElement uiEachUIobj:uiAllObjs)
		{
			//Writes to the notepad
			oPW.println(uiEachUIobj.getText());			
		}
		
		//Save the file
		oPW.flush();
	
		//Close the file
		oPW.close();
				
	}
}
