package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitHelper;

public class BasePage {

    protected WebDriver driver;

    protected WaitHelper wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WaitHelper(driver);

    }

    protected void click(By locator) {

        wait.waitUntilClickable(locator).click();

    }

    protected void type(By locator, String text) {

        WebElement element = wait.waitUntilVisible(locator);

        element.clear();

        element.sendKeys(text);

    }

    protected String getText(By locator) {

        return wait.waitUntilVisible(locator).getText();

    }

    protected boolean isDisplayed(By locator) {

        return wait.waitUntilVisible(locator).isDisplayed();

    }

    protected String getCurrentUrl() {

        return driver.getCurrentUrl();

    }

    protected String getPageTitle() {

        return driver.getTitle();

    }

}