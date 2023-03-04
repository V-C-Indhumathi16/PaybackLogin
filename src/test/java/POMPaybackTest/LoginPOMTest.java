package POMPaybackTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import POMPayback.POMloginpage;

public class LoginPOMTest {

	WebDriver driver= null;
	 POMloginpage log ;
	 
	 @Test
	 public void Verifylog() throws InterruptedException
	 {
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");
	     driver.manage().window().maximize();
	     driver.navigate().to("https://www.payback.in/");
		 driver.findElement(By.linkText("Login")).click();
		 
		 log= new POMloginpage(driver);
	    
	     log.typemobile("6305094826");
	     Thread.sleep(2000);
	     log.typePIN("6343");
	     log.clickreCaptchabox();
	     Thread.sleep(2000);
	     log.clickbtn();
	 }
	
}
