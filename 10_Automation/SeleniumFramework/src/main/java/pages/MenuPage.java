package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;

public class MenuPage extends BasePage {

    private final String baseUrl = ConfigReader.getProperty("baseUrl");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private By dashboardMenu = By.cssSelector("a[href*='/dashboard']");

    public void goToDashboard() {
        click(dashboardMenu);
    }

    // Verified navigation destinations.
    // Direct-route navigation is used (rather than expanding sidebar dropdowns)
    // because these routes are confirmed stable and title-verifiable in the
    // current application.

    public void goToStudents() {
        driver.get(baseUrl + "/student-list");
    }

    public void goToClasses() {
        driver.get(baseUrl + "/class");
    }

    public void goToSections() {
        driver.get(baseUrl + "/section");
    }

    public void goToHomeworks() {
        driver.get(baseUrl + "/add-homeworks");
    }

}
