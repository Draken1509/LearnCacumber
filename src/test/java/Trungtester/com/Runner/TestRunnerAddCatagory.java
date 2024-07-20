package Trungtester.com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Product/AddCatagory.feature",
        glue = {"Trungtester.com.Stepdefinitions"},
        plugin = {"pretty",
                 "html:target/cucumber-reports/AddCatagory_Test.html",
                "json:target/cucumber-reports/AddCatagory_Test.json"
        }
)
@Test
public class TestRunnerAddCatagory extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}