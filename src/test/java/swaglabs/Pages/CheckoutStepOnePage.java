package swaglabs.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/")
public class CheckoutStepOnePage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipcode = By.id("postal-code");
    private By contButton = By.id("continue");

    public String verifyCheckout1(){
        return driver.getCurrentUrl();
    }

    public void inputFirstName(String nameFirst){
        driver.findElement(firstName).sendKeys(nameFirst);
    }
    public void inputLastName(String nameLast){
        driver.findElement(lastName).sendKeys(nameLast);

    }
    public void inputZipCode(String codeZip){
        driver.findElement(zipcode).sendKeys(codeZip);
    }
    public void clickContinue(){
        driver.findElement(contButton).click();
    }

}
