package testFramework.testsRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import testFramework.util.WebConnector;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-report3.json"},
        features = {"src/test/resources/testFramework/features"},
        glue = {"testFramework.stepDefinitions"},
        tags = {"@registration"},
        monochrome = true
)

public class RunThirdTestAT extends WebConnector {

    @AfterClass
    public static void closeBrowser() throws IOException, InterruptedException {
        driver.quit();
    }
}





