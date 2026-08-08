package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;

    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public WebElement waitUntilVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement waitUntilClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public boolean waitUntilInvisible(By locator) {

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public void waitForTitle(String title) {

        wait.until(ExpectedConditions.titleContains(title));

    }

}