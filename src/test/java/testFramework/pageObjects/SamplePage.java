package testFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testFramework.util.WebConnector;

public class SamplePage extends WebConnector {

    @FindBy(css = "")
    private WebElement SampleElement;

}