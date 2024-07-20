package Trungtester.com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/LoginOnlyGherkin.feature",
        glue = {"Trungtester.com.Stepdefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-reports/TestRunnerLoginOnlyGherkin.html",
                "json:target/cucumber-reports/TestRunnerLoginOnlyGherkin.json"
        }
)
@Test
public class TestRunnerLoginOnlyGherkin extends AbstractTestNGCucumberTests {

}