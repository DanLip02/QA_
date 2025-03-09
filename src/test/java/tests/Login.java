package tests;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Login extends DemoblazeTest{
//    private static final Dotenv dotenv = Dotenv.load();
//    private static final String USERNAME = dotenv.get("USERNAME");
//    private static final String PASSWORD = dotenv.get("PASSWORD");

//    private static final String MESSAGE = String.format("Welcome %s", USERNAME);

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = String.format("Welcome %s", USERNAME);


    @Test
    public void login() {
        homePage.login(USERNAME,PASSWORD);
        Assert.assertEquals(homePage.getMESSAGE(), MESSAGE);
    }

    @Test
    public void logout() {
        Assert.assertTrue(homePage.test_log());
    }

}
