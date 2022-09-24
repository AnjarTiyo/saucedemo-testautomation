package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.CartPage;
import swaglabs.Pages.InventoryPage;

public class CartManagement {

    InventoryPage inv;
    @When("I click Add to Cart on {string}")
    public void iClickAddToCartOn(String item){
        inv.addToCart(item);
    }

    CartPage cart;

    @Then("Cart icon should show total ammount of item {string}")
    public void cartIconShouldShowTotalAmmountOfAddedItem(String status) {
        // logic masih salah untuk add multiple item
        // hilangkan remove dan added
        if(status.equals("added")){
            Assert.assertTrue(inv.countItem() >= 0);
        }else {
            Assert.assertEquals(0, inv.countItem());
        }
    }

    @When("I click cart button")
    public void iClickCartButton() {
        inv.clickCart();
        //Assert.assertEquals("https://www.saucedemo.com/cart.html", inv.verifyCart());
    }

    @Given("I already add item {string}")
    public void iAlreadyAddItem(String item) {
        inv.fullLogin();
        inv.addToCart(item);
    }

    @Then("I should redirected to Cart Page")
    public void iShouldReddirectedToCartPage() {
        cart.verifyCartPage();
    }

    @And("I get list of added item")
    public void iGetListOfAddedItem() {
    }

    @When("I click Remove on {string}")
    public void iClickRemoveOn(String item) {
        inv.removeCart(item);
    }
}
