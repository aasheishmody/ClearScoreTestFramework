package testFramework.stepDefinitions.registration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import testFramework.pageObjects.*;
import testFramework.util.WebConnector;

public class Registration extends WebConnector {

	public SignUpPage signUpPage;
    public LetsGoPage letsGoPage;
    public RegistrationStepOnePage registrationStepOnePage;
    public RegistrationStepTwoPage registrationStepTwoPage;
    public RegistrationStepThreePage registrationStepThreePage;
    public RegistrationStepFourPage registrationStepFourPage;
    public LoginPage loginPage;
    public LoggedInHomePage homePage;

    public Registration(){
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        letsGoPage = PageFactory.initElements(driver, LetsGoPage.class);
        registrationStepOnePage = PageFactory.initElements(driver, RegistrationStepOnePage.class);
        registrationStepTwoPage = PageFactory.initElements(driver, RegistrationStepTwoPage.class);
        registrationStepThreePage = PageFactory.initElements(driver, RegistrationStepThreePage.class);
        registrationStepFourPage = PageFactory.initElements(driver, RegistrationStepFourPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, LoggedInHomePage.class);

    }

    @Given("^I navigate to the SignUp page$")
    public void i_navigate_to_the_SignUp_page() throws Throwable {
        signUpPage.navigateToSignUpPage();
    }

    @When("^I register as a valid user$")
    public void i_register_as_a_valid_user() throws Throwable {
        signUpPage.enterEmailAddress();
        signUpPage.clickSubmitButton();
        registrationStepOnePage.enterFullName();
        registrationStepOnePage.enterDateOfBirth();
        registrationStepOnePage.enterPassword();
        registrationStepOnePage.clickYesIAgressCheckBox();
        registrationStepOnePage.clickCreateNewAccountButton();
        registrationStepTwoPage.enterPostCode();
        registrationStepTwoPage.selectAddress();
        registrationStepTwoPage.clearHouseNumberTextBox();
        registrationStepTwoPage.enterHouseNUmber();
        registrationStepTwoPage.clickNextButton();
        registrationStepTwoPage.selectMonth();
        registrationStepTwoPage.selectYear();
        registrationStepTwoPage.clickNextButton();
        registrationStepTwoPage.selectResidentialStatus();
        registrationStepTwoPage.clickNextButton();
        registrationStepThreePage.selectCurrentEmploymentStatus();
        registrationStepThreePage.selectBank();
        registrationStepThreePage.enterAnnualIncome();
        registrationStepThreePage.clickNextButton();
        registrationStepFourPage.clickCurrentAccountProvider();
        registrationStepFourPage.clickOverdraftLimit();
        registrationStepFourPage.clickMortgageProvider();
        registrationStepFourPage.clickFirstPaymentOnMortgage();
        registrationStepFourPage.clickNextButton();
    }

    @Then("^I have registered successfully$")
    public void i_have_registered_successfully() throws Throwable {
        Assert.assertTrue(homePage.checkUserRegistrationIsSuccessful());
    }
}
