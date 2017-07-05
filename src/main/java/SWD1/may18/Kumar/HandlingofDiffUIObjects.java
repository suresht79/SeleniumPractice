package SWD1.may18.Kumar;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingofDiffUIObjects {


	@Test
	public void eBayInChrome() throws InterruptedException
	{
		

		String sSellerOptions ="eBayStores";
		
		//1. Open Chrome Browser
		System.setProperty("webdriver.chrome.driver","C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
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
		//oBrowser.findElement(By.linkText("Advanced")).click();
		WebElement oAdvLink = oBrowser.findElement(By.linkText("Advanced"));		
		oAdvLink.click();
		
		Thread.sleep(5000);
		
		//Handling Checkbox ==> //5. Select " Title and description"  checkbox
		if(oBrowser.findElement(By.id("LH_TitleDesc")).isSelected())
		{
			//nothing
		}
		else
		{
			oBrowser.findElement(By.id("LH_TitleDesc")).click();
		}
		
		////Handling Image ==> Drop Down/List box		6. Select "Any words Any Order" dropdown		
		Select uiDD = new Select(oBrowser.findElement(By.id("e1-1")));
		uiDD.selectByVisibleText("Books");
		
		System.out.println(uiDD.getOptions().size());
		/*
		Thread.sleep(5000);
		uiDD.selectByIndex(2);	//Art
		Thread.sleep(5000);
		uiDD.selectByValue("625");
			*/
		
		// Only show items from: Checkbox
		if(oBrowser.findElement(By.id("_fss")).isSelected())
		{
			//nothing
		}
		else
		{
			oBrowser.findElement(By.id("_fss")).click();
		}
		
		//Handling Image ==> Radio Buttons
		if(sSellerOptions.equals("SpecificSellers"))
		{
			oBrowser.findElement(By.id("LH_SpecificSeller_id")).click();
		}
		else if(sSellerOptions.equals("FollowingSellers"))
		{
			oBrowser.findElement(By.id("LH_FavSellers_id")).click();
		}
		else if(sSellerOptions.equals("eBayStores"))
		{
			oBrowser.findElement(By.id("LH_SellerWithStore_id")).click();
		}
		
		Thread.sleep(5000);
		
		//Handling Image ==> Click on eBay Image/logo
		oBrowser.findElement(By.id("gh-logo")).click();
		
	}
	
}
