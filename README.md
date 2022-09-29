[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

# Saucedemo.com Web Testing Automation using Serenity BDD

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                      Test runners and supporting code
      + swaglabs
        + Pages
        + StepDefinition
    + resources
      + features                  Feature files
```

## The sample scenario

```Gherkin
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

```


### The Action Classes implementation.

A more imperative-style implementation using the Action Classes pattern can be found in the `action-classes` branch. The glue code in this version looks this this:

```java
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
```


## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  

### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:

```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

Serenity uses WebDriverManager to download the WebDriver binaries automatically before the tests are executed.

### How to use
1. Clone this repository

```sh
git clone https://github.com/AnjarTiyo/saucedemo-testautomation.git
```

2. Go to saved directory

```sh
cd saucedemo-testautomation
```

3. Generate report using following code 

```sh
mvn clean verify
```

### Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Contact

Anjar Tiyo Saputro - [@anjartiyo.s](https://www.instagram.com/anjartiyo.s/) - anjar.jog@gmail.com

Project Link: [https://github.com/AnjarTiyo/saucedemo-testautomation](https://github.com/AnjarTiyo/saucedemo-testautomation)

## Acknowledgments

* [Alterra Academy](https://academy.alterra.id/)
* [Rest Assured](https://github.com/rest-assured/rest-assured)
* [My Mentor - Fifeka Onanda Wahid](https://id.linkedin.com/in/fifeka-onanda-wahid)

[contributors-shield]: https://img.shields.io/github/contributors/AnjarTiyo/saucedemo-testautomation.svg?style=for-the-badge
[contributors-url]: https://github.com/AnjarTiyo/saucedemo-testautomation/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AnjarTiyo/saucedemo-testautomation.svg?style=for-the-badge
[forks-url]: https://github.com/AnjarTiyo/saucedemo-testautomation/network/members
[stars-shield]: https://img.shields.io/github/stars/AnjarTiyo/saucedemo-testautomation.svg?style=for-the-badge
[stars-url]: https://github.com/AnjarTiyo/saucedemo-testautomation/stargazers
[issues-shield]: https://img.shields.io/github/issues/AnjarTiyo/saucedemo-testautomation.svg?style=for-the-badge
[issues-url]: https://github.com/AnjarTiyo/saucedemo-testautomation/issues
[license-shield]: https://img.shields.io/github/license/AnjarTiyo/saucedemo-testautomation.svg?style=for-the-badge
[license-url]: https://github.com/AnjarTiyo/saucedemo-testautomation/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/anjartiyo
