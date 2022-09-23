package swaglabs.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {
    //prioritaskan By.id
    private final By fieldUsername = By.id("user-name");
    private final By fieldPassword = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessages = By.cssSelector("h3[data-test='error']");
    @Managed
    WebDriver driver = getDriver();

    public void inputUsername(String username) {
        //isi fieldUsername dengan "username"
        driver.findElement(fieldUsername).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String verifyStatus() {
        return driver.getCurrentUrl();
    }

    public String responseStatus() {
        return driver.findElement(errorMessages).getText();
    }

}