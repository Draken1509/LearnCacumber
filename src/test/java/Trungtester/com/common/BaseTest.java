package Trungtester.com.common;

import Trungtester.com.constants.ConstantGlobal;
import Trungtester.com.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

public class BaseTest  {
   // static WebDriver driver;

    @Parameters({"BROWSER"})
    public  static void createDriver(@Optional("chrome") String browserName) {
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);

    }
//    public static String getPageSourcee () {
//        String id;
//       id= driver.getPageSource();;
//       return id;
//    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    public static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        //WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static  WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        //WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(ConstantGlobal.HEADLESS);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}
