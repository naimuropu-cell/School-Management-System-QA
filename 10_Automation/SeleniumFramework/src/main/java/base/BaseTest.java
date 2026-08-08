package base;

import org.openqa.selenium.WebDriver;

import helpers.LoginHelper;
import pages.DashboardPage;
import pages.MenuPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    // Common Helpers
    protected LoginHelper loginHelper;

    // Common Pages
    protected DashboardPage dashboardPage;
    protected MenuPage menuPage;

    public void setUp() {

        driver = DriverFactory.getDriver();

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("loginUrl"));

        // Initialize Helpers
        loginHelper = new LoginHelper(driver);

        // Initialize Common Pages
        dashboardPage = new DashboardPage(driver);
        menuPage = new MenuPage(driver);
    }

    public void tearDown() {

        DriverFactory.quitDriver();

    }
}