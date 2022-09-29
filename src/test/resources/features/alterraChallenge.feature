@exploratory
Feature: alterra challenge (ordering product)

  Scenario: Ordering product exploratory # revisi nanti
    Given I am already Logged in as "standard_user"
    And I click Add to Cart on "Sauce labs Onesie"
    When I select sorting method as "Name (Z to A)"
    And I click Add to Cart on "Test.allTheThings() T-Shirt (Red)"
    And I click cart button
    Then I should redirected to Cart Page
    When I click Remove on "Test.allTheThings() T-Shirt (Red)"
    And I click Continue Shopping
    Then I should redirected to Inventory Page
    When I click Add to Cart on "Sauce labs Bike Light"
    And I click cart button
    Then I should redirected to Cart Page
    When I click Checkout button
    Then I should redirected to checkout-step-one page
    When I input "Anjar" as first name
    And I input "Ganteng" as last name
    And I input "999999" as Postal Code
    And I click continue
    Then I redirected to checkout-step-two page
#    And Page return item as ordered
#    And Page return Payment Information
#    And Page return Shipping Information
#    And Page return total ammount to be paid
    When I click Finish
    Then I redirected to checkout complete page
    And Fancy Robo-Cowboy appear, yeehaaa!!!
