package testFramework.stepDefinitions.savingsCalculator;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testFramework.pageObjects.SavingsCalculatorPage;
import testFramework.util.WebConnector;

import java.util.List;
import java.util.Map;

public class SavingsCalculator extends WebConnector {

    public SavingsCalculatorPage savingsCalculatorPage;

    public SavingsCalculator() {
        savingsCalculatorPage = PageFactory.initElements(driver, SavingsCalculatorPage.class);
    }

    @Given("^I navigate to the Savings Calculator page$")
    public void I_navigate_to_the_Savings_Calculator_page() throws Throwable {
        savingsCalculatorPage.navigateToSavingsCalculatorPage();
    }

    @When("^I update my current score to (\\d+)$")
    public void I_update_my_current_score_to(String currentScore) throws Throwable {
        savingsCalculatorPage.updateCurrentScore(currentScore);
    }

    @Then("^the savings calculator displays the following figures for current score$")
    public void the_savings_calculator_displays_the_following_figures_for_current_score(DataTable table) throws Throwable {
        List<Map<String, String>> aux = table.asMaps(String.class, String.class);
        String expectedCurrentScoreAverageInterestRate = null;
        String expectedCurrentScoreAnnualCost = null;
        String expectedCurrentScoreCreditCardsAvailable = null;

        for (int i = 0; i < aux.size(); i++) {
            Map<String, String> currentScoreFigures = aux.get(i);
            expectedCurrentScoreAverageInterestRate = currentScoreFigures.get("Average interest rate");
            expectedCurrentScoreAnnualCost = currentScoreFigures.get("Annual cost");
            expectedCurrentScoreCreditCardsAvailable = currentScoreFigures.get("Credit cards Available");
        }

        String actualCurrentScoreAverageInterestRate = savingsCalculatorPage.getActualCurrentScoreAverageInterestRate(expectedCurrentScoreAverageInterestRate);
        String actualCurrentScoreAnnualCost = savingsCalculatorPage.getActualCurrentScoreAnnualCost(expectedCurrentScoreAnnualCost);
        String actualCurrentScoreCreditCardsAvailable = savingsCalculatorPage.getActualCurrentScoreCreditCardsAvailable(expectedCurrentScoreCreditCardsAvailable);

        Assert.assertEquals(expectedCurrentScoreAverageInterestRate, actualCurrentScoreAverageInterestRate);
        Assert.assertEquals(expectedCurrentScoreAnnualCost, actualCurrentScoreAnnualCost);
        Assert.assertEquals(expectedCurrentScoreCreditCardsAvailable, actualCurrentScoreCreditCardsAvailable);

    }

    @When("^I update my score goal to (\\d+)$")
    public void I_update_my_score_goal_to(String scoreGoal) throws Throwable {
        savingsCalculatorPage.updateScoreGoal(scoreGoal);
    }

    @Then("^the savings calculator displays the following figures for score goal$")
    public void the_savings_calculator_displays_the_following_figures_for_score_goal(DataTable table) throws Throwable {
        List<Map<String, String>> aux = table.asMaps(String.class, String.class);
        String expectedScoreGoalAverageInterestRate = null;
        String expectedScoreGoalAnnualCost = null;
        String expectedScoreGoalCreditCardsAvailable = null;

        for (int i = 0; i < aux.size(); i++) {
            Map<String, String> currentScoreFigures = aux.get(i);
            expectedScoreGoalAverageInterestRate = currentScoreFigures.get("Average interest rate");
            expectedScoreGoalAnnualCost = currentScoreFigures.get("Annual cost");
            expectedScoreGoalCreditCardsAvailable = currentScoreFigures.get("Credit cards Available");
        }

        String actualScoreGoalAverageInterestRate = savingsCalculatorPage.getActualScoreGoalAverageInterestRate(expectedScoreGoalAverageInterestRate);
        String actualScoreGoalAnnualCost = savingsCalculatorPage.getActualScoreGoalAnnualCost(expectedScoreGoalAnnualCost);
        String actualScoreGoalCreditCardsAvailable = savingsCalculatorPage.getActualScoreGoalCreditCardsAvailable(expectedScoreGoalCreditCardsAvailable);

        Assert.assertEquals(expectedScoreGoalAverageInterestRate, actualScoreGoalAverageInterestRate);
        Assert.assertEquals(expectedScoreGoalAnnualCost, actualScoreGoalAnnualCost);
        Assert.assertEquals(expectedScoreGoalCreditCardsAvailable, actualScoreGoalCreditCardsAvailable);
    }

    @And("^the potential savings are £(\\d+)$")
    public void the_potential_savings_are_£_(String expectedPotentialSavings) throws Throwable {
        String actualPotentialSavings = savingsCalculatorPage.getActualPotentialSavings(expectedPotentialSavings);
        Assert.assertTrue(actualPotentialSavings.contains(expectedPotentialSavings));
    }
}
