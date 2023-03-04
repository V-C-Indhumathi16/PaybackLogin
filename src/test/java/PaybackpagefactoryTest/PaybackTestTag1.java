package PaybackpagefactoryTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PagefactoryPayback.loginPaybackpagefactory;

public class PaybackTestTag1 {

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
	   log.signuplog();
	   String parenthandle= driver.getWindowHandle();
       System.out.println("parent window -"+parenthandle);
       Thread.sleep(3000);
	   driver.switchTo().window(parenthandle);
	   
	}
	
}
