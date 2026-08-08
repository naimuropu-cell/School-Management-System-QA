package pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {

        String currentUrl = driver.getCurrentUrl();

        return currentUrl.contains("/admin-dashboard");

    }

}