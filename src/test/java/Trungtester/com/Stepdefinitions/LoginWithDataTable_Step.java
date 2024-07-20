package Trungtester.com.Stepdefinitions;

import Trungtester.com.common.BaseTest;
import Trungtester.com.constants.ConstantGlobal;
import Trungtester.com.driver.DriverManager;
import Trungtester.com.keywords.WebUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class LoginWithDataTable_Step {
    private WebDriver driver;
    @Given("user on the login page")
    public void userOnTheLoginPage() {
        BaseTest.createDriver("edge");
        WebUI.openURL(ConstantGlobal.URL);
    }
    @When("user enter valid credentials to login")
    public void userEnterValidCredentialsToLogin(DataTable dataTable) {
        List <Map< String, String >> items = dataTable.asMaps();
        for (Map < String, String > item: items) {
            String email = item.get("email");
            String password = item.get("password");

            WebUI.setText(By.xpath("//input[@id='email']"),email);
            WebUI.setText(By.xpath("//input[@id='password']"),password);
            try {
                Thread.sleep(300); // 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            DriverManager.getDriver().findElement(By.xpath("//input[@id='submit']")).click();
            DriverManager.getDriver().findElement(By.xpath("//div[@id='message']")).isDisplayed();
            String expectedLocation="http://localhost:8080/WebsiteBanSach-main/DoAnNhom02/DangNhap.php";
            String actualLocation= DriverManager.getDriver().getCurrentUrl();
            assertEquals(expectedLocation, actualLocation);
        }
        DriverManager.quit();
    }
//    @When("user enter an invalid username or password")
//    public void userEnterAnInvalidUsernameOrPassword() {
////        WebUI.setText(By.xpath("//input[@id='email']"),ConstantGlobal.USERNAME); //huutrung
////        WebUI.setText(By.xpath("//input[@id='password']"),ConstantGlobal.PASSWORD); //123
////        //      Cách thủ công-------------------------------------------------------------------
////        // driver.findElement(By.xpath("//input[@id='email']")).sendKeys("huutrung");
////        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
////        try {
////            Thread.sleep(500); // 2 giây
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
    @And("click on the login button")
    public void clickOnTheLoginButton() {

    }
    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() {

    }
    @And("stay on the login page")
    public void stayOnTheLoginPage() {

    }


}
