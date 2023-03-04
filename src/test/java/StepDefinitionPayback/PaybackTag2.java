package StepDefinitionPayback;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaybackTag2 {

	 WebDriver driver;
	  WebElement mobilenumber;
	  WebElement PIN;
	  WebElement reCaptchabox;
	  WebElement logbtn;
	  
	 // loginPaybackpagefactory log = PageFactory.initElements(driver,loginPaybackpagefactory.class); 
	  
	@Given("User is on the Payback homepage")
	public void user_is_on_the_Payback_homepage() throws InterruptedException {
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");  
	     driver.manage().window().maximize();
	     Thread.sleep(2000);
	}

	@When("User clicks on the Login in home page")
	public void user_clicks_on_the_Login_in_home_page() throws InterruptedException {
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
	   
	}

	@Then("User should Navigate to Login page")
	public void user_should_Navigate_to_Login_page()  {
		 if(driver.getTitle().contains("LOGIN"))
	     {
	    	Assert.assertTrue(true);
	     }  
	}
  @Then("User enters  {string} and  {string}")
 public void user_enters_and(String string, String string2) throws InterruptedException {
	 mobilenumber=driver.findElement(By.xpath("//input[@id='pb-card-number']"));
	 PIN=driver.findElement(By.xpath("//input[@id='pb-pin-number']"));
	 mobilenumber.sendKeys(string);
	 Thread.sleep(2000);
     PIN.sendKeys(string2);
     Thread.sleep(15000);
 
  }
	@Then("User clicks on the reCaptcha checkbox")
	public void user_clicks_on_the_reCaptcha_checkbox() throws InterruptedException  {
	    reCaptchabox=driver.findElement(By.xpath("//div[@id='captcha_login_page']"));
		reCaptchabox.click();
	    Thread.sleep(1000);
	}

	@Then("User clicks on the {string} button")
	public void user_clicks_on_the_button(String string)  {
	   logbtn=driver.findElement(By.xpath("//button[@class='btn pb-login-submit red-button']"));
	   logbtn.click();
      
	}

	@Then("User should be redirected to homepage")
	public void user_should_be_redirected_to_homepage() throws InterruptedException {
		if(driver.getTitle().contains("0 P"))
	     {
	    	Assert.assertTrue(true);
	     }  
	   Thread.sleep(2000);
	   driver.close();
	}
}
