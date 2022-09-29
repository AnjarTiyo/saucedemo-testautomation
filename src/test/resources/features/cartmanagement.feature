Feature: Cart Management
  As a customer, I want manage which item i want to buy

  @cartmanagement @addtocart
  Scenario Outline: Add 1 item to cart
    Given I am already Logged in as "standard_user"
    And I am on Inventory Page
    When I click Add to Cart on "<item>"
    Then The "remove" button on "<item>" appear
    Examples:
      | item                              |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario Outline: Remove item
    Given I am already Logged in as "standard_user"
    And I am on Inventory Page
    And I click Add to Cart on "<item>"
    When I click Remove on "<item>"
    Then The "Add to cart" button on "<item>" appear
    Examples:
      | item                              |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario Outline: Verify item added
    Given I am already Logged in as "standard_user"
    And I am on Inventory Page
    And I click Add to Cart on "<item>"
    When I click cart button
    Then I should redirected to Cart Page
    And I get "<item>" added to cart
    Examples:
      | item                              |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
