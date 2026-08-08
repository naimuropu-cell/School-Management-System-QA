package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);

    }

    // Locators

    private By email = By.name("email");

    private By password = By.name("password");

    private By loginButton = By.cssSelector("input[type='submit']");

    private By forgotPassword = By.id("forget");

    // Methods

    public void enterEmail(String userEmail) {

        type(email, userEmail);

    }

    public void enterPassword(String userPassword) {

        type(password, userPassword);

    }

    public void clickLogin() {

        click(loginButton);

    }

    public void login(String userEmail, String userPassword) {

        enterEmail(userEmail);

        enterPassword(userPassword);

        clickLogin();

    }

}