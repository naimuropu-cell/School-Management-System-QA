package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class RoleLoginTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    @Test(groups = {"smoke"})
    public void validAdminLogin() {
        loginAsAdmin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin-dashboard"),
                "Admin login did not reach the admin dashboard");
    }

    @Test(groups = {"smoke"})
    public void validTeacherLogin() {
        loginAsTeacher();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin-dashboard"),
                "Teacher login did not reach the teacher dashboard");
    }

    @Test(groups = {"smoke"})
    public void validStudentLogin() {
        loginAsStudent();
        Assert.assertTrue(driver.getCurrentUrl().contains("/student-dashboard"),
                "Student login did not reach the student dashboard");
    }

    @Test(groups = {"regression"})
    public void validAccountantLogin() {
        loginAsAccountant();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin-dashboard"),
                "Accountant login did not reach the accountant dashboard");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }

}
