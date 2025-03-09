package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends HomePage{

    public ProductPage(WebDriver driver) {
       super(driver);
    }
    private static final By HOME_LINK = By.className("nav-link");
    private static final By CART_ = By.id("cartur");
    private static final By ADD_ = By.xpath("//a[@onclick = 'addToCart(1)']");

    public void clickOnHome() {
        wait.until(ExpectedConditions.elementToBeClickable(HOME_LINK)).click();;
    }
    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_)).click();
    }

    public void clickShoppingCart(){
        wait.until(ExpectedConditions.elementToBeClickable(CART_)).click();
    }
}
