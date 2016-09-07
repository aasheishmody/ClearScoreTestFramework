package testFramework.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testFramework.util.WebConnector;

public class RegistrationStepThreePage extends WebConnector {

    @FindBy(css = "#identification > div > div:nth-child(1) > div > span:nth-child(1) > label")
    private WebElement FullTimeEmployedRadioButton;
    @FindBy(id = "bankName")
    private WebElement BankDropdown;
    @FindBy(id = "annualIncome")
    private WebElement AnnualIncomeTextBox;
    @FindBy(css = ".btn-registration.full-width-s")
    private WebElement NextButton;

    public void selectCurrentEmploymentStatus() {
        FullTimeEmployedRadioButton.click();
    }

    public void selectBank() {
        Select selectBankDropdown = new Select(BankDropdown);
        selectBankDropdown.selectByIndex(2);
    }

    public void enterAnnualIncome() {
        AnnualIncomeTextBox.sendKeys("87873");
    }

    public void clickNextButton() {
        AnnualIncomeTextBox.submit();
    }
}