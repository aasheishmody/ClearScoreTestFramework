@navigation
Feature: Navigation - Home Page

  Scenario: Navigate to SignUp page
    Given I navigate to the Logged Out Home page
    When I click on the Get Your Free Credit Report Now button
    Then the SignUp page is displayed

  Scenario: Navigate to Know Your Score page
    Given I navigate to the Logged Out Home page
    When I click on the Know Your Score download link
    Then the Know Your Score page is displayed

  Scenario: Navigate to Improve Your Score page
    Given I navigate to the Logged Out Home page
    When I click on the Improve Your Score download link
    Then the Improve Your Score page is displayed

  Scenario: Navigate to FAQs page
    Given I navigate to the Logged Out Home page
    When I click on the Your Questions Answered link
    Then the FAQs page is displayed