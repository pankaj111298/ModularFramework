package com.tests;


import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void verifyLogin(String username, String password) {

        reportUtils.createTestCase("Verify login credentials");
        reportUtils.addTestLog(Status.INFO, "Entering the credentials of the application");
        loginPage.loginToApplication(username, password);
        reportUtils.addTestLog(Status.INFO, "Comparing the default tab landing");
        Assert.assertEquals(homePage.getDefaultTabName(), "Dashboard");



    }
}
