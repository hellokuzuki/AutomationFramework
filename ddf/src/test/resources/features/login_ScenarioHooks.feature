Feature: Login to the davidjones.com.au using scenario hooks
  As a user,
  I want to login to web site,
  so that I can check my account information.

  Scenario Outline: Login with correct credentials without hooks.
    Given User in the home page.
    When User click on Sign in button
    And User input <email> and <password> using data table
    Then login to the web site

    Examples: 
      | email                   | password |
      | "testuser@yopmail.com"  | "111111" |

  @WithHook1
  Scenario Outline: Login with correct credentials with hooks option1.
    Given User in the home page.
    When User click on Sign in button
    And User input <email> and <password> using data table
    Then login to the web site

    Examples: 
      | email                   | password |
      | "testuser@yopmail.com"  | "111111" |


  @WithHook2
  Scenario Outline: Login with correct credentials with hooks option2.
    Given User in the home page.
    When User click on Sign in button
    And User input <email> and <password> using data table
    Then login to the web site

    Examples: 
      | email                   | password |
      | "testuser@yopmail.com"  | "111111" |

