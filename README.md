# 99Acres Property Search Test Automation

## Project Overview

99Acres_Syntax_Squad is a Selenium-based test automation framework designed to automate property search flows on the 99acres.com platform. This project demonstrates end-to-end testing of the property search functionality using the Page Object Model (POM) design pattern, TestNG framework, and Extent Reports for reporting.

## Project Information

- Project Name: 99Acres_Syntax_Squad
- Group ID: com.hackathon.hcl
- Artifact ID: 99Acres_Syntax_Squad
- Version: 0.0.1-SNAPSHOT
- Packaging: JAR

## Key Features

- Selenium WebDriver for browser automation
- Page Object Model (POM) design pattern implementation
- TestNG framework for test execution and management
- WebDriverManager for automatic driver management
- ThreadLocal driver support for parallel test execution
- Extent Reports for comprehensive test reporting
- Configuration-driven test execution
- Exception handling and retry mechanisms
- Wait utilities for element synchronization

## Technology Stack

### Core Dependencies

- Selenium Java 4.34.0 - Browser automation
- TestNG 7.10.2 - Test framework
- WebDriverManager 5.9.2 - Automatic WebDriver management
- Extent Reports 5.1.1 - Advanced test reporting
- Apache POI 5.4.1 - Excel file handling
- Apache POI OOXML 5.4.1 - Modern Excel format support

### Build Tool

- Maven 3.x - Project build and dependency management

## Project Structure

```
99Acres_Syntax_Squad/
├── pom.xml                                    # Maven configuration file
├── testng.xml                                 # TestNG suite configuration
├── README.md                                  # Project documentation
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hackathon/hcl/Acres_Syntax_Squad/
│   │   │       ├── base/
│   │   │       │   └── BasePage.java          # Base class for all page objects
│   │   │       │
│   │   │       ├── pages/
│   │   │       │   ├── HomePage.java          # Home page object with locators and methods
│   │   │       │   ├── PropertyPage.java      # Property detail page object
│   │   │       │   └── SearchResult.java      # Search results page object
│   │   │       │
│   │   │       └── utils/
│   │   │           ├── ConfigReader.java      # Configuration properties reader
│   │   │           ├── DriverFactory.java     # WebDriver initialization and management
│   │   │           ├── ExtentUtil.java        # Extent Reports utility
│   │   │           └── WaitUtil.java          # Explicit wait utilities
│   │   │
│   │   └── resources/
│   │       └── config.properties              # Configuration file
│   │
│   └── test/
│       ├── java/
│       │   └── com/hackathon/hcl/Acres_Syntax_Squad/
│       │       ├── basetest/
│       │       │   └── BaseTest.java          # Base test class with setup and teardown
│       │       │
│       │       ├── listener/
│       │       │   └── ExtentListener.java    # TestNG listener for Extent Reports
│       │       │
│       │       └── tests/
│       │           └── PropertySearchTest.java # Main test class
│       │
│       └── resources/
│           └── TestData/                      # Test data directory
│
├── target/                                    # Compiled classes and build artifacts
│   ├── classes/                               # Main compiled classes
│   ├── test-classes/                          # Test compiled classes
│   └── ...
│
├── reports/                                   # Extent Reports output
│   ├── ExtentReport_20260525_155605.html
│   ├── ExtentReport_20260525_162318.html
│   └── ExtentReport_20260525_164052.html
│
└── test-output/                               # TestNG output directory
    ├── index.html
    ├── emailable-report.html
    └── junitreports/
```

## Configuration

### config.properties

The configuration file located at `src/main/resources/config.properties` contains application settings:

```properties
browser=chrome                    # Browser to use for testing
baseUrl=https://www.99acres.com/ # Application base URL
timeout=15                        # Timeout in seconds for waits
location=Hyderabad                # Default location for property search
```

## Component Details

### Base Classes

#### BasePage.java
Base class for all page objects that provides common functionality:
- WebDriver and WebDriverWait initialization
- Wait methods: waitForVisibility(), waitForClickability()
- Element interaction methods: clickElement(), enterText(), getElementText()
- Element verification: isElementDisplayed()
- Page utilities: getCurrentPageUrl(), getPageTitle()

#### BaseTest.java
Base test class that handles test lifecycle:
- setUp(): Initializes WebDriver before each test
- tearDown(): Closes WebDriver after each test
- Handles browser initialization and window maximization

### Page Objects

#### HomePage.java
Manages home page interactions:
- Cookie acceptance handling
- Buy option selection
- Location search input and suggestion selection
- Bedroom filter selection (2 BHK option)
- Search button execution
- Returns SearchResult page object

#### SearchResult.java
Manages search results page:
- Opens first property from search results
- Handles stale element exceptions with retry logic
- Switches to new tab for property details
- Returns PropertyPage object

#### PropertyPage.java
Manages property detail page:
- Popup handling
- Property name extraction
- Property location extraction
- Page title retrieval

### Utility Classes

#### DriverFactory.java
Manages WebDriver instances:
- ThreadLocal storage for parallel execution support
- Chrome driver initialization
- Implicit wait configuration
- Driver lifecycle management

#### ConfigReader.java
Reads configuration properties:
- Loads config.properties file at class initialization
- Provides methods to retrieve configuration values
- Static methods for easy access: getBrowser(), getBaseUrl(), getTimeout(), getLocation()

#### ExtentUtil.java
Manages Extent Reports:
- Report initialization and configuration
- Report instance retrieval
- Report generation and flushing

#### WaitUtil.java
Provides wait utility methods:
- Explicit waits for various element conditions
- Timeout handling and synchronization

### Listeners

#### ExtentListener.java
TestNG listener for reporting:
- onStart(): Log test suite start
- onTestStart(): Create test node in report
- onTestSuccess(): Mark test as passed
- onTestFailure(): Log failure details
- onTestSkipped(): Log skipped tests
- onFinish(): Generate final report

## Test Case Details

### PropertySearchTest.java

The main test case demonstrates an end-to-end property search flow:

Test Method: `testPropertySearchFlow()`

Flow:
1. Accept cookies on home page
2. Click Buy option
3. Enter location (Hyderabad from config)
4. Select first location suggestion
5. Reopen search panel
6. Open bedroom filter dropdown
7. Select 2 BHK option
8. Click search button
9. Open first property from results
10. Handle popup if displayed
11. Extract and print property details:
    - Property name
    - Property location
    - Page title

## Running Tests

### Prerequisites

- Java 8 or higher
- Maven 3.x
- Chrome browser (WebDriver automatically managed)
- Internet connection

### Command Line Execution

Run all tests:
```bash
mvn clean test
```

Run specific test class:
```bash
mvn clean test -Dtest=PropertySearchTest
```

Run with TestNG XML configuration:
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### IDE Execution (Eclipse)

1. Right-click on testng.xml in Project Explorer
2. Select "Run As" → "TestNG Suite"
3. Or right-click on PropertySearchTest.java → "Run As" → "TestNG Test"

## Test Reports

### Extent Reports

Detailed HTML reports are generated after test execution:
- Location: `reports/` directory
- File naming: `ExtentReport_YYYYMMDD_HHMMSS.html`
- Contains test status, screenshots, and detailed logs

### TestNG Reports

Standard TestNG reports are generated automatically:
- Location: `test-output/` directory
- Contains test summary, results, and execution details

## Design Patterns Used

### Page Object Model (POM)
- Separates page logic from test logic
- Each web page represented by a separate class
- Locators and methods grouped in respective page objects
- Improves maintainability and reusability

### Fluent Interface Pattern
- Method chaining for intuitive test writing
- Methods return page object instances
- Improves code readability

### Factory Pattern
- DriverFactory handles WebDriver creation and management
- Centralized driver initialization logic

### Listener Pattern
- ExtentListener implements TestNG ITestListener interface
- Automatically captures test events for reporting

## Key Concepts

### ThreadLocal WebDriver
Supports parallel test execution by maintaining separate driver instances per thread:
```java
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
```

### Retry Logic
SearchResult page implements retry logic for stale element handling:
- Attempts element click up to 3 times
- Handles StaleElementReferenceException gracefully

### Fluent Wait Pattern
BasePage implements explicit waits for better synchronization:
- Element visibility checks
- Element clickability verification

### Configuration-Driven Execution
Tests read configuration from properties file:
- Browser selection
- Base URL
- Timeout values
- Location data

## Error Handling

The framework includes comprehensive error handling:
- Cookie popup exceptions handled gracefully
- Stale element reference exceptions with retry logic
- Popup handling with try-catch blocks
- Configuration loading errors with meaningful messages

## Best Practices Implemented

1. Separation of Concerns: Clear separation between test logic and page logic
2. DRY Principle: Common functionality in base classes
3. Configuration Externalization: Settings in properties file
4. Logging: System output for test execution tracking
5. Wait Strategies: Explicit waits instead of hard waits
6. Exception Handling: Graceful handling of expected exceptions
7. Resource Management: Proper driver lifecycle management
8. Reporting: Comprehensive test reporting with Extent Reports

## Future Enhancements

- Add data-driven testing with Apache POI
- Implement more property filter options
- Add screenshot capture on test failures
- Create additional test scenarios for edge cases
- Add performance testing capabilities
- Implement API testing alongside UI testing
- Add CI/CD pipeline integration

## Troubleshooting

### Common Issues

1. WebDriver not found
   - Solution: WebDriverManager automatically handles this
   - Ensure Chrome browser is installed

2. Timeout exceptions
   - Solution: Increase timeout value in config.properties
   - Check if elements are dynamically loaded

3. Stale element reference
   - Solution: Retry logic implemented in SearchResult class
   - Ensure proper wait conditions

4. Cookie popup not displayed
   - Solution: Exception is caught and logged
   - Test continues without clicking cookie button

## Contact and Support

Project: 99Acres Syntax Squad Hackathon
Organization: HCL Technologies
