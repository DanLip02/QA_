package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    private static final String OPEN_PRODUCT_PAGE_PATTERN = "//a[text()='%s']/ancestor::h4[@class='card-title']";
    private static final By LOGIN_ = By.id("login2");
    private static final By USERNAME_= By.id("loginusername");
    private static final By PASSWORD_ = By.id("loginpassword");
    private static final By LOGIN_MODAL_ = By.xpath("//button[@onclick = 'logIn()']");
    private static final By WELCOME_MESSAGE = By.id("nameofuser");
    private static final By LOGOUT_ = By.id("logout2");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_MODAL_)).click();
    }

    public void clickOnProduct(String product) {
        By openProductPage = By.xpath(String.format(OPEN_PRODUCT_PAGE_PATTERN, product));
        wait.until(ExpectedConditions.elementToBeClickable(openProductPage)).click();;
    }

    public String getMESSAGE() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(WELCOME_MESSAGE)).getText();
    }

    public boolean test_log() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_)).click();

        String loginText = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_)).getText();
        return loginText.equals("Log in");
    }

}
