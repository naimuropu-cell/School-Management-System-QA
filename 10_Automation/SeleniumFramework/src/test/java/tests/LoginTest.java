package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void startBrowser() {

        setUp();

        loginPage = new LoginPage(driver);

    }

    @Test
    public void validAdminLogin() {

        loginPage.login(

                ConfigReader.getProperty("username"),

                ConfigReader.getProperty("password")

        );

    }

    @AfterMethod
    public void closeBrowser() {

        tearDown();

    }

}