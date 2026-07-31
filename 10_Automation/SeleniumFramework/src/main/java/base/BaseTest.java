package base;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {

        driver = DriverFactory.getDriver();

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("loginUrl"));

    }

    public void tearDown() {

        DriverFactory.quitDriver();

    }

}