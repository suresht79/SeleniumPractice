package SWD1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class SpecialCases {
      
	@Test
	public  void SpecialCases(){
			
		    
		    WebDriver driver = new ChromeDriver();
			driver.get("http://www.ratehub.ca/");
		}
  
	WebDriver oBrowser=null;
	
	public void openApplication(String sBrowserType, String sURL) {
	
	}
	
	public void handlingMenus() throws InterruptedException{
		
		
		  Actions oAct = new Actions(oBrowser);
			 oAct.moveToElement(oBrowser.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/nav/ul/li[1]/a/span")));
			 
			 oAct.moveToElement(oBrowser.findElement(By.xpath("Calculators")));
			 

	
			 
			 
			/*Actions action = new Actions(webdriver);
			 WebElement we = webdriver.findElement(By.xpath("html/body/div[13]/ul/li[4]/a"));
			 action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("/expression-here"))).click().build().perform();*/
	}
	
	public void exForDragAndDrop() throws InterruptedException{}
	
	
	public void exForScreenshot() throws InterruptedException{}
	
	@Test
public void exForJavaScriptExecutor()
		
		{
			openApplication("Chrome","https://www.ratehub.ca/");
			
			//TypeCasting
			JavascriptExecutor js = (JavascriptExecutor) oBrowser;
			js.executeScript("window.scrollBy(0,400);");
			
			
			
		 openApplication("Chrome","https://www.ratehub.ca/");
		}
	
   @Test
	public void handlingAlert()
	{

		openApplication("Chrome", "http://www.nasdaq.com/symbol/adp/real-time");
		// make sure that check box is selected
		if (!!oBrowser.findElement(By.id("cookiepref")).isSelected()) {
			oBrowser.findElement(By.id("cookiepref")).click();

		}
		// un-select it
		oBrowser.findElement(By.id("cookiepref")).click();

		// Switch the focus to the popup
		Alert oAlt = oBrowser.switchTo().alert();

	}
		

@Test
public void handlingmultiplebrowsers() throws InterruptedException, IOException
{
	openApplication("Chrome","https://www.startwire.com/recommendations#/");
	 Thread.sleep(5000);
	 
	 //Get the ParentBrowser/Window ID
	 String sParentID = oBrowser.getWindowHandle();
	 String xpathExpression = null;
	 oBrowser.findElements(By.xpath(xpathExpression));
		
		
				 
	  //Type Casting
	  TakesScreenshot oScn = (TakesScreenshot) oBrowser;
	  
	  //the screenshot information is saving into oSrc object/variable - this is not a physical file
	  File oSrc = oScn.getScreenshotAs(OutputType.FILE);
	  
	  //How to create a physical file, when we create a physical file it will be empty first
	  File oDst =new File("C:\\Deepti\\H2K\\FirstSel\\screenshot.jpeg");
	//Copy oSrc information to oDst
	  FileUtils.copyFile(oSrc, oDst);
	  
	  
	  
		 
		 
	}

		
	}

	  
	



	  
	  
	
	  
	  
	  
	  
			  
	


