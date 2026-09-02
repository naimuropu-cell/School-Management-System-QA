package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class InventoryTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    // Ref: TS-INV-006
    @Test(groups = {"smoke"})
    public void navigateToItems() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        inventoryPage.goToItems();
        Assert.assertTrue(inventoryPage.isItemsDisplayed(),
                "Expected Inventory Items page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-INV-043
    @Test(groups = {"smoke"})
    public void inventorySearchBoxDisplayed() {
        loginAsAdmin();
        inventoryPage.goToItems();
        Assert.assertTrue(inventoryPage.isItemsDisplayed(),
                "Expected Inventory Items page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(inventoryPage.isSearchBoxDisplayed(),
                "Search box not displayed on the Inventory Items page");
    }

    // Ref: TS-INV-044
    @Test(groups = {"smoke"})
    public void inventoryItemsTableDisplayed() {
        loginAsAdmin();
        inventoryPage.goToItems();
        Assert.assertTrue(inventoryPage.isItemsDisplayed(),
                "Expected Inventory Items page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(inventoryPage.isTableDisplayed(),
                "Inventory Items table not displayed");
        Assert.assertTrue(inventoryPage.getRowCount() >= 0,
                "Expected a valid inventory row count, got: " + inventoryPage.getRowCount());
    }

    // Ref: TS-INV-045
    @Test(groups = {"smoke"})
    public void inventoryItemsPaginationDisplayed() {
        loginAsAdmin();
        inventoryPage.goToItems();
        Assert.assertTrue(inventoryPage.isItemsDisplayed(),
                "Expected Inventory Items page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(inventoryPage.isPaginationDisplayed(),
                "Pagination not displayed on the Inventory Items page");
    }

    // Ref: TS-INV-006
    @Test(groups = {"smoke"})
    public void inventoryItemsAddButtonDisplayed() {
        loginAsAdmin();
        inventoryPage.goToItems();
        Assert.assertTrue(inventoryPage.isItemsDisplayed(),
                "Expected Inventory Items page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(inventoryPage.isAddButtonDisplayed(),
                "Add button not visible on the Inventory Items page");
    }

    // Ref: TS-INV-027
    @Test(groups = {"smoke"})
    public void navigateToItemIssue() {
        loginAsAdmin();
        Assert.assertTrue(dashboardPage.isAdminDashboardDisplayed(),
                "Admin dashboard not displayed before navigation");

        inventoryPage.goToItemIssue();
        Assert.assertTrue(inventoryPage.isItemIssueDisplayed(),
                "Expected Item Issue page, got URL: " + driver.getCurrentUrl());
    }

    // Ref: TS-INV-027
    @Test(groups = {"smoke"})
    public void itemIssueTableDisplayed() {
        loginAsAdmin();
        inventoryPage.goToItemIssue();
        Assert.assertTrue(inventoryPage.isItemIssueDisplayed(),
                "Expected Item Issue page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(inventoryPage.isTableDisplayed(),
                "Item Issue table not displayed");
    }

    // Ref: TS-INV-043
    @Test(groups = {"regression"})
    public void inventorySearch() {
        loginAsAdmin();
        inventoryPage.goToItems();
        Assert.assertTrue(inventoryPage.isItemsDisplayed(),
                "Expected Inventory Items page, got URL: " + driver.getCurrentUrl());
        Assert.assertTrue(inventoryPage.isSearchBoxDisplayed(),
                "Search box not displayed on the Inventory Items page");

        inventoryPage.search("a");

        Assert.assertTrue(inventoryPage.isItemsDisplayed(),
                "URL changed unexpectedly after search: " + driver.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
