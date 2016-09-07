package testFramework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class AboutUsPage extends WebConnector {

    @FindBy(css = "")
    private WebElement SampleElement;

        public boolean checkUserIsOnAboutUsPage() {
            waitForPageTitle("About Us | Free Credit Rating UK | Free Credit History Check");
            return driver.getCurrentUrl().contains("about-us");
        }
    }
