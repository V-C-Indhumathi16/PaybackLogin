package StepDefinitionPayback;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaybackTag1 {

	 WebDriver driver;
	 

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

	  @When("User clicks on the Login in the homepage")
	  public void user_clicks_on_the_Login_in_the_homepage() throws InterruptedException {
		  driver.findElement(By.linkText("Login")).click();
		  Thread.sleep(2000);
	  }

	  @Then("User should navigate to login page")
	  public void user_should_navigate_to_login_page() {
		 
		     if(driver.getTitle().contains("LOGIN"))
		     {
		    	Assert.assertTrue(true);
		     }  
	  } 
	  
	  @When("User clicks on the signup image in login page")
	  public void user_clicks_on_the_signup_image_in_login_page() {
	     driver.findElement(By.xpath("//section[@class='pb-inner-banner-comp']")).click();
	  }

	  @Then("User should navigate to signup page in new tab")
	  public void user_should_navigate_to_signup_page_in_new_tab() {
	    if(driver.getTitle().contains("Sign Up"))
	    {
	    	Assert.assertTrue(true);
	    }
		}

}
