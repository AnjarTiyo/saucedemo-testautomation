Feature: Checkout
  As a customer I want to finish my order

  Scenario Outline: Checkout valid order step one
    Given I already add item "Sauce Labs Onesie"
    And I click cart button
    And I click Checkout button
    And I should redirected to checkout-step-one page
    When I input "<firstName>" as first name
    And I input "<lastName>>" as last name
    And I input "<zipCode>" as Postal Code
    And I click continue
    Given I redirected to checkout-step-two page
    When I click Finish
    Then I redirected to checkout complete page
    And Fancy Robo-Cowboy appear, yeehaaa!!!
    Examples:
      | firstName  | lastName   | zipCode |
      | Anjar      | Ganteng    | 999999   |

