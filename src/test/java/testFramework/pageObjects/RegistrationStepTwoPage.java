package testFramework.pageObjects;

import com.thoughtworks.selenium.webdriven.commands.KeyPressNative;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testFramework.util.WebConnector;

public class RegistrationStepTwoPage extends WebConnector {

    @FindBy(id = "postCode")
    private WebElement PostCodeTextBox;
    @FindBy(css = "#selectedAddressId > option:nth-child(2)")
    private WebElement FirstAddressInAddressDropdown;
    @FindBy(id = "buildingNumber")
    private WebElement HouseNumberTextBox;
    @FindBy(css = ".btn-registration.full-width-s")
    private WebElement NextButton;
    @FindBy(id = "startMonth")
    private WebElement MonthDropdown;
    @FindBy(id = "startYear")
    private WebElement YearDropdown;
    @FindBy(css = "#identification > div > div.input-group.clearfix > span:nth-child(2) > label")
    private WebElement HomeOwnerRadioButton;

    public void enterPostCode() throws InterruptedException {
        PostCodeTextBox.click();
        PostCodeTextBox.sendKeys("CB62AG");
    }

    public void selectAddress() {
        waitForElementToBeClickable(FirstAddressInAddressDropdown);
        FirstAddressInAddressDropdown.click();
    }

    public void clearHouseNumberTextBox() {
        HouseNumberTextBox.clear();
    }

    public void enterHouseNUmber() {
        HouseNumberTextBox.sendKeys("275");
    }

    public void clickNextButton() {
        waitForButtonToEnable(NextButton);
        NextButton.click();
    }

    public void selectMonth() {
        Select selectMonthDropdown = new Select(MonthDropdown);
        selectMonthDropdown.selectByIndex(2);
    }

    public void selectYear() {
        Select selectYearDropdown = new Select(YearDropdown);
        selectYearDropdown.selectByIndex(10);
    }

    public void selectResidentialStatus() {
        HomeOwnerRadioButton.click();
    }
}