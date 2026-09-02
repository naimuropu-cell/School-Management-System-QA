package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class AttendanceTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    // Ref: TS-ATT-001
    @Test(groups = {"smoke"})
    public void navigateToAttendance() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        attendancePage.goToAttendance();
        Assert.assertTrue(attendancePage.isAttendanceDisplayed(),
                "Expected Attendance page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-ATT-034
    @Test(groups = {"smoke"})
    public void attendanceSearchBoxDisplayed() {
        loginAsAdmin();
        attendancePage.goToAttendance();
        Assert.assertTrue(attendancePage.isAttendanceDisplayed(),
                "Expected Attendance page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(attendancePage.isSearchBoxDisplayed(),
                "Search box not displayed on the Attendance page");
    }

    // Ref: TS-ATT-035
    @Test(groups = {"smoke"})
    public void attendanceTableDisplayed() {
        loginAsAdmin();
        attendancePage.goToAttendance();
        Assert.assertTrue(attendancePage.isAttendanceDisplayed(),
                "Expected Attendance page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(attendancePage.isTableDisplayed(),
                "Attendance table not displayed");
        Assert.assertTrue(attendancePage.getRowCount() >= 0,
                "Expected a valid attendance row count, got: " + attendancePage.getRowCount());
    }

    // Ref: TS-ATT-036
    @Test(groups = {"smoke"})
    public void attendancePaginationDisplayed() {
        loginAsAdmin();
        attendancePage.goToAttendance();
        Assert.assertTrue(attendancePage.isAttendanceDisplayed(),
                "Expected Attendance page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(attendancePage.isPaginationDisplayed(),
                "Pagination not displayed on the Attendance page");
    }

    // Ref: TS-ATT-005
    @Test(groups = {"smoke"})
    public void attendanceAddButtonDisplayed() {
        loginAsAdmin();
        attendancePage.goToAttendance();
        Assert.assertTrue(attendancePage.isAttendanceDisplayed(),
                "Expected Attendance page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(attendancePage.isAddButtonDisplayed(),
                "Add button not visible on the Attendance page");
    }

    // Ref: TS-ATT-030
    @Test(groups = {"smoke"})
    public void navigateToAttendanceReport() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        attendancePage.goToAttendanceReport();
        Assert.assertTrue(attendancePage.isAttendanceReportDisplayed(),
                "Expected Attendance Report page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-ATT-031
    @Test(groups = {"smoke"})
    public void attendanceReportTableDisplayed() {
        loginAsAdmin();
        attendancePage.goToAttendanceReport();
        Assert.assertTrue(attendancePage.isAttendanceReportDisplayed(),
                "Expected Attendance Report page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(attendancePage.isTableDisplayed(),
                "Attendance Report table not displayed");
    }

    // Ref: TS-ATT-034
    @Test(groups = {"regression"})
    public void attendanceSearch() {
        loginAsAdmin();
        attendancePage.goToAttendance();
        Assert.assertTrue(attendancePage.isAttendanceDisplayed(),
                "Expected Attendance page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(attendancePage.isSearchBoxDisplayed(),
                "Search box not displayed on the Attendance page");

        attendancePage.search("a");

        Assert.assertTrue(attendancePage.isAttendanceDisplayed(),
                "URL changed unexpectedly after search: " + driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
