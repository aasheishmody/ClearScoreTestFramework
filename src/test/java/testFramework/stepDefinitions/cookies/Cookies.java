package testFramework.stepDefinitions.cookies;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testFramework.pageObjects.LoggedOutHomePage;
import testFramework.util.WebConnector;

public class Cookies extends WebConnector {

    public LoggedOutHomePage loggedOuthomePage;

    public Cookies() {
        loggedOuthomePage = PageFactory.initElements(driver, LoggedOutHomePage.class);
    }

    @Then("^the Cookies Notification is displayed$")
    public void the_cookies_notification_is_displayed() throws Throwable {
        Assert.assertTrue(loggedOuthomePage.checkCookiesNotificationIsDisplayed());
    }

    @And("^the Cookies Notification is correct$")
    public void the_cookies_notification_is_correct() throws Throwable {
        Assert.assertTrue(loggedOuthomePage.checkCookiesNotificationIsCorrect());
    }

    @When("^I click the Cookies Notification button$")
    public void I_click_the_No_Problem_button_on_the_cookies_notification() throws Throwable {
        loggedOuthomePage.clickCookiesNotificationButton();
    }

    @And("^I dismiss the Cookies Notification$")
    public void I_dismiss_the_cookies_notification() throws Throwable {
        loggedOuthomePage.clickCookiesNotificationButton();
        loggedOuthomePage.checkCookiesNotificationIsNotDisplayed();
    }

    @When("^I refresh the page$")
    public void I_refresh_the_page() throws Throwable {
        loggedOuthomePage.refreshPage();
    }

    @Then("^the Cookies Notification is not displayed$")
    public void the_cookies_notification_is_not_displayed() throws Throwable {
        Assert.assertTrue(loggedOuthomePage.checkCookiesNotificationIsNotDisplayed());
    }
}