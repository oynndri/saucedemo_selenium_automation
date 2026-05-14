package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    By HumbergerMenu = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    By resetAppState = By.xpath("//*[@id=\"reset_sidebar_link\"]");
    By logout = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    By clickCrossIcon = By.xpath("//*[@id=\"react-burger-cross-btn\"]");
    By cart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    By filterButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By clickZtoA = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]");
    By selectFirstProduct = By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]");

    By product1 = By.id("add-to-cart-sauce-labs-backpack");
    By product2 = By.id("add-to-cart-sauce-labs-bike-light");
    By product3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickHumbergerMenu(){
        driver.findElement(HumbergerMenu).click();
    }
    public void resetAppState(){
        driver.findElement(resetAppState).click();
    }
    public void clickCrossIcon(){
        driver.findElement(clickCrossIcon).click();
    }
    public void logout () {
        driver.findElement(logout).click();
    }
    public void addProduct1ToCart(){
        driver.findElement(product1).click();
    }
    public void addProduct2ToCart(){
        driver.findElement(product2).click();
    }
    public void addProduct3ToCart(){
        driver.findElement(product3).click();
    }
    public void clickCart(){
        driver.findElement(cart).click();
    }

    public void clickFilterButton(){
        driver.findElement(filterButton).click();
    }
    public void ClickZtoAButton(){
        driver.findElement(clickZtoA).click();
    }
    public void clickSelectFirstProduct(){
        driver.findElement(selectFirstProduct).click();
    }




}
