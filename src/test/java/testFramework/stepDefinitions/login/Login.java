package testFramework.stepDefinitions.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import testFramework.pageObjects.LoggedInHomePage;
import testFramework.pageObjects.LoggedOutHomePage;
import testFramework.pageObjects.LoginPage;
import testFramework.util.WebConnector;

public class Login extends WebConnector {
	
	public LoggedOutHomePage loggedOutHomePage;
    public LoggedInHomePage loggedInHomePage;
    public LoginPage loginpage;

    public Login(){
        loginpage = PageFactory.initElements(driver, LoginPage.class);
        loggedOutHomePage = PageFactory.initElements(driver, LoggedOutHomePage.class);
        loggedInHomePage = PageFactory.initElements(driver, LoggedInHomePage.class);
    }

    @Given("^I navigate to the Login page$")
    public void I_navigate_to_the_Login_page() throws Throwable {
        logger.info("Navigating to the Login page");
        loginpage.goToLoginPage();
        logger.info("Sucessfully navigated to the Login page");
    }

    @When("^I enter valid user credentials$")
    public void I_enter_valid_user_credentials() throws Throwable {
        loginpage.enterValidUserDetails();
    }

    @And("^I click on the Login button$")
    public void I_click_on_the_Login_button() throws Throwable {
        loggedOutHomePage.clickLoginButton();
    }

    @Then("^I am logged in successfully$")
    public void I_am_logged_in_successfully() throws Throwable {
        Assert.assertTrue(loggedInHomePage.checkUserIsLoggedin());
    }

    @Given("^I navigate to the Logged Out Home page$")
    public void I_navigate_to_the_Logged_Out_Home_page() throws Throwable {
        loggedOutHomePage.navigateToLoggedOutHomePage();
    }

    @Then("^the Login page is displayed$")
    public void I_should_be_on_the_Login_page() throws Throwable {
        Assert.assertTrue(loginpage.checkUserIsOnLoginPage());
    }

    @And("^I click on the Submit button$")
    public void I_click_on_the_Submit_button() throws Throwable {
        loginpage.clickSubmitButton();
    }

    @When("^I enter invalid user credentials$")
    public void I_enter_invalid_user_credentials() throws Throwable {
        loginpage.enterInvalidUserDetails();
    }

    @Then("^I am not logged in$")
    public void iAmNotLoggedIn() throws Throwable {
        Assert.assertTrue(loginpage.checkUserIsNotLoggedin());
    }

    @When("^I login with invalid user credentials$")
    public void I_login_with_invalid_user_credentials() throws Throwable {
        loginpage.loginWithInvalidUserCredentials();
    }

    @And("^I dismiss the Unsuccessful Login notification$")
    public void I_dismiss_the_unsuccessful_login_notification() throws Throwable {
        loginpage.dismissUnsuccessfulLoginNotification();
    }

    @Then("^the Unsuccessful Login notification is not displayed$")
    public void the_unsuccessful_login_notification_is_not_displayed() throws Throwable {
        Assert.assertTrue(!loginpage.checkUnsuccessfulLoginNotificationIsDisplayed());
    }

}
