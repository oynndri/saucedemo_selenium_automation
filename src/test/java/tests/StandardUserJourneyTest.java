package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;


public class StandardUserJourneyTest extends BaseTest{

    @Test
    public void standardUserJourneyTest() {
        test = extent.createTest("Q2: Standard User Journey", "Testing the standard user journey from login to checkout");

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        test.log(Status.INFO, "logged in to standard user journey");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        test.log(Status.INFO, "Open hamburger menu and reset the app state");
        inventoryPage.clickHumbergerMenu();
        inventoryPage.resetAppState();
        inventoryPage.clickCrossIcon();


        test.log(Status.INFO, "Added three products to the cart");
        inventoryPage.addProduct1ToCart();
        inventoryPage.addProduct2ToCart();
        inventoryPage.addProduct3ToCart();

        test.log(Status.INFO, "Navigating to the cart");
        inventoryPage.clickCart();

        test.log(Status.INFO, "Proceed to checkout");
        cartPage.clickCheckout();

        test.log(Status.INFO, "Enter checkout details");
        checkoutPage.enterFirstName("Oynndrila");
        checkoutPage.enterLastName("Singh");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinue();

        test.log(Status.INFO, "Verify Product Name and Total Price");
        Assert.assertEquals(checkoutPage.getFirstProductName(), "Sauce Labs Backpack", "Product name mismatch at checkout");
        Assert.assertEquals(checkoutPage.getTotalPrice(), "Total: $60.45", "Total price does not match!");

        test.log(Status.INFO, "Finish the checkout process");
        checkoutPage.clickFinish();

        test.log(Status.INFO, "Verify the success order message");
        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!", "Success message does not found");


        test.log(Status.INFO, "Reopen the hamburger menu for reset the app state and logout");
        inventoryPage.clickHumbergerMenu();
        inventoryPage.resetAppState();
        inventoryPage.clickCrossIcon();
        inventoryPage.logout();

    }

}
