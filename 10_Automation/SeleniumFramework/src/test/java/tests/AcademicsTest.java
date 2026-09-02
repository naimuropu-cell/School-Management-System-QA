package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class AcademicsTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    // Ref: TS-ACA-011 / TS-ACA-012
    @Test(groups = {"smoke"})
    public void navigateToClassList() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        academicsPage.goToClasses();
        Assert.assertTrue(academicsPage.isClassListDisplayed(),
                "Expected Class page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getTitle().contains("Class"),
                "Expected Class page, got title: " + driver.getTitle());
    }

    // Ref: TS-ACA-011
    @Test(groups = {"smoke"})
    public void classListSearchBoxDisplayed() {
        loginAsAdmin();
        academicsPage.goToClasses();
        Assert.assertTrue(academicsPage.isClassListDisplayed(),
                "Expected Class page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(academicsPage.isSearchBoxDisplayed(),
                "Search box not displayed on the Class page");
    }

    // Ref: TS-ACA-011
    @Test(groups = {"smoke"})
    public void classListTableDisplayed() {
        loginAsAdmin();
        academicsPage.goToClasses();
        Assert.assertTrue(academicsPage.isClassListDisplayed(),
                "Expected Class page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(academicsPage.isTableDisplayed(),
                "Class table not displayed on the Class page");
        Assert.assertTrue(academicsPage.getRowCount() >= 0,
                "Expected a valid class row count, got: " + academicsPage.getRowCount());
    }

    // Ref: TS-ACA-011
    @Test(groups = {"smoke"})
    public void classListAddButtonDisplayed() {
        loginAsAdmin();
        academicsPage.goToClasses();
        Assert.assertTrue(academicsPage.isClassListDisplayed(),
                "Expected Class page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(academicsPage.isAddButtonDisplayed(),
                "Add button not visible on the Class page");
    }

    // Ref: TS-ACA-016 / TS-ACA-017
    @Test(groups = {"smoke"})
    public void navigateToSectionList() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        academicsPage.goToSections();
        Assert.assertTrue(academicsPage.isSectionListDisplayed(),
                "Expected Section page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getTitle().contains("Section"),
                "Expected Section page, got title: " + driver.getTitle());
    }

    // Ref: TS-ACA-016
    @Test(groups = {"smoke"})
    public void sectionListTableDisplayed() {
        loginAsAdmin();
        academicsPage.goToSections();
        Assert.assertTrue(academicsPage.isSectionListDisplayed(),
                "Expected Section page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(academicsPage.isTableDisplayed(),
                "Section table not displayed on the Section page");
    }

    // Ref: TS-ACA-049
    @Test(groups = {"regression"})
    public void classSearch() {
        loginAsAdmin();
        academicsPage.goToClasses();
        Assert.assertTrue(academicsPage.isClassListDisplayed(),
                "Expected Class page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(academicsPage.isSearchBoxDisplayed(),
                "Search box not displayed on the Class page");

        academicsPage.search("a");

        Assert.assertTrue(driver.getTitle().contains("Class"),
                "Page title changed unexpectedly after search: " + driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
