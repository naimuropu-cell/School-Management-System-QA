package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ConfigReader;

import java.util.List;

public class FeePage extends BasePage {

    private static final String FEE_STRUCTURE_ROUTE = "/fees";
    private static final String FEE_COLLECTION_ROUTE = "/fees/payment";
    private static final String FEE_ASSIGNMENT_ROUTE = "/fees/fees-assign";
    private static final String FEE_REPORT_ROUTE = "/fees/fees-report";

    public FeePage(WebDriver driver) {
        super(driver);
    }

    private final String baseUrl = ConfigReader.getProperty("baseUrl");

    // Locators
    private By searchBox = By.cssSelector("input[type='search']");
    private By dataTable = By.cssSelector("table");
    private By tableRows = By.cssSelector("tbody tr");
    private By pagination = By.cssSelector(".dataTables_paginate, .pagination");
    private By addButton = By.xpath("//a[contains(normalize-space(),'Add')]");

    // Navigation
    public void goToFeeStructure() {
        driver.get(baseUrl + FEE_STRUCTURE_ROUTE);
    }

    public void goToFeeCollection() {
        driver.get(baseUrl + FEE_COLLECTION_ROUTE);
    }

    public void goToFeeAssignment() {
        driver.get(baseUrl + FEE_ASSIGNMENT_ROUTE);
    }

    public void goToFeeReport() {
        driver.get(baseUrl + FEE_REPORT_ROUTE);
    }

    // Assertions
    public boolean isFeeStructureDisplayed() {
        return getCurrentUrl().contains(FEE_STRUCTURE_ROUTE);
    }

    public boolean isCollectionDisplayed() {
        return getCurrentUrl().contains(FEE_COLLECTION_ROUTE);
    }

    public boolean isAssignmentDisplayed() {
        return getCurrentUrl().contains(FEE_ASSIGNMENT_ROUTE);
    }

    public boolean isReportDisplayed() {
        return getCurrentUrl().contains(FEE_REPORT_ROUTE);
    }

    public boolean isSearchBoxDisplayed() {
        return isDisplayed(searchBox);
    }

    public boolean isTableDisplayed() {
        return isDisplayed(dataTable);
    }

    public boolean isPaginationDisplayed() {
        return isDisplayed(pagination);
    }

    public boolean isAddButtonDisplayed() {
        return isDisplayed(addButton);
    }

    public int getRowCount() {
        List<WebElement> rows = driver.findElements(tableRows);
        return rows.size();
    }

    public void search(String text) {
        type(searchBox, text);
        sleepQuietly(500);
    }

    private void sleepQuietly(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
