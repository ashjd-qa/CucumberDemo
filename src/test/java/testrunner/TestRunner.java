package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions"},
    dryRun = false,// //to check mapping is proper between feature file and step definition file
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)

public class TestRunner {

}
