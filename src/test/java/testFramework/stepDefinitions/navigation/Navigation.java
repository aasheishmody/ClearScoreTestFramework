package testFramework.stepDefinitions.navigation;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import testFramework.pageObjects.*;
import testFramework.util.WebConnector;

public class Navigation extends WebConnector {

    public LoggedOutHomePage loggedOuthomePage;
    public Header header;
    public AboutUsPage aboutUsPage;
    public BlogPage blogPage;
    public HelpPage helpPage;
    public SignUpPage signUpPage;
    public FaqPage faqPage;

    public Navigation() {
        loggedOuthomePage = PageFactory.initElements(driver, LoggedOutHomePage.class);
        header = PageFactory.initElements(driver, Header.class);
        aboutUsPage = PageFactory.initElements(driver, AboutUsPage.class);
        blogPage = PageFactory.initElements(driver, BlogPage.class);
        helpPage = PageFactory.initElements(driver, HelpPage.class);
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        faqPage = PageFactory.initElements(driver, FaqPage.class);
    }

    @When("^I click on the About Us link$")
    public void iClickOnTheAboutUsLink() throws Throwable {
        header.clickAboutUsLink();
    }

    @Then("^the About Us page is displayed$")
    public void theAboutUsPageIsDisplayed() throws Throwable {
        Assert.assertTrue(aboutUsPage.checkUserIsOnAboutUsPage());
    }

    @When("^I click on the Blog link$")
    public void iClickOnTheBlogLink() throws Throwable {
        header.clickBlogLink();
    }

    @Then("^the Blog page is displayed$")
    public void theBlogPageIsDisplayed() throws Throwable {
        Assert.assertTrue(blogPage.checkUserIsOnBlogPage());
    }

    @When("^I click on the Help link$")
    public void iClickOnTheHelpLink() throws Throwable {
        header.clickHelpLink();
    }

    @Then("^the Help page is displayed$")
    public void theHelpPageIsDisplayed() throws Throwable {
        Assert.assertTrue(helpPage.checkUserIsOnHelpPage());
    }

    @When("^I click on the Get Your Free Credit Report Now button$")
    public void iClickOnTheGetYourFreeCreditReportNowButton() throws Throwable {
        loggedOuthomePage.clickGetYourFreeCreditReportNowButton();
    }

    @Then("^the SignUp page is displayed$")
    public void theSignUpPageIsDisplayed() throws Throwable {
        Assert.assertTrue(signUpPage.checkUserIsOnSignUpPage());
    }

    @When("^I click on the Know Your Score download link$")
    public void iClickOnTheKnowYourScoreDownloadLink() throws Throwable {
        loggedOuthomePage.clickKnowYourScoreDownloadLink();
    }

    @Then("^the Know Your Score page is displayed$")
    public void theKnowYourScorePageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on the Improve Your Score download link$")
    public void iClickOnTheImproveYourScoreDownloadLink() throws Throwable {
        loggedOuthomePage.clickImproveYourScoreDownloadLink();
    }

    @Then("^the Improve Your Score page is displayed$")
    public void theImproveYourScorePageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on the Your Questions Answered link$")
    public void iClickOnTheYourQuestionsAnsweredLink() throws Throwable {
        loggedOuthomePage.clickYourQuestionsAnsweredLink();
    }

    @Then("^the FAQs page is displayed$")
    public void theFAQsPageIsDisplayed() throws Throwable {
        Assert.assertTrue(faqPage.checkUserIsOnFaqPage());
    }
}