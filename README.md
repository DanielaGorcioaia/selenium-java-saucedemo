# SauceDemo Automation Project

Overview
--------
Automation testing for [SauceDemo](https://www.saucedemo.com) using Selenium WebDriver, Java, JUnit, and Eclipse.  
Tests main functionalities: login, product selection (sort/add/remove), and checkout.

Tech Stack
----------
- Java, Selenium, JUnit, Eclipse IDE  
- Page Object Model (POM) design pattern  
- JSON for test data  

Project Structure
-----------------
selenium-java-saucedemo/
├── src/
│ ├── pages/ # Page object classes
│ ├── source/ # URL
│ ├── testData/ # JSON & classes
│ ├── tests/ # JUnit test classes
│ └── utils/ # Utility classes
├── docs/ # PPT project presentation, including test results
├── .gitignore
└── README.md

Running Tests
-------------
1. Open in Eclipse, ensure all libraries are referenced.  
2. Right-click the `tests` package → **Run As → JUnit Test**.  
3. Results appear in Eclipse. 

Notes
-----
- Follows POM for readability and maintainability.  
- No sensitive credentials committed.  
- Easy to add new tests and test data.