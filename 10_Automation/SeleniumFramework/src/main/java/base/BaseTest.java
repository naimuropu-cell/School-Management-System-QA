package base;

import org.openqa.selenium.WebDriver;

import helpers.LoginHelper;
import pages.AcademicsPage;
import pages.AttendancePage;
import pages.DashboardPage;
import pages.FeePage;
import pages.MenuPage;
import pages.StudentPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    // Common Helpers
    protected LoginHelper loginHelper;

    // Common Pages
    protected DashboardPage dashboardPage;
    protected MenuPage menuPage;
    protected StudentPage studentPage;
    protected AcademicsPage academicsPage;
    protected AttendancePage attendancePage;
    protected FeePage feePage;

    public void setUp() {

        driver = DriverFactory.getDriver();

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("loginUrl"));

        // Initialize Helpers
        loginHelper = new LoginHelper(driver);

        // Initialize Common Pages
        dashboardPage = new DashboardPage(driver);
        menuPage = new MenuPage(driver);
        studentPage = new StudentPage(driver);
        academicsPage = new AcademicsPage(driver);
        attendancePage = new AttendancePage(driver);
        feePage = new FeePage(driver);
    }

    public void tearDown() {

        DriverFactory.quitDriver();

    }

    // Reusable role-based login methods (delegate to LoginHelper).
    // Future tests can call loginAsAdmin()/loginAsTeacher()/loginAsStudent()
    // or loginAsAccountant() directly with no extra setup.

    protected void loginAsAdmin() {
        loginHelper.loginAsAdmin();
    }

    protected void loginAsTeacher() {
        loginHelper.loginAsTeacher();
    }

    protected void loginAsStudent() {
        loginHelper.loginAsStudent();
    }

    protected void loginAsAccountant() {
        loginHelper.loginAsAccountant();
    }

}