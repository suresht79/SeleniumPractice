package com.sabre.dxp.webdriver.onewayflight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExpediaOneWayFlight {

	
	
   @Test
	public void expediaOnewayFlight() throws InterruptedException{
	   
	   System.setProperty("webdriver.chrome.driver","C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	   
		
		
    //launch Expedia.com
	 
	driver.get("https://expedia.com");
	
	
	
	
	

	
	

	
	
	
}
}



