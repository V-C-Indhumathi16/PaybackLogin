@Login
Feature: Login Functionality of PAYBACK
  I want to test the login functionality of Payback website

  @tag1
  Scenario: Verifying Login page and Payback logo
    Given User navigates to Payback homepage
    Then User should be in the Payback homepage
    When User clicks on the Login in  homepage
    Then User should navigate to Login page
    When User clicks on the signup image in login page
    Then User should navigate to signup page in new tab
    

  @tag2
  Scenario Outline: Login Success
    Given User is on the Payback homepage
    When User clicks on the Loginicon in homepage
    Then User should navigate to Login page
    And User enters  "<mobilenumber>" and  "<PIN>"
    And User clicks on the reCaptcha checkbox
    And  User clicks on the "Login" button
    Then User should be redirected to homepage

    Examples: 
      | mobilenumber | PIN  |
      | 6305094826   | 1755 |
      | 6305356455   | 5845 |
      | 9553843587   | 0482 |

  @tag3
  Scenario: Unsuccessful login with invalid credentials
    Given User is on the Payback homepage
    When User clicks on the Loginbutton in homepage
    Then User should navigate to Login page
    And User should enter  wrong Mobilenumber and PIN
    And User clicks on the reCaptcha checkbox
    And User clicks on the "Login" button
    Then Message displayed PIN entered by you is incorrect.Please try again

  @tag4
  Scenario: Forgotten PIN recovery
    Given User is on the Payback loginn page
    When User clicks on the Forgot PIN
    And User enters the OTP generated to registered Mobile number
    And User clicks on the Generate PIN button
    Then User should see a confirmation message PIN has been successfully reset

  @tag5
  Scenario Outline: Invalid login attempt limits
    Given User is on the Payback login page
    And User enters wrong  "<mobilenumber>" and "<WrongPIN>"
    And User clicks on the reCaptcha checkbox
    And User clicks on the "Login" button
    Then Message displayed PIN entered by you is incorrect.Only 3 more attempts left after User made 4 consecutive invalid login attempts
    Then User should see a Error message Your PAYBACK Account is blocked temporarily.please call for assistance
    
    Examples:
    | mobilenumber | WrongPIN |
    | 9701362655   | 1234     |
    | 9701362655   | 5678     |
    | 9701362655   | 9087     |