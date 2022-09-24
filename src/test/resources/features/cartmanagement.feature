Feature: cart management
  @cartmanagement @addtocart
  Scenario: Add 1 item to cart
    Given I am already Logged in as "standard_user"
    And I am on Inventory Page
    When I click Add to Cart on "Sauce Labs Onesie"
    Then Cart icon should show total ammount of item "added"


  Scenario: Verify item added
    Given I already add item "Sauce Labs Onesie"
    When I click cart button
    Then I should redirected to Cart Page
    And I get list of added item

  Scenario: Remove item
    Given I already add item "Sauce Labs Onesie"
    When I click Remove on "Sauce Labs Onesie"
    Then Cart icon should show total ammount of item "removed"
