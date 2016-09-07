package testFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class SavingsCalculatorPage extends WebConnector {

    @FindBy(xpath = "//input[@value='250']")
    private WebElement CurrentScore;
    @FindBy(css = "#intro-section > div > div > div.grid-12.page-content-cont > iframe")
    private WebElement SavingsCalculatorIframe;
    @FindBy(css = "form:nth-of-type(1) > div > div:nth-of-type(3) > div > div:nth-of-type(1) > span.clearscore--summary.summary-value.ng-binding")
    private WebElement ActualCurrentScoreAverageInterestRate;
    @FindBy(css = "form:nth-of-type(1) > div > div:nth-of-type(3) > div > div:nth-of-type(2) > span.clearscore--summary.summary-value.ng-binding")
    private WebElement ActualCurrentScoreAnnualCost;
    @FindBy(css = "form:nth-of-type(1) > div > div:nth-of-type(3) > div > div:nth-of-type(3) > span.clearscore--summary.summary-value.ng-binding")
    private WebElement ActualCurrentScoreCreditCardsAvailable;
    @FindBy(xpath = "//input[@value='500']")
    private WebElement ScoreGoal;
    @FindBy(css = "form:nth-of-type(2) > div > div:nth-of-type(3) > div > div:nth-of-type(1) > span.clearscore--summary.summary-value.ng-binding")
    private WebElement ActualScoreGoalAverageInterestRate;
    @FindBy(css = "form:nth-of-type(2) > div > div:nth-of-type(3) > div > div:nth-of-type(2) > span.clearscore--summary.summary-value.ng-binding")
    private WebElement ActualScoreGoalAnnualCost;
    @FindBy(css = "form:nth-of-type(2) > div > div:nth-of-type(3) > div > div:nth-of-type(3) > span.clearscore--summary.summary-value.ng-binding")
    private WebElement ActualScoreGoalCreditCardsAvailable;
    @FindBy(css = ".total-saved.magictime.ng-binding")
    private WebElement ExpectedPotentialSavings;

    public void navigateToSavingsCalculatorPage() {
        driver.get(baseURL+"savings-calculator/");
    }

    public void updateCurrentScore(String currentScore) throws InterruptedException {
        driver.switchTo().frame(SavingsCalculatorIframe);
        System.out.println("The location of the element is " + CurrentScore.getLocation());
        int width = driver.findElement(By.cssSelector(".mdl-slider__container")).getSize().width;
        Actions ac = new Actions(driver);
        ac.dragAndDropBy(CurrentScore, 40, 339).build().perform();  //sendkeys does not work thats why actions class has been used to slide using co-ordinates
        driver.switchTo().defaultContent();
    }

    public String getActualCurrentScoreAverageInterestRate(String expectedCurrentScoreAverageInterestRate) throws InterruptedException {
        driver.switchTo().frame(SavingsCalculatorIframe);
        waitForTextInElement(ActualCurrentScoreAverageInterestRate, expectedCurrentScoreAverageInterestRate);
        String actualCurrentScoreAverageInterestRateText = ActualCurrentScoreAverageInterestRate.getText();
        driver.switchTo().defaultContent();
        return actualCurrentScoreAverageInterestRateText;
    }

    public String getActualCurrentScoreAnnualCost(String expectedCurrentScoreAnnualCost) {
        driver.switchTo().frame(SavingsCalculatorIframe);
        waitForTextInElement(ActualCurrentScoreAnnualCost, expectedCurrentScoreAnnualCost);
        String actualCurrentScoreAnnualCostText = ActualCurrentScoreAnnualCost.getText();
        driver.switchTo().defaultContent();
        return actualCurrentScoreAnnualCostText;
    }

    public String getActualCurrentScoreCreditCardsAvailable(String expectedCurrentScoreCreditCardsAvailable) {
        driver.switchTo().frame(SavingsCalculatorIframe);
        waitForTextInElement(ActualCurrentScoreCreditCardsAvailable, expectedCurrentScoreCreditCardsAvailable);
        String actualCurrentScoreCreditCardsAvailableText = ActualCurrentScoreCreditCardsAvailable.getText();
        driver.switchTo().defaultContent();
        return actualCurrentScoreCreditCardsAvailableText;
    }

    public void updateScoreGoal(String scoreGoal) throws InterruptedException {
        driver.switchTo().frame(SavingsCalculatorIframe);
        Actions ac = new Actions(driver);
        ac.dragAndDropBy(ScoreGoal, 50, 339).build().perform();  //sendkeys does not work thats why actions class has been used to slide using co-ordinates
        driver.switchTo().defaultContent();
    }

    public String getActualScoreGoalAverageInterestRate(String expectedScoreGoalAverageInterestRate) {
        driver.switchTo().frame(SavingsCalculatorIframe);
        waitForTextInElement(ActualScoreGoalAverageInterestRate, expectedScoreGoalAverageInterestRate);
        String actualScoreGoalAverageInterestRateText = ActualScoreGoalAverageInterestRate.getText();
        driver.switchTo().defaultContent();
        return actualScoreGoalAverageInterestRateText;
    }

    public String getActualScoreGoalAnnualCost(String expectedScoreGoalAnnualCost) {
        driver.switchTo().frame(SavingsCalculatorIframe);
        waitForTextInElement(ActualScoreGoalAnnualCost, expectedScoreGoalAnnualCost);
        String actualScoreGoalAnnualCostText = ActualScoreGoalAnnualCost.getText();
        driver.switchTo().defaultContent();
        return actualScoreGoalAnnualCostText;
    }

    public String getActualScoreGoalCreditCardsAvailable(String expectedScoreGoalCreditCardsAvailable) {
        driver.switchTo().frame(SavingsCalculatorIframe);
        waitForTextInElement(ActualScoreGoalCreditCardsAvailable, expectedScoreGoalCreditCardsAvailable);
        String actualScoreGoalCreditCardsAvailableText = ActualScoreGoalCreditCardsAvailable.getText();
        driver.switchTo().defaultContent();
        return actualScoreGoalCreditCardsAvailableText;
    }

    public String getActualPotentialSavings(String expectedPotentialSavings) {
        driver.switchTo().frame(SavingsCalculatorIframe);
        waitForTextInElement(ExpectedPotentialSavings, expectedPotentialSavings);
        String expectedPotentialSavingsText = ExpectedPotentialSavings.getText();
        driver.switchTo().defaultContent();
        return expectedPotentialSavingsText;
    }
}
