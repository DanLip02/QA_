package tests;

import org.testng.annotations.Test;


public class ProductTest extends DemoblazeTest{

    @Test
    public void testNavigationToProduct() {

        homePage.clickOnProduct("Samsung galaxy s6");
        productPage.clickOnHome();

    }

    @Test
    public void testNavigationToProduct2() {
        homePage.clickOnProduct("Nokia lumia 1520");
    }

}
