package PaybackpagefactoryTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PagefactoryPayback.loginPaybackpagefactory;

public class PaybackloginTestNG {
	WebDriver driver = null;
	@Test(priority=0)
	public  void signuplog() throws InterruptedException
	{
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");
	     driver.manage().window().maximize();
	     driver.findElement(By.linkText("Login")).click();	
		
	   loginPaybackpagefactory log = new loginPaybackpagefactory(driver); 
	   log.signuplog();
	   String parenthandle= driver.getWindowHandle();
       System.out.println("parent window -"+parenthandle);
       Thread.sleep(3000);
	   driver.switchTo().window(parenthandle);
	   driver.close();
	}
	@Test(priority=1)
	 public void paybacklog() throws InterruptedException
	  {
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");
	     driver.manage().window().maximize();
	     driver.findElement(By.linkText("Login")).click();	
		
	   loginPaybackpagefactory log = new loginPaybackpagefactory(driver); 
	   log.paybacklog();
	   driver.close();
       }
	  @Test(priority=2)
	 public void unsuccessfullog() throws InterruptedException
	  {
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");
	     driver.manage().window().maximize();
	     driver.findElement(By.linkText("Login")).click();
	     loginPaybackpagefactory log = new loginPaybackpagefactory(driver); 
	     log.unsuccessfullog();
	     log.reCaptchabox();
	     driver.close();
	  }
	  @Test(priority=3)
	 public void forgotlog() throws InterruptedException, IOException
	  {
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");
	     driver.manage().window().maximize();
	     driver.findElement(By.linkText("Login")).click();	
		
	   loginPaybackpagefactory log = new loginPaybackpagefactory(driver); 
	   log.forgotlog();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[@id='pb-otp-number']")).click();
	   Thread.sleep(30000);
	   driver.findElement(By.xpath("//button[@id='generatePinBtn']")).click();
	   if(driver.getTitle().contains("PIN has been successfully reset"))
	     {
	    	Assert.assertTrue(true);
	     }  
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File file = ts.getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(file,new File("./Screenshot/img6.png"));
	   Thread.sleep(3000);
	   driver.close();
	  }
	  @Test(priority=4)
	  public void invalidAttempt() throws InterruptedException{

		   System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.get("https://www.payback.in/");
		   driver.manage().window().maximize();
		   driver.findElement(By.linkText("Login")).click();
		   loginPaybackpagefactory log = new loginPaybackpagefactory(driver); 
		   log.invalidAttemptnumber("9701362655");
		   log.invalidAttemptpin("1234");
		   Thread.sleep(40000);
		   log.reCaptchabox();
		   Thread.sleep(4000);
		   driver.findElement(By.xpath("//input[@id='pb-pin-number']")).clear();
		   driver.findElement(By.xpath("//span[@data-dismiss='modal']")).click();
		   Thread.sleep(2000);
		   log.invalidAttemptpin("4567");
		   Thread.sleep(40000);
		   log.reCaptchabox();
		   Thread.sleep(4000);
		   driver.findElement(By.xpath("//input[@id='pb-pin-number']")).clear();
		   driver.findElement(By.xpath("//span[@data-dismiss='modal']")).click();
		   log.invalidAttemptpin("6789");
		   Thread.sleep(40000);
		   log.reCaptchabox();
		   Thread.sleep(4000);
		   driver.close();
		  }
	
}
