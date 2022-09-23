package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.CartPage;
import swaglabs.Pages.CheckoutStepOnePage;

public class CheckoutStepOne {
    CartPage cart;
    CheckoutStepOnePage cout1;

    @And("I click Checkout button")
    public void iClickCheckoutButton(){
    }

    @And("I should redirected to checkout-step-one page")
    public void iShouldRedirectedToCheckoutStepOnePage() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", cout1.verifyCheckout1());
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
    }
}
