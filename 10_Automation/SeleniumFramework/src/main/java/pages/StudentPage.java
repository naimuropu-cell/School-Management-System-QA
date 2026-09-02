package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ConfigReader;

import java.util.List;

public class StudentPage extends BasePage {

    private static final String STUDENT_LIST_ROUTE = "/student-list";

    public StudentPage(WebDriver driver) {
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
    public void goToStudentList() {
        driver.get(baseUrl + STUDENT_LIST_ROUTE);
    }

    // Assertions
    public boolean isStudentListDisplayed() {
        return getCurrentUrl().contains(STUDENT_LIST_ROUTE);
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

    public void searchStudent(String text) {
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
