**1. Project Overview:**

# OpenCart E-Commerce Automation Framework

A hybrid automation framework using Selenium, Java, TestNG, and Cucumber for testing OpenCart e-commerce application.


**2. Features:**

* Smoke, Regression, Integration, E2E, and Negative tests
* Page Object Model (POM) design
* Cross-browser testing (Chrome, Firefox, Edge)
* Jenkins pipeline for CI/CD
* Cucumber reports and screenshots for failures

**3. Tech Stack:**

* Java 11
* Selenium 4
* Cucumber 7
* TestNG 7
* Maven
* Jenkins
* WebDriverManager

**4. Prerequisites:**

* JDK 11 installed
* Maven installed
* ChromeDriver path setup (or WebDriverManager auto setup)
* Jenkins installed (if running CI/CD)
* OpenCart running locally (`http://localhost/opencart/`)

**5. How to Run Locally:**

# Clone repo
git clone https://github.com/Harihareswaran/opencart-automation.git

# Navigate to project
cd opencart-automation

# Run all tests
mvn test

# Run tests with specific Cucumber tags
mvn test -Dcucumber.filter.tags="@Smoke" -Dbrowser=chrome -Durl=http://localhost/opencart/


**6. Jenkins Pipeline:**

* Checkout code from GitHub
* Compile using Maven
* Execute tests with selected browser & tags
* Generate Cucumber reports

**7. Project Structure:**

src/main/java/pages/          # Page objects
src/main/java/utils/          # Utility classes
src/test/java/stepdefinitions/ # Step definitions
src/test/java/hooks/          # Cucumber hooks
src/test/resources/features/  # Cucumber feature files
pom.xml                       # Maven build file
Jenkinsfile                   # CI/CD pipeline

**8. Screenshots & Reports:**

* Screenshots stored in `reports/screenshots/`
* HTML & JSON Cucumber reports in `reports/`

**9. Notes / Improvements:**

* Handle multiple browsers in parallel
* Add more negative scenarios
* Integrate Extent Reports




