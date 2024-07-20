package Trungtester.com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/LoginWithDataTable.feature",
        glue = {"Trungtester.com.Stepdefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-reports/TestRunnerLoginWithDataTable.html",
                "json:target/cucumber-reports/TestRunnerLoginWithDataTable.json"
        }
)
@Test
public class TestRunnerLoginWithDataTable extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}