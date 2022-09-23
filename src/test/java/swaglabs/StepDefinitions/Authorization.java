package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import swaglabs.Pages.LoginPage;

public class Authorization {
    LoginPage login;

    @Given("I am already on Login Page")
    public void iAmAlreadyOnLoginPage() {
        login.open();

    }

    @When("I input {string} as username")
    public void iInputAsUsername(String username) {
        login.inputUsername(username);
    }

    @And("I input {string} as password")
    public void iInputAsPassword(String password) {
        login.inputPassword(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        login.clickLoginButton();
    }


    @Then("I should get response {string}")
    public void iShouldGetResponse(String response) {
        if (response.matches("redirected(.*)")) {
            Assert.assertEquals(login.verifyStatus(), "https://www.saucedemo.com/inventory.html");
        } else if (response.matches("Epic sadface: (.*)")) {
            Assert.assertEquals(login.responseStatus(), response);
        }
    }
}
