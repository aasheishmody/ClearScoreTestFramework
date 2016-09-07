package testFramework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class HelpPage extends WebConnector {

    @FindBy(css = "")
    private WebElement SampleElement;

    public boolean checkUserIsOnHelpPage() {
        waitForPageTitle("ClearScore Help Centre - Home");
        return driver.getCurrentUrl().contains("help");
    }
}