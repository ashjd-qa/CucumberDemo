# TransLink Automation Testing Homework (Java + Selenium + Cucumber BDD)

## Overview
This project automates a real-world user journey on the TransLink website using Selenium and Java. The test covers searching for a bus route, updating the schedule filters, and adding a stop to favourites. It verifies that the user can find the “#99 – UBC B-Line” route, set the date and time filters, select stop #50913, add it to favourites as “99 UBC B-Line – Morning Schedule,” and confirm it appears under “Manage my favourites.”

Automated test scenarios using **Cucumber BDD** and **Selenium WebDriver** in Java.  
It is designed as part of a QA Automation assessment.
The project follows the **Page Object Model (POM)** structure to keep code reusable and maintainable.


## Tech Stack
- Java 17+
- Selenium WebDriver
- Cucumber BDD
- JUnit
- Maven
- Eclipse IDE

---

## Project Structure
CucumberDemo/
│
├── features/ # Feature files for test scenarios
├── stepDefinitions/ # Step definition files
├── pageObjects/ # Page Object Model classes
├── TestRunner.java # Main Cucumber Test Runner
├── pom.xml # Maven configuration file
├── target/ # Reports (generated after running tests)
└── README.md # Project documentation



---

## Prerequisites
Before running the project, make sure you have:

1. **Java JDK 17+** installed and configured in Eclipse
2. **Maven** installed (or use Eclipse’s built-in Maven)
3. **Chrome browser** installed
4. **ChromeDriver** matching your Chrome version (or set up via WebDriverManager)

---

## How to Run the Tests in Eclipse

1. Open **Eclipse IDE**
2. Go to **File → Import → Existing Maven Projects**
3. Select your project folder (`CucumberDemo`) and click **Finish**
4. Open `TestRunner.java`  
5. Right-click → **Run As → JUnit Test**  
6. Test execution will start, and Selenium will open the browser automatically

---

## Generating Reports
- After running the tests, reports are generated in the `target/` folder  
- Open `target/cucumber-reports.html` to view a readable HTML report

---

## Notes
- The project uses **Page Object Model** for better code maintainability
- Tests are written in **Gherkin syntax** (feature files)
- All dependencies are managed via **Maven** (`pom.xml`)

---

## Author
**Ayesha Javed**  
📧 [ayesha.javed6427@live.com]  
🔗 [GitHub Repository](https://github.com/ashjd-qa/CucumberDemo)
