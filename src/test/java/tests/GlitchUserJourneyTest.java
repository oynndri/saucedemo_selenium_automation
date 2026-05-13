package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class GlitchUserJourneyTest extends BaseTest {
    @Test
    public void glitchUserJourneyTest() {
        test = extent.createTest("Q3: Glitch User Journey", "Testing the performance glitch user journey with filter");

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage  checkoutPage = new CheckoutPage(driver);

        test.log(Status.INFO, "logged in with performance_glitch_user");
        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        test.log(Status.INFO, "Open humberburger menu and reset app state");
        inventoryPage.clickHumbergerMenu();
        inventoryPage.resetAppState();
        inventoryPage.clickCrossIcon();

        test.log(Status.INFO, "Apply filter to sort products from Z to A");
        inventoryPage.clickFilterButton();
        inventoryPage.ClickZtoAButton();

        test.log(Status.INFO, "Select the first product and add to cart");
        inventoryPage.clickSelectFirstProduct();

        test.log(Status.INFO,"Navigate to the cart");
        inventoryPage.clickCart();

        test.log(Status.INFO,"Proceed to checkout");
        cartPage.clickCheckout();

        test.log(Status.INFO,"Enter the checkout details");
        checkoutPage.enterFirstName("Oynndrila");
        checkoutPage.enterLastName("Singh");
        checkoutPage.enterPostalCode("1807");
        checkoutPage.clickContinue();

        test.log(Status.INFO,"Verify the first product name and total price at checkout");
        Assert.assertEquals(checkoutPage.getFirstProductName(), "Test.allTheThings() T-Shirt (Red)", "Product name mismatch");
        Assert.assertEquals(checkoutPage.getTotalPrice(),"Total: $17.27","Price mismatch");

        test.log(Status.INFO,"Finish the checkout process");
        checkoutPage.clickFinish();

        test.log(Status.INFO, "Verify the successful order message");
        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!", "Success message does not found");

        test.log(Status.INFO,"Open humburger menu and logout");
        inventoryPage.clickHumbergerMenu();
        inventoryPage.resetAppState();
        inventoryPage.clickCrossIcon();
        inventoryPage.logout();

    }
}
