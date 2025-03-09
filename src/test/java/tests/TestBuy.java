package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TestBuy extends DemoblazeTest {

    private static final String NAME_ = "TestBuy";
    private static final String COUNTRY_ = "TestBuy";
    private static final String CITY_ = "TestBuy";
    private static final String NUMBER_ = "1234567890";
    private static final String CARD_MONTH = "12";
    private static final String CARD_YEAR = "23";

    @Test
    public void testNavigationToProduct() {

        homePage.clickOnProduct("Samsung galaxy s6");
        productPage.clickAddToCartButton();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        productPage.clickShoppingCart();
        buyCart.clickPlaceOrderButton();

        boolean isCardValid = isCardNumberValid(NUMBER_) && isCardMonthValid(CARD_MONTH) && isCardYearValid(CARD_YEAR);
        Assert.assertTrue(isCardValid, "Card details are not valid");

        buyCart.fillInfoPurchaseWindow(NAME_, COUNTRY_, CITY_, NUMBER_, CARD_MONTH, CARD_YEAR);
        Assert.assertTrue(buyCart.checkSuccessfulOrderIcon());
    }

    private boolean isCardNumberValid(String cardNumber) {
        return cardNumber.length() == 10;
    }

    private boolean isCardMonthValid(String month) {
        try {
            int monthInt = Integer.parseInt(month);
            return monthInt >= 1 && monthInt <= 12;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isCardYearValid(String year) {
        try {
            int yearInt = Integer.parseInt(year);
            return yearInt < 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
