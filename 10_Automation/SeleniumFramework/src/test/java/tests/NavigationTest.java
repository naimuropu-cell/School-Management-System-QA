package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class NavigationTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    @Test(groups = {"smoke"})
    public void navigateToStudentList() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        menuPage.goToStudents();
        Assert.assertTrue(driver.getTitle().contains("Student List"),
                "Expected Student List page, got title: " + driver.getTitle());
    }

    @Test(groups = {"smoke"})
    public void navigateToClasses() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        menuPage.goToClasses();
        Assert.assertTrue(driver.getTitle().contains("Class"),
                "Expected Class page, got title: " + driver.getTitle());
    }

    @Test(groups = {"smoke"})
    public void navigateToSections() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        menuPage.goToSections();
        Assert.assertTrue(driver.getTitle().contains("Section"),
                "Expected Section page, got title: " + driver.getTitle());
    }

    @Test(groups = {"smoke"})
    public void navigateToHomeworks() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        menuPage.goToHomeworks();
        Assert.assertTrue(driver.getTitle().contains("Add Homework"),
                "Expected Add Homework page, got title: " + driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
