package testFramework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class FaqPage extends WebConnector {

    @FindBy(css = "")
    private WebElement SampleElement;

    public boolean checkUserIsOnFaqPage() {
        return driver.getCurrentUrl().contains("faqs");
    }
}