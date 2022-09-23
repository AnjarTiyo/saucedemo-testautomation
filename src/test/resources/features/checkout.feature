Feature: checkout

  Scenario Outline: Checkout valid order step one
    Given I click Add to Cart on "Sauce Labs Onesie"
    And I click cart button
    And I click Checkout button
    And I should redirected to checkout-step-one page
    When I input "<firstName>" as first name
    And I input "<lastName>>" as last name
    And I input "<zipCode>" as Postal Code
    And I click continue
    Then I redirected to checkout-step-two page
    Examples:
    | firstName  | lastName   | zipCode |
    | Anjar      | Ganteng    | 999999   |

#  Scenario: Checkout step two
#    Given I redirected to checkout-step-two page
#    When I click Finish
#    Then I redirected to checkout complete page
#    And Fancy Robo-Cowboy appear, yeehaaa!!!
