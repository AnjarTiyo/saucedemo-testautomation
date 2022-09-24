package swaglabs.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();
    private final By availParam = By.className("product_sort_container");
    private final By activeParam = By.className("active_option");
    private final By cartbutton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private final By cartVal = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By inventory = By.id("inventory_container");

    public int countItem(){
        List<WebElement> ammountItem = driver.findElements(By.xpath("//*[contains(@id,'remove') ]"));
        return ammountItem.size();
    }
    LoginPage login; //suspected error

    public void fullLogin() {
        login.open();
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLoginButton();
    }

    public String verifyLoggedIn() {
        return driver.getCurrentUrl();
    }

    public void selectParam(String parameter) {
        Select se = new Select(driver.findElement(availParam));
        se.selectByVisibleText(parameter);
    }

    public String getParam() {
        return driver.findElement(activeParam).getText();
    }

    public void addToCart(String item) {
        String str = item.toLowerCase();
        String newStr = str.replace(" ", "-");
        String idButton = String.join("-", "add-to-cart", newStr);
        driver.findElement(By.id(idButton)).click();
    }

    public void removeCart(String item) {
        String str = item.toLowerCase();
        String newStr = str.replace(" ", "-");
        String idButton = String.join("-", "remove", newStr);
        driver.findElement(By.id(idButton)).click();
    }

    public int getCartVal() {
        return countItem();
    }

    public void clickCart() {
        driver.findElement(cartbutton).click();
    }

    public void verifyCart() {
        driver.getCurrentUrl();
    }
}
