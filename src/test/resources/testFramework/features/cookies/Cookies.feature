@cookies
Feature: Cookies

  As a Business
  I want to display the Cookies Notification
  So that I comply by the law

  Scenario: Cookies Notification is displayed
    Given I navigate to the Logged Out Home page
    Then the Cookies Notification is displayed

  Scenario: Cookies notification is correct
    Given I navigate to the Logged Out Home page
    Then the Cookies Notification is correct

  Scenario: Cookies Notification can be dismissed
    Given I navigate to the Logged Out Home page
    When I click the Cookies Notification button
    Then the Cookies Notification is not displayed

  Scenario: Cookies Notification does not reappear after being dismissed
    Given I navigate to the Logged Out Home page
    And I dismiss the Cookies Notification
    When I refresh the page
    Then the Cookies Notification is not displayed

