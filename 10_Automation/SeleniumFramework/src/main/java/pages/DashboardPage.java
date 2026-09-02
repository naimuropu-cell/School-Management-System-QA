package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private static final String ADMIN_DASHBOARD_ROUTE = "/admin-dashboard";
    private static final String STUDENT_DASHBOARD_ROUTE = "/student-dashboard";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAdminDashboardDisplayed() {
        return getCurrentUrl().contains(ADMIN_DASHBOARD_ROUTE);
    }

    public boolean isStudentDashboardDisplayed() {
        return getCurrentUrl().contains(STUDENT_DASHBOARD_ROUTE);
    }

    public boolean isDashboardDisplayed() {
        return isAdminDashboardDisplayed() || isStudentDashboardDisplayed();
    }

}
