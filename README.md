# SauceDemo UI Automation (Selenium + TestNG)

End-to-end UI automation framework for [SauceDemo](https://www.saucedemo.com/) built with Java, Selenium WebDriver, TestNG, and ExtentReports.

## Overview
This project validates core user journeys and negative login scenarios for SauceDemo using a Page Object Model (POM) based test framework.

Current automated coverage includes:
- Locked out user login validation
- Standard user purchase flow (login -> cart -> checkout -> order confirmation)
- Performance glitch user flow with product sort and checkout verification

## Tech Stack
- Java 17
- Selenium WebDriver 4.43.0
- TestNG 7.9.0
- Maven Surefire 3.2.5
- ExtentReports 5.1.1

## Project Structure
```text
src
├── main
│   └── java
│       ├── config
│       │   └── ConfigReader.java
│       └── utils
│           └── WaitUtils.java
└── test
    ├── java
    │   ├── base
    │   │   └── BaseTest.java
    │   ├── pages
    │   │   ├── CartPage.java
    │   │   ├── CheckoutPage.java
    │   │   ├── InventoryPage.java
    │   │   └── LoginPage.java
    │   └── tests
    │       ├── GlitchUserJourneyTest.java
    │       ├── LoginErrorTest.java
    │       └── StandardUserJourneyTest.java
    └── resources
        └── config.properties
```

## Framework Design
- **POM architecture**: UI interactions are encapsulated in page classes under `pages`.
- **Centralized setup/teardown**: Browser lifecycle and reporting are managed in `BaseTest`.
- **Config-driven base URL**: `config.properties` controls environment entry point.
- **Execution suite**: `testng.xml` controls which classes run in a suite.
- **Reporting**: Extent report is generated after suite completion.

## Prerequisites
- JDK 17 installed and available in `PATH`
- Maven 3.8+ installed
- Google Chrome installed (matching ChromeDriver support in Selenium Manager)
- Internet access for first dependency resolution (`mvn` download)

## Configuration
Update environment URL from:

`src/test/resources/config.properties`
```properties
baseUrl = https://www.saucedemo.com/
```

## Test Execution
Run from project root.

### 1) Run complete suite from `testng.xml`
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### 2) Run specific test classes
```bash
mvn clean test -Dtest=LoginErrorTest,StandardUserJourneyTest,GlitchUserJourneyTest
```

### 3) Run from IDE
- Open `testng.xml`
- Run as TestNG suite from the IDE run button

## Default Suite (Current)
`testng.xml` currently includes:
- `tests.LoginErrorTest`
- `tests.StandardUserJourneyTest`

Add `tests.GlitchUserJourneyTest` to run all 3 test classes in one suite execution.

## Reporting and Artifacts
- **Extent HTML report**: `target/ExtentReport.html`
- **Maven test output**: `target/surefire-reports/`
- **Failure evidence**: Base64 screenshots embedded in Extent report for failed tests

## Test Scenarios Covered
1. **Locked Out User**
   - Login with `locked_out_user`
   - Validate expected lockout error message

2. **Standard User Journey**
   - Login with `standard_user`
   - Reset app state
   - Add 3 products to cart
   - Complete checkout
   - Verify product and total price
   - Validate order success message

3. **Glitch User Journey**
   - Login with `performance_glitch_user`
   - Reset app state
   - Sort products `Z -> A`
   - Add first listed product
   - Complete checkout
   - Verify product and total price
   - Validate order success message

## Known Improvement Areas
- Replace `Thread.sleep(...)` in tests with explicit waits from `WaitUtils`
- Standardize locator strategy (prefer `id`/stable CSS over long XPath)
- Add CI pipeline execution (GitHub Actions/Jenkins)
- Externalize test data and credentials for scalability
- Add parallel execution strategy with thread-safe reporting

## License
This project is licensed under the MIT License. See `LICENSE` for details.
