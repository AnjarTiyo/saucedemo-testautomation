package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.CartPage;
import swaglabs.Pages.CheckOutPage;

public class CheckoutStep {
    CartPage cart;
    CheckOutPage cout1;

    @And("I click Checkout button")
    public void iClickCheckoutButton(){
        cout1.clickCheckout();
    }

    @And("I should redirected to checkout-step-one page")
    public void iShouldRedirectedToCheckoutStepOnePage() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", cout1.verifyPage());
    }


    @When("I input {string} as first name")
    public void iInputAsFirstName(String nameFirst) {
        cout1.inputFirstName(nameFirst);
    }

    @And("I input {string} as last name")
    public void iInputAsLastName(String nameLast) {
        cout1.inputLastName(nameLast);
    }

    @And("I input {string} as Postal Code")
    public void iInputAsZipPostalCode(String codeZip) {
        cout1.inputZipCode(codeZip);
    }
    @And("I click continue")
    public void iClickContinue() {
        cout1.clickContinue();
    }

    @Then("I redirected to checkout-step-two page")
    public void iRedirectedToCheckoutStepTwoPage() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", cout1.verifyPage());
    }

    @When("I click Finish")
    public void iClickFinish() {
        cout1.clickFinish();
    }

    @Then("I redirected to checkout complete page")
    public void iRedirectedToCheckoutCompletePage() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", cout1.verifyPage());
    }

    @And("Fancy Robo-Cowboy appear, yeehaaa!!!")
    public void fancyRoboCowboyAppearYeehaaa() {
        cout1.checkoutCompleted();
    }
}
