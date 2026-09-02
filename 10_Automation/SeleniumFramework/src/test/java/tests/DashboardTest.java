package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class DashboardTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    @Test(groups = {"smoke"})
    public void adminDashboardIsDisplayed() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin login did not land on the admin dashboard");
    }

    @Test(groups = {"smoke"})
    public void teacherDashboardIsDisplayed() {
        loginAsTeacher();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Teacher login did not land on the teacher dashboard");
    }

    @Test(groups = {"smoke"})
    public void studentDashboardIsDisplayed() {
        loginAsStudent();
        Assert.assertTrue(dashboardPage.isStudentDashboardDisplayed(),
                "Student login did not land on the student dashboard");
    }

    @Test(groups = {"smoke"})
    public void accountantDashboardIsDisplayed() {
        loginAsAccountant();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Accountant login did not land on the accountant dashboard");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
