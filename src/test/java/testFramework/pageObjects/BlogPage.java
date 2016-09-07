package testFramework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class BlogPage extends WebConnector {

    @FindBy(css = "")
    private WebElement SampleElement;

    public boolean checkUserIsOnBlogPage() {
        waitForPageTitle("Blog | Credit Scores UK | Free Credit Reports UK");
        return driver.getCurrentUrl().contains("blog");
    }
}