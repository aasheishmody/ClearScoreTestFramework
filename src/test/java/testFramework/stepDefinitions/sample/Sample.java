package testFramework.stepDefinitions.sample;

import org.openqa.selenium.support.PageFactory;
import testFramework.pageObjects.LoggedInHomePage;
import testFramework.pageObjects.LoginPage;
import testFramework.util.WebConnector;

public class Sample extends WebConnector {

	public LoggedInHomePage homePage;
    public LoginPage loginpage;

    public Sample(){
        loginpage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, LoggedInHomePage.class);
    }
}
