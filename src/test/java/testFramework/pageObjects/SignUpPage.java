package testFramework.pageObjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class SignUpPage extends WebConnector {

    @FindBy(id = "email")    //change css path or locator
    private WebElement EmailTextBox;
    @FindBy(css = "#prospectForm > div.input-group.hide.show-m > button")    //change css path or locator
    private WebElement SubmitButton;

    public void navigateToSignUpPage() {
        driver.get(baseURL+"account/signup");
    }

    public void enterEmailAddress() {
        waitForElementToBePresent(EmailTextBox);
        int ran;
        ran = 100 + (int)(Math.random() * ((100000000 - 100) + 1));
        EmailTextBox.sendKeys("test"+ran+"@mailinator.com");
        System.out.println("The email address is "+"test"+ran+"@mailinator.com");
    }

    public void clickSubmitButton() throws InterruptedException {
        EmailTextBox.sendKeys(Keys.TAB);
        EmailTextBox.sendKeys(Keys.ENTER);
    }

    public boolean checkUserIsOnSignUpPage() {
        System.out.printf(driver.getCurrentUrl());
        return driver.getCurrentUrl().contains("signup");
    }
}