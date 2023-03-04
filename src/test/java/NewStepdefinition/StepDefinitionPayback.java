package NewStepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionPayback {
	 WebDriver driver;
	 WebElement mobilenumber;
	 WebElement PIN;
	 WebElement reCaptchabox;
	 WebElement logbtn;
	 WebElement ForgotPIN;
	
	@Given("User navigates to Payback homepage")
	public void user_navigates_to_Payback_homepage() {
		 System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");   
	}

	@Then("User should be in the Payback homepage")
	public void user_should_be_in_the_Payback_homepage() throws InterruptedException {
		driver.manage().window().maximize();
		  driver.navigate().to("https://www.payback.in/");
		  Thread.sleep(2000);
	}

	@When("User clicks on the Login in  homepage")
	public void user_clicks_on_the_Login_in_homepage() throws InterruptedException {
		driver.findElement(By.linkText("Login")).click();
		  Thread.sleep(2000);
	}

	@Then("User should navigate to Login page")
	public void user_should_navigate_to_Login_page() {
		if(driver.getTitle().contains("LOGIN"))
	     {
	    	Assert.assertTrue(true);
	     } 
	}

	@When("User clicks on the signup image in login page")
	public void user_clicks_on_the_signup_image_in_login_page() throws InterruptedException {
		driver.findElement(By.xpath("//section[@class='pb-inner-banner-comp']")).click();
	    Thread.sleep(5000);
	}

	@Then("User should navigate to signup page in new tab")
	public void user_should_navigate_to_signup_page_in_new_tab() throws InterruptedException {
		 if(driver.getTitle().contains("Sign Up"))
		    {
		    	Assert.assertTrue(true);
		    }
		  Thread.sleep(3000);
		   String parenthandle= driver.getWindowHandle();
	       System.out.println("parent window -"+parenthandle);
	       Thread.sleep(3000);
		   driver.switchTo().window(parenthandle);
		   driver.close();
	}

	@Given("User is on the Payback homepage")
	public void user_is_on_the_Payback_homepage() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get("https://www.payback.in/");  
	     driver.manage().window().maximize();
	     Thread.sleep(2000);
	}
	@When("User clicks on the Loginicon in homepage")
	public void user_clicks_on_the_Loginicon_in_homepage() throws InterruptedException {
		driver.findElement(By.linkText("Login")).click();
		  Thread.sleep(2000);
	}

	@Then("User enters  {string} and  {string}")
	public void user_enters_and(String string, String string2) throws InterruptedException {
		 mobilenumber=driver.findElement(By.xpath("//input[@id='pb-card-number']"));
		 PIN=driver.findElement(By.xpath("//input[@id='pb-pin-number']"));
		 mobilenumber.sendKeys(string);
		 Thread.sleep(2000);
	     PIN.sendKeys(string2);
	     Thread.sleep(20000);
	}

	@Then("User clicks on the reCaptcha checkbox")
	public void user_clicks_on_the_reCaptcha_checkbox() throws InterruptedException {
		reCaptchabox=driver.findElement(By.xpath("//div[@id='captcha_login_page']"));
		 reCaptchabox.click();
		    Thread.sleep(1000);
		 
		// switch to reCAPTCHA frame
		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));

		 // find and click the images
		 List<WebElement> images = driver.findElements(By.xpath("//div[@class='rc-imageselect-target']/descendant::img"));
		 for (WebElement image : images) {
		     image.click();
		 }

		 // switch back to main frame
		 driver.switchTo().defaultContent();

	}

	@Then("User clicks on the {string} button")
	public void user_clicks_on_the_button(String string) {
		 logbtn=driver.findElement(By.xpath("//button[@class='btn pb-login-submit red-button']"));
		 logbtn.click(); 
	}

	@Then("User should be redirected to homepage")
	public void user_should_be_redirected_to_homepage() throws InterruptedException {
		 if(driver.getTitle().contains("LOGIN"))
	     {
	    	Assert.assertTrue(true);
	     } 
		 Thread.sleep(5000);
		 driver.close();
	}
	@When("User clicks on the Loginbutton in homepage")
	public void user_clicks_on_the_Loginbutton_in_homepage() throws InterruptedException {
		driver.findElement(By.linkText("Login")).click();
		  Thread.sleep(2000);
	}

   @Then("User should enter  wrong Mobilenumber and PIN")
	public void user_should_enter_wrong_Mobilenumber_and_PIN() throws InterruptedException {
	   mobilenumber=driver.findElement(By.xpath("//input[@id='pb-card-number']"));
		 PIN=driver.findElement(By.xpath("//input[@id='pb-pin-number']"));
		 mobilenumber.sendKeys("6305094826"); 
		 PIN.sendKeys("1234");
		 Thread.sleep(40000);
	}

	@Then("Message displayed PIN entered by you is incorrect.Please try again")
	public void message_displayed_PIN_entered_by_you_is_incorrect_Please_try_again() throws InterruptedException {
		 if(driver.getTitle().contains("PIN entered by you is incorrect"))
	     {
	    	Assert.assertTrue(true);
	     }  
	   Thread.sleep(5000);
	   driver.close();
	}

	@Given("User is on the Payback loginn page")
	public void user_is_on_the_Payback_loginn_page() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.payback.in/login");
		driver.manage().window().maximize();
	     Thread.sleep(2000);
	}

	@When("User clicks on the Forgot PIN")
	public void user_clicks_on_the_Forgot_PIN() throws InterruptedException {
		 mobilenumber=driver.findElement(By.xpath("//input[@id='pb-card-number']"));
		 ForgotPIN=driver.findElement(By.xpath("//a[@id='pb-forgot-pin1']"));
		 mobilenumber.sendKeys("6305094826");
		 ForgotPIN.click();
		 Thread.sleep(2000);
	}

	@When("User enters the OTP generated to registered Mobile number")
	public void user_enters_the_OTP_generated_to_registered_Mobile_number() throws InterruptedException, IOException {
		 
		   TakesScreenshot ts = (TakesScreenshot)driver;
		   File file = ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(file,new File("./Screenshot/img2.png"));
		  driver.findElement(By.xpath("//input[@id='pb-otp-number']")).click();
	      Thread.sleep(30000);
	}

	@When("User clicks on the Generate PIN button")
	public void user_clicks_on_the_Generate_PIN_button() {
	    driver.findElement(By.xpath("//button[@id='generatePinBtn']")).click();
	}

	@Then("User should see a confirmation message PIN has been successfully reset")
	public void user_should_see_a_confirmation_message_PIN_has_been_successfully_reset() throws InterruptedException {
		 if(driver.getTitle().contains("PIN has been successfully reset"))
	     {
	    	Assert.assertTrue(true);
	     }  
	    Thread.sleep(3000);
	    driver.close();
	}
	@Given("User is on the Payback login page")
	public void user_is_on_the_Payback_login_page() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.payback.in/login");
		driver.manage().window().maximize();
	     Thread.sleep(2000); 
	}
	@Given("User enters wrong  {string} and {string}")
	public void user_enters_wrong_and(String string, String string2) throws InterruptedException {
	     mobilenumber=driver.findElement(By.xpath("//input[@id='pb-card-number']"));
		 PIN=driver.findElement(By.xpath("//input[@id='pb-pin-number']"));
	     mobilenumber.sendKeys(string);
	     PIN.sendKeys(string2);
	     Thread.sleep(40000);
	}

	@Then("Message displayed PIN entered by you is incorrect.Only {int} more attempts left after User made {int} consecutive invalid login attempts")
	public void message_displayed_PIN_entered_by_you_is_incorrect_Only_more_attempts_left_after_User_made_consecutive_invalid_login_attempts(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@Then("User should see a Error message Your PAYBACK Account is blocked temporarily.please call for assistance")
	public void user_should_see_a_Error_message_Your_PAYBACK_Account_is_blocked_temporarily_please_call_for_assistance() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='modal-body']"));
		if(driver.getTitle().contains("Your PAYBACK Account is temporarily blocked"))
	     {
	    	Assert.assertTrue(true);
	     }  
	    Thread.sleep(3000);
	    driver.close();
	}

}
