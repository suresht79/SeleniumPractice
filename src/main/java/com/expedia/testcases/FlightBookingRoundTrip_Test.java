package com.expedia.testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightBookingRoundTrip_Test {

	WebDriver driver;
	private static final String DIRECTORY_NAME = "C:\\Deepti\\softwaresqa\\";
	
	private static String testDirectoryName;
	
	private static final String FILE_NAME = DIRECTORY_NAME + "flightTestData.xlsx";
	
	
	By originPlaceText = By.id("flight-origin-hp-flight");
	By destinationPlaceText = By.id("flight-destination-hp-flight");
	By departingDateText = By.id("flight-departing-hp-flight") ;
	By returnDateText = By.id("flight-returning-hp-flight") ;
	By flightSubmitButton = By.cssSelector(".btn-primary.btn-action.gcw-submit") ;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
	}

	@Test
	public void bookRoundTripFlightTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Deepti\\H2K\\FirstSel\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Deepti\\softwaresqa\\geckodriver.exe");

		Map<String, String> testDataMap = SaberLibrary.getExcelData(FILE_NAME, "roundTrip");

					
			if(!testDataMap.get("executable").equals("Y")){
				return;
			}
			
			
			if (testDataMap.get("browser").equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (testDataMap.get("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH_mm_ss");
		    String strDate = sdf.format(new Date());
		    
			testDirectoryName = "bookRoundTripFlightTest_" + testDataMap.get("browser") + "_" + strDate;

			driver.get("http://www.expedia.com");
			
			assertTrue(driver.getTitle().startsWith("Expedia Travel"));

			clickFlightTab();

			searchFlight(testDataMap);

			selectDepartureFlight();

			selectReturnFlight();

			sayNoThanksToHotel();

			continueBookingTheFlight();

			provideBookingData(testDataMap);

		
	}

	public void clickFlightTab() {
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		takeScreenShot("clickFlightTab");
	}
	

	
	public void searchFlight(Map<String,String> testDataMap) throws InterruptedException {
		driver.findElement(originPlaceText).sendKeys(testDataMap.get("flyingFrom"));
		driver.findElement(destinationPlaceText).sendKeys(testDataMap.get("flyingTo"));
		driver.findElement(departingDateText).sendKeys(testDataMap.get("departingDate"));
		driver.findElement(returnDateText).clear();
		driver.findElement(returnDateText).sendKeys(testDataMap.get("returnDate"));
		driver.findElement(flightSubmitButton).click();
		takeScreenShot("searchFlight");
		
		
	}

	public void continueBookingTheFlight() {
		  //Thread.sleep(10000);
	      WebElement bookButton;
	      try{
	    	  bookButton =  driver.findElement(By.xpath("//div[@id='details']/section[2]/section/article[1]/div[3]/button"));
	      }
	      catch(NoSuchElementException ex){
	    	  bookButton =  driver.findElement(By.cssSelector("button.btn-primary.btn-action"));
	      }
		  bookButton.click();
		  takeScreenShot("continueBookingTheFlight");
	}

	public void sayNoThanksToHotel() {
		//Thread.sleep(3000);
		try{
			//driver.findElement(By.partialLinkText("No thanks")).click();
			
			(new WebDriverWait(driver, 10))
			  .until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("No thanks"))).click();
		}
		catch(NoSuchElementException | TimeoutException ex){
	    	  System.out.println("'No Thanks' Link is missing");
	      }
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    takeScreenShot("sayNoThanksToHotel");
	}

	public void selectReturnFlight() throws Exception{
		Thread.sleep(2000);
		List<WebElement> elements =  driver.findElements(By.cssSelector("button.btn-secondary.btn-action.t-select-btn"));
		
		
		/*List<WebElement> elements = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("button.btn-secondary.btn-action.t-select-btn"), 0));
*/		
		elements.get(0).sendKeys(Keys.RETURN);
		takeScreenShot("selectReturnFlight");
	}

	public void selectDepartureFlight() throws InterruptedException {
		
		/*List<WebElement> elements = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("button.btn-secondary.btn-action.t-select-btn"), 0));
		*/
		List<WebElement> elements =  driver.findElements(By.cssSelector("button.btn-secondary.btn-action.t-select-btn"));
		  
		  while(null==elements || elements.size()<=0){
			  elements =  driver.findElements(By.cssSelector(".btn-secondary.btn-action.t-select-btn"));
			  System.out.println("Waiting for source flight button to be displayed");
			  Thread.sleep(1000);
		  }
		  
		  WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.elementToBeClickable(elements.get(0)));
  
		  elements.get(0).sendKeys(Keys.RETURN);
		  takeScreenShot("selectDepartureFlight");
	}

	
	public void provideBookingData(Map<String,String> testDataMap) throws InterruptedException {
		
		driver.findElement(By.id("firstname[0]")).sendKeys(testDataMap.get("firstName"));
		driver.findElement(By.id("lastname[0]")).sendKeys(testDataMap.get("lastName"));
		//takeScreenShot("provideBookingData");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile
			// //method
			FileUtils.copyFile(src, new File(DIRECTORY_NAME + testDirectoryName + "\\" + "provideBookingData" + ".jpg"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}
	
	public void takeScreenShot(String fileName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile
			// //method
			FileUtils.copyFile(src, new File(DIRECTORY_NAME + testDirectoryName + "\\" + fileName + ".jpg"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
