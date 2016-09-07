package testFramework.pageObjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class RegistrationStepOnePage extends WebConnector {

    @FindBy(id = "full_name")
    private WebElement FullNameTextBox;
    @FindBy(id = "dob")
    private WebElement DateOfBirthTextBox;
    @FindBy(id = "password")
    private WebElement PasswordTextBox;
    @FindBy(css = "#registration > div.space-mtxl.space-ptxl.space-pbxs.space-mbxs.terms-border > label > strong")
    private WebElement YesIAgressCheckBox;
    @FindBy(id = "ui-register-account-submit2")
    private WebElement CreateNewAccountButton;

    public void enterFullName() {
        FullNameTextBox.sendKeys("Just Testing");
    }

    public void enterDateOfBirth() {
        DateOfBirthTextBox.sendKeys("03/05/1985");
    }

    public void enterPassword() {
        PasswordTextBox.sendKeys("K1rishna");
    }

    public void clickYesIAgressCheckBox() {
        YesIAgressCheckBox.click();
    }

    public void clickCreateNewAccountButton() throws InterruptedException {
        YesIAgressCheckBox.submit();
    }
}