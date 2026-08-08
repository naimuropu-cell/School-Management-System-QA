package helpers;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import utilities.ConfigReader;

public class LoginHelper {

    private LoginPage loginPage;

    public LoginHelper(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void loginAsAdmin() {
        loginPage.login(
                ConfigReader.getProperty("adminUsername"),
                ConfigReader.getProperty("adminPassword"));
    }

    public void loginAsTeacher() {
        loginPage.login(
                ConfigReader.getProperty("teacherUsername"),
                ConfigReader.getProperty("teacherPassword"));
    }

    public void loginAsStudent() {
        loginPage.login(
                ConfigReader.getProperty("studentUsername"),
                ConfigReader.getProperty("studentPassword"));
    }

    public void loginAsAccountant() {
        loginPage.login(
                ConfigReader.getProperty("accountantUsername"),
                ConfigReader.getProperty("accountantPassword"));
    }

}