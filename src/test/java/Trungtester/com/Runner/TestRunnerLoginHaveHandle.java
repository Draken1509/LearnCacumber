package Trungtester.com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/LoginHaveHandle.feature",
        glue = {"Trungtester.com.Stepdefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-reports/LoginHaveHandle_Test.html",
                "json:target/cucumber-reports/LoginHaveHandle_Test.json",

        }
)
@Test
public class TestRunnerLoginHaveHandle extends AbstractTestNGCucumberTests {

}