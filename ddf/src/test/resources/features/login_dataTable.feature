Feature: Login to the davidjones.com.au
  As a user,
  I want to login to web site,
  so that I can check my account information.

  Scenario: Login with correct credentials.
    Given User in the home page.
    When User click on Sign in button
    And User input userid and password using data table
      | email                   | password |
      | "testuser@yopmail.com"  | "111111" |
      | "testuser1@yopmail.com" | "111111" |
      | "testuser2@yopmail.com" | "222222" |
    Then login to the web site
