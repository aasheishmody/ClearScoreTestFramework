package testFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testFramework.util.WebConnector;

public class LoggedInHomePage extends WebConnector {

    @FindBy(css = "#primary-nav > div > div > nav > ul > li:nth-child(4) > a")
    private WebElement LoginButton;
    @FindBy(className = "overlay--videoplayer__video-element")
    private WebElement WelcomeVideo;
    @FindBy(id = "ui-app-header-myaccount")
    private WebElement MyAccountButton;

    public boolean checkUserRegistrationIsSuccessful() {
        waitForElementToBeDisplayed(WelcomeVideo);
        if (WelcomeVideo.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserIsLoggedin() {
        waitForElementToBePresent(MyAccountButton);
        if (MyAccountButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}