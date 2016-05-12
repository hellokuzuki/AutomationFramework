Feature: Login to the davidjones.com.au
  As a user,
  I want to login to web site,
  so that I can check my account information.

  Scenario: Login with correct credentials.
    Given User in the home page.
    When User click on Sign in button
    And User input userid and password
    Then login to the web site