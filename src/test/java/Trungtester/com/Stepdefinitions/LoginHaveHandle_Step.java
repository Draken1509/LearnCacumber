package Trungtester.com.Stepdefinitions;

import Trungtester.com.common.BaseTest;
import Trungtester.com.constants.ConstantGlobal;
import Trungtester.com.driver.DriverManager;
import Trungtester.com.keywords.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

public class LoginHaveHandle_Step {
    private WebDriver driver;
    @Given("I Am On The Login Page")
    public void iAmOnTheLoginPage() {
        BaseTest.createDriver("edge");
        WebUI.openURL(ConstantGlobal.URL);
//        DriverManager.getDriver().get(ConstantGlobal.URL);

//      Cách thủ công-------------------------------------------------------------------
//      driver = new EdgeDriver();
//      driver.manage().window().maximize();
//      driver.get("http://localhost:8080/WebsiteBanSach-main/DoAnNhom02/DangNhap.php");
    }
    @When("I enter my username and password")
    public void iEnterMyUsernameAndPassword() {
//        DriverManager.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("huutrung");
//        DriverManager.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("123");
        WebUI.setText(By.xpath("//input[@id='email']"),ConstantGlobal.USERNAME); //huutrung
        WebUI.setText(By.xpath("//input[@id='password']"),ConstantGlobal.PASSWORD); //123
        //      Cách thủ công-------------------------------------------------------------------
        // driver.findElement(By.xpath("//input[@id='email']")).sendKeys("huutrung");
       // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
        try {
            Thread.sleep(500); // 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        DriverManager.getDriver().findElement(By.xpath("//input[@id='submit']")).click();
        //driver.findElement(By.id("submit")).click();
    }
    @Then("I should be taken to the Dashboard page")
    public void iShouldBeTakenToTheDashboardPage() {
        String expectedLocation="http://localhost:8080/WebsiteBanSach-main/DoAnNhom02/GiaoDien_Admin_Lan3.php";
        String actualLocation= DriverManager.getDriver().getCurrentUrl();
        assertEquals(expectedLocation, actualLocation);
        try {
            Thread.sleep(500); // 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverManager.quit();
    }

}
