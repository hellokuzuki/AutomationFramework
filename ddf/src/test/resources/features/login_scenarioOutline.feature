Feature: Login to the davidjones.com.au using scenario outline
  As a user,
  I want to login to web site,
  so that I can check my account information.

  Scenario Outline: Login with correct credentials was scenrio outline.
    Given User in the home page.
    When User click on Sign in button
    And User input <email> and <password> using data table
    Then login to the web site

    Examples: 
      | email                   | password |
      | "testuser@yopmail.com"  | "111111" |
      | "testuser1@yopmail.com" | "111111" |
      | "testuser2@yopmail.com" | "222222" |
