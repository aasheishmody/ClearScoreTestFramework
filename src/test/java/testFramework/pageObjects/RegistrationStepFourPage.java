package testFramework.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class RegistrationStepFourPage extends WebConnector {

    @FindBy(xpath = "//label[contains(text(),'LLOYDS BANK')]")
    private WebElement CurrentAccountProvider;
    @FindBy(xpath = "//label[contains(text(),'£ 500 to £ 549')]")
    private WebElement OverdraftLimit;
    @FindBy(xpath = "//label[contains(text(),'NATIONWIDE BUILDING SOCIETY')]")
    private WebElement MortgageProvider;
    @FindBy(xpath = "//div[4]/div/span[5]/label[contains(text(),'None of the Above')]")
    private WebElement FirstPaymentOnMortgage;

    public void clickCurrentAccountProvider() {
        CurrentAccountProvider.click();
    }

    public void clickOverdraftLimit() {
        OverdraftLimit.click();
    }

    public void clickMortgageProvider() {
        MortgageProvider.click();
    }

    public void clickFirstPaymentOnMortgage() {
        FirstPaymentOnMortgage.click();
    }

    public void clickNextButton() {
        FirstPaymentOnMortgage.submit();
    }
}