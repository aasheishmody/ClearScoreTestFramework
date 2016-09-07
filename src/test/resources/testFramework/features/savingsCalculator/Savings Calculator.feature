@savingsCalculator
Feature: Savings Calculator

  As a Customer
  I want to see the right figures from the Savings Calculator
  So that I can reduce the cost of my credit cards

  Scenario: Savings Calculator displays correct figures for current score
    Given I navigate to the Savings Calculator page
    When I update my current score to 400
    Then the savings calculator displays the following figures for current score
      | Average interest rate | Annual cost | Credit cards Available |
      | 31%                   | £721        | 95                     |

  Scenario: Savings Calculator displays correct figures for score goal
    Given I navigate to the Savings Calculator page
    When I update my score goal to 450
    Then the savings calculator displays the following figures for score goal
      | Average interest rate | Annual cost | Credit cards Available |
      | 25%                   | £581        | 168                    |

  Scenario: Savings Calculator displays correct potential savings
    Given I navigate to the Savings Calculator page
    When I update my current score to 400
    And I update my score goal to 450
    Then the potential savings are £140


    #Current Score and Score Goal figures are independent of each other. Hence the tests have been kept independent of each other.