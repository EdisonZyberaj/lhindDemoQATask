# DemoQA Selenium Test Automation Framework

## Overview
This project is a comprehensive Selenium-based test automation framework designed to test various UI components of the DemoQA website (https://demoqa.com/). The framework follows the Page Object Model (POM) design pattern, providing a structured and maintainable way to organize UI automation tests.

## Features
- **Page Object Model (POM)**: Each page is represented by its own class that encapsulates the page's elements and actions
- **Test Reports**: Integration with ExtentReports for detailed HTML test reports
- **JavaScript Utilities**: Helper methods for complex browser interactions
- **Modular Structure**: Well-organized project structure with clear separation of concerns

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- ExtentReports
- Maven

## Project Structure

### Page Objects
- **BasePage**: Core page class with common page operations
- **AlertsPage**: Handles alerts-related functionality
- **ButtonPage**: Manages button interactions
- **DragAndDrop**: Implements drag and drop functionality
- **Form**: Handles form submissions
- **PractiseFormPage**: Complex form interaction implementation
- **Slider**: Manages slider component interactions

### Test Classes
- **BaseTest**: Parent test class with common setup and teardown methods
- **AlertsTest**: Tests for alert interactions
- **ButtonsTest**: Tests for button clicks (single, double, right)
- **DragAndDropTest**: Tests for drag and drop operations
- **FormTest**: Tests for forms on techlistic.com
- **PractiseFormPageTest**: Tests for student registration form
- **TestSlider**: Tests for slider component

### Utilities
- **ExtentReportManager**: Manages test reporting
- **JavaScriptUtils**: Provides JavaScript execution capabilities

## Setup and Execution

### Prerequisites
- Java JDK 8 or higher
- Maven
- Chrome Browser (latest version)
- ChromeDriver matching your Chrome browser version

### Installation
1. Clone the repository:
   ```
   git clone https://github.com/yourusername/Lhind-SeleniumTask2.git
   ```
2. Navigate to the project directory:
   ```
   cd Lhind-SeleniumTask2
   ```
3. Install dependencies:
   ```
   mvn clean install
   ```

### Running Tests
- Run all tests:
  ```
  mvn test
  ```
- Run a specific test class:
  ```
  mvn test -Dtest=TestClassName
  ```

## Implemented Test Cases

### Alerts
- Confirm alert accept
- Prompt alert with text input

### Buttons
- Double click functionality

### Drag and Drop
- Standard drag and drop operation
- Drag and drop using offset

### Forms
- Form submission with various input types
- Student registration form with required fields only
- Student registration form with all fields

### Slider
- Slider interaction and value verification

## Reports
Test reports are generated after test execution and stored in the `reports` directory. The report name format is:
```
Test-Report-YYYY-MM-DDThh-mm-ss.html
```

## Screenshots
Test failure screenshots are captured automatically and embedded in the test reports.

## Best Practices Implemented
- Explicit waits for handling dynamic elements
- Page object encapsulation for better maintainability
- JavaScript execution for complex browser interactions
- Proper exception handling
- Detailed reporting

## Known Limitations
- Tests are currently configured to run only on Chrome browser
- Some elements might need to be updated if the DemoQA website changes
- Requires internet connection to access the DemoQA website
