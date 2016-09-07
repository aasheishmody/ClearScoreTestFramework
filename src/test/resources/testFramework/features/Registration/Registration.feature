@registration
Feature: Registration

  As a new user
  I want to register
  So that I can check my credit report

  Scenario: Successful Registration
    Given I navigate to the SignUp page
    When I register as a valid user
    Then I have registered successfully