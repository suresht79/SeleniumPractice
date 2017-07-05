package SWD1.may18.Kumar;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class firstSelWDRec {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.ebay.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFirstSelWDRec() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("gh-ac")).click();
    driver.findElement(By.id("gh-ac")).clear();
    driver.findElement(By.id("gh-ac")).sendKeys("laptop");
    driver.findElement(By.id("gh-btn")).click();
    driver.findElement(By.id("gh-as-a")).click();
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      //fail(verificationErrorString);
    }
  }
}
