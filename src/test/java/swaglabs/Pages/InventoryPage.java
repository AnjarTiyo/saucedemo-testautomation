package swaglabs.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
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

    @Steps
    LoginPage login; //suspected error
    public int countItem(){
        List<WebElement> ammountItem = driver.findElements(By.id("remove-/*"));
        return ammountItem.size();
    }

    public String verifyLoggedIn() {
        return driver.getCurrentUrl();
    }

    public void selectParam(String parameter) {
        Select se = new Select(driver.findElement(availParam));
        se.selectByVisibleText(parameter);
    }

    public String getParam() {
        return driver.findElement(activeParam).getAttribute("innerHTML");
    }

    public void addToCart(String item) {
        String str = item.toLowerCase();
        String newStr = str.replace(" ", "-");
        String newStr2 = newStr.replace("#", "");
        String idButton = String.join("-", "add-to-cart", newStr2);
        driver.findElement(By.id(idButton)).click();
    }
    public void verifyButton(String button, String item){
        String str = item.toLowerCase()
                .replace(" ", "-")
                .replace("#","");
        String btn = button.toLowerCase().replace(" ", "-");
        String idButton = String.join("-", btn, str);
        driver.findElement(By.id(idButton)).isDisplayed();
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

    public String verifyCart() {
        return driver.getCurrentUrl();
    }

    public void reset(){
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}
