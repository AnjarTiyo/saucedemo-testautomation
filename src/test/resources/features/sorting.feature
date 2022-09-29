@sorting
Feature: Sorting Product
  As a customer, i want to sort product listed based on parameter

  Scenario Outline: Sorting product with given parameter
    #futher improvement to logged in as <user>
    Given I am already Logged in as "standard_user"
    And I am on Inventory Page
    When I select sorting method as "<parameter>"
    Then Product is sorted using parameter "<parameter>" "<sorting_val>"
#    Examples:
#    | user          | username        | password      |
#    | standard user | standard_user   | secret_sauce  |

    Examples:
    | parameter             | sorting_val         |
    | Name (A to Z)         | by name ascending   |
    | Name (Z to A)         | by name descending  |
    | Price (low to high)   | by price ascending  |
    | Price (high to low)   | by price descending |