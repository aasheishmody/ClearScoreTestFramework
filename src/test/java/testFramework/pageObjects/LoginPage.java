package testFramework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class LoginPage extends WebConnector {

    @FindBy(id = "email")
    private WebElement EmailTextBox;
    @FindBy(id = "password")
    private WebElement PasswordTextBox;
    @FindBy(id = "ui-public-login-submit")
    private WebElement SubmitButton;
    @FindBy(css = "body > div.primary-view > div > div > div.cs-notifications--public.cs-notifications.cs-notifications-info > div > div > div.cs-notification-item__content")
    private WebElement UnsuccessfulLoginNotification;
    @FindBy(css = "body > div.primary-view > div > div > div.cs-notifications--public.cs-notifications.cs-notifications-info > div > div > div.cs-notification-item__content > h4 > span > a")
    private WebElement DismissUnsuccessfulLoginNotification;

    String loginPageURL = properties.getProperty("baseURL") + "account/login";

    public void goToLoginPage() {
        System.out.println("The login page url is "+loginPageURL);
        driver.get(loginPageURL);
    }

    public void enterValidUserDetails() {
        waitForElementToBePresent(EmailTextBox);
        EmailTextBox.sendKeys("eqtestload-002@mailinator.com");
        PasswordTextBox.sendKeys("Test1234");
    }


    public boolean checkUserIsOnLoginPage() {
        waitForElementToBePresent(EmailTextBox);
        return EmailTextBox.isDisplayed();
    }

    public void clickSubmitButton() {
        SubmitButton.click();
    }

    public void enterInvalidUserDetails() {
        waitForElementToBePresent(EmailTextBox);
        int ran;
        ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
        EmailTextBox.sendKeys("test"+ran+"@mailinator.com");
        PasswordTextBox.sendKeys("Test123");
    }

    public boolean checkUserIsNotLoggedin() {
        waitForElementToBePresent(UnsuccessfulLoginNotification);
        if (UnsuccessfulLoginNotification.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void loginWithInvalidUserCredentials() {
        enterInvalidUserDetails();
        clickSubmitButton();
    }

    public void dismissUnsuccessfulLoginNotification() {
        waitForElementToBePresent(UnsuccessfulLoginNotification);
        DismissUnsuccessfulLoginNotification.click();
    }

    public boolean checkUnsuccessfulLoginNotificationIsDisplayed() {
        waitForElementToDisappear(UnsuccessfulLoginNotification);
        return elementIsDisplayedOrNot(UnsuccessfulLoginNotification);
    }
}