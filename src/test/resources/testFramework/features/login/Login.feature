@login
Feature: Login

  As a existing user
  I want to log in
  So that I can check my updated credit report

  Scenario: Successful login
    Given I navigate to the Login page
    When I enter valid user credentials
    And I click on the Submit button
    Then I am logged in successfully

  Scenario: Unsuccessful login
    Given I navigate to the Login page
    When I enter invalid user credentials
    And I click on the Submit button
    Then I am not logged in

  Scenario: Unsuccessful Login notification can be dismissed
    Given I navigate to the Login page
    When I login with invalid user credentials
    And I dismiss the Unsuccessful Login notification
    Then the Unsuccessful Login notification is not displayed