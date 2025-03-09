package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BuyCart;
import pages.HomePage;
import pages.ProductPage;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class DemoblazeTest {
    WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;
    ProductPage productPage;
    BuyCart buyCart;
    @BeforeClass
    public void setup() {

//        System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
//        WebDriverManager.chromedriver().setup();
        System.out.println("Гугл открыл: " );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");


        System.out.println("Гугл открыл_2: " );

        driver = new ChromeDriver();

        System.out.println("Гугл открыл_3: " );


        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.demoblaze.com/#");

        System.out.println("Страница загружена: " + driver.getTitle());


        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        buyCart = new BuyCart(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
