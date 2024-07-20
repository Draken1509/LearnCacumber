package Trungtester.com.Stepdefinitions;

import Trungtester.com.common.BaseTest;
import Trungtester.com.constants.ConstantGlobal;
import Trungtester.com.driver.DriverManager;
import Trungtester.com.keywords.WebUI;
import Trungtester.com.ClassHandle.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Trungtester.com.ClassHandle.ExcelProductLoader.loadProductsFromExcel;
import static org.testng.AssertJUnit.assertEquals;

public class AddCatagory_Step {
    private WebDriver driver;
    @Given("user logged in as an admin")
    public void userLoggedInAsAnAdmin() {
        BaseTest.createDriver("edge");
        WebUI.openURL(ConstantGlobal.URL);
        WebUI.setText(By.xpath("//input[@id='email']"),ConstantGlobal.USERNAME);    //huutrung
        WebUI.setText(By.xpath("//input[@id='password']"),ConstantGlobal.PASSWORD); //123
        WebUI.clickElement(By.xpath("//input[@id='submit']"));
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }

    @Given("user on the category page")
    public void userOnTheCategoryPage() {
        WebUI.clickElement(By.xpath("//a[@id='admin_sp']"));
        String expectedLocation="http://localhost:8080/WebsiteBanSach-main/DoAnNhom02/admin_SanPham.php";
        String actualLocation= DriverManager.getDriver().getCurrentUrl();
        assertEquals(expectedLocation, actualLocation);
    }

    @When("User enter a series of product information using Excel files")
    public void UserenteraseriesofproductinformationusingExcelfiles() {
        //đọc File Excel
        WebUI.clickElement(By.xpath("//a[@id='addCatagory']"));
        String excelFilePath = "D://SeleniumMaven42022Parallel-main//datatest//insertBook.xlsx"; // Thay đổi đường dẫn tới tệp Excel của bạn
        List<Product> products = loadProductsFromExcel(excelFilePath);
        // In danh sách sản phẩm từ Excel
        for (Product product : products) {
            WebUI.clickElement(By.xpath("//option[@id='2']"));  // chu de
            WebUI.clickElement(By.xpath("//option[@id='12']")); // nha xuat ban
            WebUI.setText(By.xpath("//input[@id='mota']"),"Sách hay");
            WebUI.setText(By.xpath("//input[@id='tacgia']"),"Tờ rung");
            WebElement fileInput =  DriverManager.getDriver().findElement(By.xpath("//input[@id='anhbia']"));
            String imagePath = "D://SeleniumMaven42022Parallel-main//datatest//hinh1.png"; // Thay đổi đường dẫn đến hình ảnh của bạn
            fileInput.sendKeys(imagePath);
            try {
                Thread.sleep(300); // Chờ 2 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebUI.setText(By.xpath("//input[@id='tensach']"),product.getName());
            WebUI.setText(By.xpath("//input[@id='giaban']"),String.valueOf((int)product.getPrice()));
            WebUI.setText(By.xpath("//input[@id='soluong']"),String.valueOf((int)product.getQuantity()));
            try {
                Thread.sleep(300); // Chờ 2 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebUI.clickElement(By.xpath("//button[@id='them']"));
            DriverManager.getDriver().findElement(By.xpath(" //h4[@id='words_Error']")).isDisplayed();
        }
        DriverManager.quit();

    }

    @And("user click on the Save button")
    public void userClickOnTheSaveButton() {

    }

    @Then("user should see a error message")
    public void userShouldSeeAErrorMessage() {

    }



}
