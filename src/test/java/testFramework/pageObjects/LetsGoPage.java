package testFramework.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class LetsGoPage extends WebConnector {

    @FindBy(css = "#view-intro > div > div > a")    //change css path or locator
    private WebElement LetsGoButton;

    public void clickLetsGoButton() {
        if(LetsGoButton.isDisplayed()){
            LetsGoButton.click();
        }
    }
}