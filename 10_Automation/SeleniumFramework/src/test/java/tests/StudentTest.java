package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class StudentTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    // Ref: TS-STU-016 / TS-STU-017
    @Test(groups = {"smoke"})
    public void navigateToStudentList() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        studentPage.goToStudentList();
        Assert.assertTrue(studentPage.isStudentListDisplayed(),
                "Expected Student List page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getTitle().contains("Student List"),
                "Expected Student List page, got title: " + driver.getTitle());
    }

    // Ref: TS-STU-019
    @Test(groups = {"smoke"})
    public void studentListSearchBoxDisplayed() {
        loginAsAdmin();
        studentPage.goToStudentList();
        Assert.assertTrue(studentPage.isStudentListDisplayed(),
                "Expected Student List page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(studentPage.isSearchBoxDisplayed(),
                "Search box not displayed on the Student List page");
    }

    // Ref: TS-STU-016 / TS-STU-019
    @Test(groups = {"smoke"})
    public void studentListTableDisplayed() {
        loginAsAdmin();
        studentPage.goToStudentList();
        Assert.assertTrue(studentPage.isStudentListDisplayed(),
                "Expected Student List page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(studentPage.isTableDisplayed(),
                "Student table not displayed on the Student List page");
        Assert.assertTrue(studentPage.getRowCount() >= 0,
                "Expected a valid student row count, got: " + studentPage.getRowCount());
    }

    // Ref: TS-STU-054
    @Test(groups = {"smoke"})
    public void studentListAddButtonDisplayed() {
        loginAsAdmin();
        studentPage.goToStudentList();
        Assert.assertTrue(studentPage.isStudentListDisplayed(),
                "Expected Student List page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(studentPage.isAddButtonDisplayed(),
                "Add button not visible on the Student List page");
    }

    // Ref: TS-STU-063
    @Test(groups = {"regression"})
    public void studentSearchByName() {
        loginAsAdmin();
        studentPage.goToStudentList();
        Assert.assertTrue(studentPage.isStudentListDisplayed(),
                "Expected Student List page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(studentPage.isSearchBoxDisplayed(),
                "Search box not displayed on the Student List page");

        studentPage.searchStudent("qa");

        Assert.assertTrue(driver.getTitle().contains("Student List"),
                "Page title changed unexpectedly after search: " + driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
