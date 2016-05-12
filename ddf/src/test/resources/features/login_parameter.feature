Feature: Login to the davidjones.com.au
  As a user,
  I want to login to web site,
  so that I can check my account information.

  Scenario: Login with correct credentials.
    Given User in the home page.
    When User click on Sign in button
    And User input userid as "testuser@yopmail.com" and password "111111"
    Then login to the web site

  Scenario: Login with correct credentials.
    Given User in the home page.
    When User click on Sign in button
    And User input userid as "testuser1@yopmail.com" and password "111111"
    Then login to the web site

  Scenario: Login with correct credentials.
    Given User in the home page.
    When User click on Sign in button
    And User input userid as "testuser2@yopmail.com" and password "222222"
    Then login to the web site
