package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginErrorTest extends BaseTest {

    @Test
    public void verifyLockedOutUser() throws InterruptedException {
        test = extent.createTest("Q1: Verify Locked Out User", "Testing login with locked_out_user and verifying error message");
        LoginPage loginPage = new LoginPage(driver);

        test.log(Status.INFO, "Entering locked_out_user username and password and attempt to login");
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        Thread.sleep(2000); // Wait for 2 seconds to simulate user pause before clicking login

        test.log(Status.INFO, "Click the login button");
        loginPage.clickLoginButton();
        Thread.sleep(2000);


        test.log(Status.INFO, "Verified the error Message and displayed on the login page");
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Locked out user error message mismatch");
        test.log(Status.PASS, "Error message is correct: " + actualErrorMessage);
    }
}
