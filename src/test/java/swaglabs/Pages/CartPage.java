package swaglabs.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    private By continueShopping = By.id("continue-shopping");
    private By buttonCout = By.id("checkout");
    private By cartItem = By.className("inventory_item_name");

    public void verifyCartPage(){
        Assert.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
    }

    public void contShopping(){
        driver.findElement(continueShopping).click();
    }

    public void coutButton(){
        driver.findElement(buttonCout).click();
    }

    public String verifyCartItem(){
        return driver.findElement(cartItem).getAttribute("innerHTML");
    }

}
