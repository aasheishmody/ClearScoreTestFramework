@navigation
Feature: Navigation - Header

  Scenario: Navigate to Login page
    Given I navigate to the Logged Out Home page
    When I click on the Login button
    Then the Login page is displayed

  Scenario: Navigate to About Us page
    Given I navigate to the Logged Out Home page
    When I click on the About Us link
    Then the About Us page is displayed

  Scenario: Navigate to Blog page
    Given I navigate to the Logged Out Home page
    When I click on the Blog link
    Then the Blog page is displayed

  Scenario: Navigate to Help page
    Given I navigate to the Logged Out Home page
    When I click on the Help link
    Then the Help page is displayed