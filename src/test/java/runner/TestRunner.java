package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/test1",
        glue = {"amazon.stepDefinitions", "amazon.hooks"},
        dryRun = false,
        monochrome = true,
        tags = "@test",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber.json"
        }
)

public class TestRunner {

}
