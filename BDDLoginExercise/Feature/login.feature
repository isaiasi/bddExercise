#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
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
    When user enters incorrect <userid> and <password>
    And user clicks on login button    
    Then <warning> message is displayed 

    Examples: 
      | userid      | password   | warning                           |
      | Test        | Test        | Incorrect credentials. Try again! |
#      | Tset        | 123        | Incorrect credentials. Try again! |
#      | Tset        | !23        | Incorrect credentials. Try again! |
#      | Test        |            | Please enter password.            |
#      |             | 123        | Please enter username.            |
#      |             |            | Please enter your credentials.    |
