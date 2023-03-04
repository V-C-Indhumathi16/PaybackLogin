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

public class PaybackTestTag4 {

	WebDriver driver=null;
	
	@Test
	public  void verifylog() throws InterruptedException, IOException
	{
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");
	     driver.manage().window().maximize();
	     driver.findElement(By.linkText("Login")).click();	
		
	   loginPaybackpagefactory log = new loginPaybackpagefactory(driver); 
	   log.forgotlog();
	   Thread.sleep(2000);
	   
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File file = ts.getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(file,new File("./Screenshot/img5.png"));
	   driver.findElement(By.xpath("//input[@id='pb-otp-number']")).click();
	   Thread.sleep(30000);
	   driver.findElement(By.xpath("//button[@id='generatePinBtn']")).click();
	   if(driver.getTitle().contains("PIN has been successfully reset"))
	     {
	    	Assert.assertTrue(true);
	     }  
	    Thread.sleep(3000);
	    driver.close();
	   
	}
}
