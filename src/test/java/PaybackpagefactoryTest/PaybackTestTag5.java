package PaybackpagefactoryTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PagefactoryPayback.loginPaybackpagefactory;

public class PaybackTestTag5 {

WebDriver driver = null;	
	
	@Test
	public  void verifylog() throws InterruptedException
	{
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

		
	} 
}
