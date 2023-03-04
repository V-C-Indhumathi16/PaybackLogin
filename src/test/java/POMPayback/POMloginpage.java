package POMPayback;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMloginpage {

	WebDriver driver=null;
	  
	By mobilenumber =By.xpath("//input[@id='pb-card-number']"); 
    By  PIN =By.xpath("//input[@id='pb-pin-number']");	
	By  reCaptchabox =By.xpath("//div[@id='captcha_login_page']");
	By logbtn =By.xpath("//button[@class='btn pb-login-submit red-button']");
	
	public POMloginpage(WebDriver driver)
	{
		this.driver=driver;
	}
    public void typelog(String mn, String pwd)
	{
	    	driver.findElement(mobilenumber).sendKeys(mn);
	        driver.findElement(PIN).sendKeys(pwd);
	        driver.findElement(reCaptchabox).click();
	    	driver.findElement(logbtn).click();
	}
	
	public void typemobile(String mn) 
	{
		driver.findElement(mobilenumber).sendKeys(mn);		
	
	}
	public void typePIN(String pwd)
	{
		driver.findElement(PIN).sendKeys(pwd);
	}
	public void clickreCaptchabox()
	{
		driver.findElement(reCaptchabox).click();
	}
	public void clickbtn()
	{
		driver.findElement(logbtn).click();
	}
}
