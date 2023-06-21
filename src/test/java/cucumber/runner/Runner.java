package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/cucumber/features/Scenario1.feature"},
        glue = {"cucumber/stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
