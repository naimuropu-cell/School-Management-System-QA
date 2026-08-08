package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private By studentsMenu = By.linkText("Students");
    private By teachersMenu = By.linkText("Teachers");
    private By academicsMenu = By.linkText("Academics");
    private By accountsMenu = By.linkText("Accounts");
    private By examinationMenu = By.linkText("Examination");
    private By settingsMenu = By.linkText("Settings");

    public void goToStudents() {
        click(studentsMenu);
    }

    public void goToTeachers() {
        click(teachersMenu);
    }

    public void goToAcademics() {
        click(academicsMenu);
    }

    public void goToAccounts() {
        click(accountsMenu);
    }

    public void goToExamination() {
        click(examinationMenu);
    }

    public void goToSettings() {
        click(settingsMenu);
    }
}