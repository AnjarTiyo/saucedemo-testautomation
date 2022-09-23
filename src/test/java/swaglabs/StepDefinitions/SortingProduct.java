package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import swaglabs.Pages.InventoryPage;
import swaglabs.Pages.LoginPage;

public class SortingProduct extends PageObject {
    LoginPage login;
    InventoryPage inv;

    @Given("I am already Logged in as {string}")
    public void iAmAlreadyLoggedInAs(String username) {
        login.open();
        login.inputUsername(username);
        login.inputPassword("secret_sauce");
        login.clickLoginButton();
    }

    @And("I am on Inventory Page")
    public void iAmOnInventoryPage() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", inv.verifyLoggedIn());
    }

    @When("I select sorting method as {string}")
    public void iSelectSortingMethodAs(String parameter) {
        inv.selectParam(parameter);
    }

    @Then("Product is sorted using parameter {string} {string}")
    public void productIsSortedUsingParameter(String parameter, String arg1) {
        Assert.assertEquals(parameter, inv.getParam());
    }
}

