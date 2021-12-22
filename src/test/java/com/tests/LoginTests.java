package com.tests;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Parameters({"username","password"})
    @Test
    public void verifyLogin(String username, String password) {
        loginPage.loginToApplication(username,password);

    }
}
