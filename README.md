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


## Generating the reports
Since the Serenity reports contain aggregate information about all of the tests, they are not generated after each individual test (as this would be extremenly inefficient). Rather, The Full Serenity reports are generated by the `serenity-maven-plugin`. You can trigger this by running `mvn serenity:aggregate` from the command line or from your IDE.

They reports are also integrated into the Maven build process: the following code in the `pom.xml` file causes the reports to be generated automatically once all the tests have completed when you run `mvn verify`?

```
             <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.maven.version}</version>
                <configuration>
                    <tags>${tags}</tags>
                </configuration>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
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

