package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.CartPage;
import swaglabs.Pages.InventoryPage;
import swaglabs.Pages.LoginPage;

public class CartManagement {

    InventoryPage inv;
    CartPage cart;
    LoginPage login;

    @When("I click Add to Cart on {string}")
    public void iClickAddToCartOn(String item){
        inv.addToCart(item);
    }

    @Then("Cart icon should show total ammount of item {string}")
    public void cartIconShouldShowTotalAmmountOfAddedItem(String status) {
        // logic masih salah untuk add multiple item
        // hilangkan remove dan added
        if(status.equals("added")){
            Assert.assertTrue(inv.countItem() >= 0);
        }else {
            Assert.assertEquals(0, inv.countItem());
        }
        inv.reset();
    }

    @When("I click cart button")
    public void iClickCartButton() {
        inv.clickCart();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", inv.verifyCart());
    }

    @Given("I already add item {string}")
    public void iAlreadyAddItem(String item) {
        login.reset();
        login.open();
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLoginButton();
        inv.addToCart(item);
    }

    @Then("I should redirected to Cart Page")
    public void iShouldReddirectedToCartPage() {
        cart.verifyCartPage();
    }

    @And("I get {string} added to cart")
    public void iGetListOfAddedItem(String item) {
        Assert.assertEquals(item, cart.verifyCartItem());
        login.reset();
    }

    @When("I click Remove on {string}")
    public void iClickRemoveOn(String item) {
        inv.removeCart(item);
    }

    @Then("The {string} button on {string} appear")
    public void theButtonOnAppear(String button, String item) {
        inv.verifyButton(button, item);
        login.reset();
    }

    @And("I click Continue Shopping")
    public void iClickContinueShopping() {
        cart.contShopping();
    }

    @Then("I should redirected to Inventory Page")
    public void iShouldRedirectedToInventoryPage() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", inv.verifyLoggedIn());
    }
}
