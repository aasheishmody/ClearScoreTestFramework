package testFramework.testsRunner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import testFramework.util.WebConnector;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-report2.json"},
        features = {"src/test/resources/testFramework/features"},
        glue = {"testFramework.stepDefinitions"},
        tags = {"@navigation"},
        monochrome = true
)

public class RunSecondTestAT extends WebConnector {

    @AfterClass
    public static void closeBrowser() throws IOException, InterruptedException {
        driver.quit();
    }
}



