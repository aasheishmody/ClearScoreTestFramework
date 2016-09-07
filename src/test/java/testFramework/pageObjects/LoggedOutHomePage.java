package testFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class LoggedOutHomePage extends WebConnector {

    @FindBy(css = "#primary-nav > div > div > nav > ul > li:nth-child(4) > a")
    private WebElement LoginButton;
    @FindBy(css = ".cs-cookie.show")
    private WebElement CookiesNotification;
    @FindBy(css = ".grid-12.grid-m-7>p")
    private WebElement CookiesNotificationMsg;
    @FindBy(css = ".btn-primary.float-right.accept-btn.theme-gamma")
    private WebElement CookiesNotificationButton;
    @FindBy(css = ".float-right.hide-s>a")
    private WebElement CookiesNotificationLink;
    @FindBy(id = "cta-btn-hero")
    private WebElement GetYourFreeCreditReportNowButton;
    @FindBy(xpath = "//a[@href='/link?tr=KM&e=site.download.know&s=&p=&redir=https%3A%2F%2Fstage.clearscore.com%2Fmedia%2Fknowyourscore.pdf&label=Understand&category=/']")
    private WebElement KnowYourScoreDownloadLink;
    @FindBy(xpath = "//a[@href='/link?tr=KM&e=site.download.improve&s=&p=&redir=https%3A%2F%2Fstage.clearscore.com%2Fmedia%2Fimproveyourscore.pdf&label=Understand&category=/']")
    private WebElement ImproveYourScoreDownloadLink;
    @FindBy(linkText = "Your questions answered")
    private WebElement YourQuestionsAnsweredLink;

    public void navigateToLoggedOutHomePage() {
        driver.get(baseURL);
    }

    public void clickLoginButton() {
        waitForElementToBeDisplayed(LoginButton);
        LoginButton.click();
    }

    public boolean checkCookiesNotificationIsDisplayed() {
        waitForElementToBeDisplayed(CookiesNotification);
        if (CookiesNotification.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCookiesNotificationIsCorrect() {
        if (checkCookiesNotificationMsgIsCorrect() && checkCookiesNotificationButtonTextIsCorrect() && checkCookiesNotificationLinkTextIsCorrect()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCookiesNotificationMsgIsCorrect() {
        String CookiesNotificationMsgText = CookiesNotificationMsg.getText();
        if (CookiesNotificationMsgText.equalsIgnoreCase("We use cookies to improve your experience.")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCookiesNotificationButtonTextIsCorrect() {
        String CookiesNotificationButtonText = CookiesNotificationButton.getText();
        if (CookiesNotificationButtonText.equalsIgnoreCase("No problem")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCookiesNotificationLinkTextIsCorrect() {
        String CookiesNotificationLinkText = CookiesNotificationLink.getText();
        if (CookiesNotificationLinkText.equalsIgnoreCase("More info")) {
            return true;
        } else {
            return false;
        }
    }

    public void clickCookiesNotificationButton() {
        CookiesNotificationButton.click();
    }

    public boolean checkCookiesNotificationIsNotDisplayed() {
        waitForElementToDisappear(CookiesNotification);
        if (isNotDisplayed(CookiesNotification)) {
            return true;
        } else {
            return false;
        }
    }

    public void clickGetYourFreeCreditReportNowButton() {
        GetYourFreeCreditReportNowButton.click();
    }

    public void clickKnowYourScoreDownloadLink() {
        KnowYourScoreDownloadLink.click();
    }

    public void clickImproveYourScoreDownloadLink() {
        ImproveYourScoreDownloadLink.click();
    }

    public void clickYourQuestionsAnsweredLink() {
        waitForElementToBeClickable(YourQuestionsAnsweredLink);
        YourQuestionsAnsweredLink.click();
    }
}