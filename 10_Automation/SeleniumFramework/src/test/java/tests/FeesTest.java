package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class FeesTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    // Ref: TS-FEE-006 / TS-FEE-007
    @Test(groups = {"smoke"})
    public void navigateToFeeStructure() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        feePage.goToFeeStructure();
        Assert.assertTrue(feePage.isFeeStructureDisplayed(),
                "Expected Fee Structure page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-FEE-006
    @Test(groups = {"smoke"})
    public void feeStructureSearchBoxDisplayed() {
        loginAsAdmin();
        feePage.goToFeeStructure();
        Assert.assertTrue(feePage.isFeeStructureDisplayed(),
                "Expected Fee Structure page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(feePage.isSearchBoxDisplayed(),
                "Search box not displayed on the Fee Structure page");
    }

    // Ref: TS-FEE-006
    @Test(groups = {"smoke"})
    public void feeStructureTableDisplayed() {
        loginAsAdmin();
        feePage.goToFeeStructure();
        Assert.assertTrue(feePage.isFeeStructureDisplayed(),
                "Expected Fee Structure page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(feePage.isTableDisplayed(),
                "Fee Structure table not displayed");
        Assert.assertTrue(feePage.getRowCount() >= 0,
                "Expected a valid fee row count, got: " + feePage.getRowCount());
    }

    // Ref: TS-FEE-006
    @Test(groups = {"smoke"})
    public void feeStructureAddButtonDisplayed() {
        loginAsAdmin();
        feePage.goToFeeStructure();
        Assert.assertTrue(feePage.isFeeStructureDisplayed(),
                "Expected Fee Structure page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(feePage.isAddButtonDisplayed(),
                "Add button not visible on the Fee Structure page");
    }

    // Ref: TS-FEE-004
    @Test(groups = {"smoke"})
    public void navigateToFeeCollection() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        feePage.goToFeeCollection();
        Assert.assertTrue(feePage.isCollectionDisplayed(),
                "Expected Fee Collection page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-FEE-003
    @Test(groups = {"smoke"})
    public void navigateToFeeAssignment() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        feePage.goToFeeAssignment();
        Assert.assertTrue(feePage.isAssignmentDisplayed(),
                "Expected Fee Assignment page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-FEE-005
    @Test(groups = {"smoke"})
    public void navigateToFeeReport() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        feePage.goToFeeReport();
        Assert.assertTrue(feePage.isReportDisplayed(),
                "Expected Fee Report page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-FEE-061
    @Test(groups = {"regression"})
    public void feeStructureSearch() {
        loginAsAdmin();
        feePage.goToFeeStructure();
        Assert.assertTrue(feePage.isFeeStructureDisplayed(),
                "Expected Fee Structure page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(feePage.isSearchBoxDisplayed(),
                "Search box not displayed on the Fee Structure page");

        feePage.search("a");

        Assert.assertTrue(feePage.isFeeStructureDisplayed(),
                "URL changed unexpectedly after search: " + driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
