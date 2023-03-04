package PagefactoryPayback;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPaybackpagefactory {
  WebDriver driver= null ;
  

  
  @FindBy(xpath="//input[@id='pb-card-number']")
  WebElement mobilenumber;
  
  @FindBy(how=How.XPATH,using="//input[@id='pb-pin-number']")
  WebElement PIN;
 
  @FindBy(how=How.XPATH,using="//div[@class='g-recaptcha']")
  WebElement reCaptchabox;
  
  @FindBy(how=How.XPATH,using="//button[@class='btn pb-login-submit red-button']")
  WebElement logbtn;
  
  @FindBy(xpath="//section[@class='pb-inner-banner-comp']")
  WebElement Signup;
  
  @FindBy(how=How.XPATH,using="//a[@id='pb-forgot-pin1']")
  WebElement ForgotPIN;
  
  @FindBy(xpath="//div[@class='modal-content text-center pop-up-medium']")
  WebElement errorMessage;
  
  public loginPaybackpagefactory(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
  }
  
  public void signuplog() 
  {
	 Signup.click(); 
  }
  public void paybacklog() throws InterruptedException
  {
	  mobilenumber.sendKeys("6305356455");
	  PIN.sendKeys("5845");
	  Thread.sleep(40000);
      reCaptchabox.click();
	  Thread.sleep(2000);
	  logbtn.click();
  }
  public void unsuccessfullog() throws InterruptedException
  {
	 mobilenumber.sendKeys("9701362655"); 
	 PIN.sendKeys("1234");
	 Thread.sleep(25000);
  }
  public void reCaptchabox() 
  {
	 reCaptchabox.click();
	 logbtn.click(); 
  }
  public void forgotlog() throws InterruptedException
  {
	  mobilenumber.sendKeys("6305094826");
	  ForgotPIN.click();
	  Thread.sleep(2000);
  }

  public void invalidAttemptnumber(String string1) {
	 mobilenumber.sendKeys(string1);
  }
  
  public void invalidAttemptpin(String string2) {
	  PIN.sendKeys(string2);
 
  }

}
