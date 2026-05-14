package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By firstProductNameField = By.className("inventory_item_name");
    By totalPriceField = By.className("summary_total_label");
    By successMessageField = By.className("complete-header");


    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){

        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue(){

        driver.findElement(continueButton).click();
    }
    public void clickFinish(){
        driver.findElement(finishButton).click();
    }
    public String getFirstProductName(){
        return driver.findElement(firstProductNameField).getText();
    }
    public String getTotalPrice(){
        return driver.findElement(totalPriceField).getText();
    }
    public String getSuccessMessage(){
        return driver.findElement(successMessageField).getText();
    }

}
