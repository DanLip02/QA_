package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BuyCart extends HomePage{

    public BuyCart(WebDriver driver) {
        super(driver);
    }

    private static final By PLACE_ORDER = By.className("btn-success");
    private static final By NAME_ = By.id("name");
    private static final By COUNTRY_= By.id("country");
    private static final By CITY_ = By.id("city");
    private static final By CARD_NUMBER_ = By.id("card");
    private static final By CARD_MONTH_ = By.id("month");
    private static final By CARD_YEAR_ = By.id("year");
    private static final By PURCHASE_ = By.xpath("//button[@onclick = 'purchaseOrder()']");
    private static final By SUCCESSFUL_ = By.xpath("//div[@class = 'sa-icon sa-success animate']");

    public void clickPlaceOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PLACE_ORDER)).click();
    }

    public void fillInfoPurchaseWindow(String name, String country, String city, String card_number, String card_month,
                                       String card_year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(COUNTRY_)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_NUMBER_)).sendKeys(card_number);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_MONTH_)).sendKeys(card_month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CARD_YEAR_)).sendKeys(card_year);
        wait.until(ExpectedConditions.elementToBeClickable(PURCHASE_)).click();
    }

    public boolean checkSuccessfulOrderIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSFUL_)).isDisplayed();
    }
}