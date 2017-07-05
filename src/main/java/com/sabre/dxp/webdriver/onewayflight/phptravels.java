package com.sabre.dxp.webdriver.onewayflight;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class phptravels {

	WebDriver driver;
	
   @Test
	public void phpTravelOnewayFlight() throws InterruptedException{
	   
	   System.setProperty("webdriver.chrome.driver","C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver();
	   
		
		
    //launch Expedia.com
	 
	/*driver.get("http://www.phptravels.net");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.findElement(By.linkText("Flights")).click();
	//driver.findElement(By.id("flights-origin-prepop-whitelabel_en")).sendKeys("Dallas, TX");
	
	Thread.sleep(3000);
	
	List<WebElement> linkList=driver.findElements(By.tagName("a"));

	//now traverse over the list and check
	for(int i=0 ; i<linkList.size() ; i++)
	{
	    if(linkList.get(i).getAttribute("href").contains("TRAVELPAYOUTS"))
	    {
	        linkList.get(i).click();
	        break;
	    }
	}
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[id^=flights-origin-prepop]")).sendKeys("Dallas,TX");
	//driver.findElement(By.name("origin_name")).sendKeys("Dallas, TX");
	driver.findElement(By.cssSelector("[id^=flights-destination-prepop]")).sendKeys("Delhi, India");
	//driver.findElement(By.name("destination_name")).sendKeys("Delhi, India");
	driver.findElement(By.cssSelector("[id^=flights-dates-depart-prepop]")).sendKeys("10/01/2017");
	
	driver.findElement(By.cssSelector("[id^=flights-dates-depart-prepop]")).sendKeys("11/01/2017");
	
	driver.findElement(By.xpath("//button[text()='Search']")).click();*/
	
	   driver.get("http://www.omanair.com/en/plan-book");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.id("bfFrom")).sendKeys("Abu Dhabi, United Arab Emirates (AUH)");
	   driver.findElement(By.id("bfTo")).sendKeys("Addis Ababa, Ethiopia (ADD)");
	   driver.findElement(By.id("bfDepartDate")).sendKeys("08-11-2017");
	   driver.findElement(By.id("bfReturnDate")).sendKeys("08-22-2017");
	   driver.findElement(By.id("bfFlightSearchSubmit")).click();
	   
	   
	
	
	

	
	
	
}
 //  @AfterClass
  // public void closebrowser(){
	 //  driver.quit();
   }
   




