Feature: Authorization

  @authorization
    Scenario Outline: Login functionality
    Given I am already on Login Page
    When I input "<username>" as username
    And I input "<password>" as password
    And I click login button
    Then I should get response "<response>"
    Examples:
      | username                | password     | response                                                                  |
      | standard_user           | secret_sauce | redirected to Inventory Page                                              |
      | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | problem_user            | secret_sauce | redirected to Inventory Page                                              |
      | performance_glitch_user | secret_sauce | redirected to Inventory Page                                              |
      |                         |              | Epic sadface: Username is required                                        |
      | standard_user           |              | Epic sadface: Password is required                                        |
      | wrong_user              | secret_sauce | Epic sadface: Username and password do not match any user in this service |
