Feature: Log In
  I want to use this template for my feature file

  Scenario: Successful Login
    Given user is on the home page
    And user navigates to the login page
    When user enters username and password
    And user clicks on login button
    Then MyAccount dashboard is displayed

  Scenario Outline: Failed Login
    Given user is on the home page
    And user navigates to the login page
    When user enters incorrect username and password
    And user clicks on login button
    Then invalid login message is displayed 

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
