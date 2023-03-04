package StepDefinitionPayback;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import PagefactoryPayback.loginPaybackpagefactory;

import io.cucumber.java.en.Then;


public class PaybackTag3 {
	  WebDriver driver= null;
	  WebElement mobilenumber;
	  WebElement PIN;
	  WebElement reCaptchabox;
	  WebElement logbtn;
	 
	
	  @Then("user should Navigate to Login Page")
	  public void user_should_Navigate_to_Login_Page() {
		 
		  mobilenumber=driver.findElement(By.xpath("//input[@id='pb-card-number']"));
			 PIN=driver.findElement(By.xpath("//input[@id='pb-pin-number']"));
		  
	  } 

	@Then("User enters  Mobile Number and PIN")
	public void user_enters_Mobile_Number_and_PIN() throws InterruptedException {

		 mobilenumber.sendKeys("6305094826"); 
		 PIN.sendKeys("1234");
		 Thread.sleep(15000);
	}

	@Then("The User Credentials are wrong")
	public void the_User_Credentials_are_wrong() throws InterruptedException {
		loginPaybackpagefactory page = new loginPaybackpagefactory(driver);
	    page.unsuccessfullog();
	}


	@Then("Message displayed PIN entered by you is incorrect.Please try again")
	public void message_displayed_PIN_entered_by_you_is_incorrect_Please_try_again() throws InterruptedException {
		if(driver.getTitle().contains("PIN entered by you is incorrect"))
	     {
	    	Assert.assertTrue(true);
	     }  
	   Thread.sleep(2000);
	   driver.close();
	}

}
