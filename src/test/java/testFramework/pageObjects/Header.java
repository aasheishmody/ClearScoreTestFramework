package testFramework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class Header extends WebConnector {

    @FindBy(xpath = "//header[@id='primary-nav']/div/div/nav/ul/li[1]/a[contains(text(),'About us')]")
    private WebElement AboutUsLink;
    @FindBy(xpath = "//header[@id='primary-nav']/div/div/nav/ul/li[2]/a[contains(text(),'Blog')]")
    private WebElement BlogLink;
    @FindBy(xpath = "//header[@id='primary-nav']/div/div/nav/ul/li[3]/a[contains(text(),'Help')]")
    private WebElement HelpLink;

    public void clickAboutUsLink() {
        AboutUsLink.click();
    }

    public void clickBlogLink() {
        BlogLink.click();
    }

    public void clickHelpLink() {
        HelpLink.click();
    }

}