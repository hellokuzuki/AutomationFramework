Feature: Login to the davidjones.com.au
   As a user,
   I want to login to web site,
   so that I can check my account information.

  Scenario: Login with correct credentials.
    Given User in the home page.
    When User click on Sign in button
    And User input "testuser@yopmail.com" in Email input field
    And User input "111111"	in password input field
    And User click on Sign In button
    Then Page title should be "My Account"

  Scenario: Login with invalid credentials.
    Given User in the home page.
    When User click on Sign in button
    And User input "testuser@yopmail.com" in Email input field
    And User input "222222"	in password input field
    And User click on Sign In button
    Then Page title should be "Sign In"

  Scenario: Login without input Email address.
    Given User in the home page.
    When User click on Sign in button
    And User input "222222"	in password input field
    And User click on Sign In button
    Then Validation message should be "Type a email address in the Em775885
    ail field."

  Scenario: Login without input password.
    Given User in the home page.
    When User click on Sign in button
    And User input "testuser@yopmail.com" in Email input field
    And User click on Sign In button
    Then Validation message should be "Type a password in the Password field."
