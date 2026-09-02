# Automation

Selenium WebDriver automation suite for the School Management System.

---

## Framework Stack

| Component | Version |
|-----------|---------|
| Java | 17 |
| Maven | 3.x |
| Selenium WebDriver | 4.34.0 |
| TestNG | 7.11.0 |
| WebDriverManager | 6.1.0 |
| Extent Reports | 5.1.2 |
| Apache POI | 5.4.1 |

---

## Architecture

Page Object Model (POM) pattern with base classes, helpers, and utilities.

```
SeleniumFramework/
├── src/main/java/
│   ├── base/          BasePage, BaseTest
│   ├── helpers/       LoginHelper
│   ├── pages/         LoginPage, DashboardPage, MenuPage, StudentPage, AcademicsPage, AttendancePage, FeePage, InventoryPage
│   └── utilities/     ConfigReader, DriverFactory, WaitHelper, ScreenshotUtil
├── src/test/java/
│   ├── listeners/     TestListener
│   └── tests/         LoginTest, RoleLoginTest, DashboardTest, NavigationTest, StudentTest, AcademicsTest, AttendanceTest, FeesTest, InventoryTest
├── src/main/resources/
│   └── config.properties
└── testng.xml
```

---

## Test Modules

| Module | Test Class | Test Count | Groups |
|--------|-----------|------------|--------|
| Login | LoginTest | 1 | (default) |
| Login | RoleLoginTest | 4 | smoke, regression |
| Dashboard | DashboardTest | 4 | smoke |
| Navigation | NavigationTest | 4 | smoke |
| Student | StudentTest | 5 | smoke, regression |
| Academics | AcademicsTest | 7 | smoke, regression |
| Attendance | AttendanceTest | 8 | smoke, regression |
| Fees | FeesTest | 8 | smoke, regression |
| Inventory | InventoryTest | 8 | smoke, regression |

**Total:** 49 test methods across 9 test classes.

---

## How to Run

Run from inside `SeleniumFramework/` directory only:

```bash
# Full suite
mvn test

# Single test class
mvn test -Dtest=LoginTest

# By group
mvn test -Dgroups=smoke
mvn test -Dgroups=regression
mvn test -Dgroups=smoke,regression
```

**Note:** `ConfigReader` uses a relative path (`src/main/resources/config.properties`), so running from the repo root will fail.

---

## TestNG Groups

| Group | Purpose | Test Count |
|-------|---------|------------|
| smoke | Core navigation and visibility checks | 41 |
| regression | Deeper validation | 6 |
| (default) | Unclassified tests | 1 |

---

## Reports

Extent Reports are generated in `reports/ExtentReport.html` after each run. Screenshots on failure are saved to `screenshots/`.

---

## Configuration

All credentials and URLs are stored in `src/main/resources/config.properties`. The application runs against a live QA environment.

---

## Project Phases

| Phase | Scope | Status |
|-------|-------|--------|
| Phase 1 | Environment setup + Login | Completed |
| Phase 2 | Role-based login + Dashboard | Completed |
| Phase 3 | Navigation to key pages | Completed |
| Phase 4 | Student Module | Completed |
| Phase 5 | Academics (Class & Section) | Completed |
| Phase 6 | Fees / Finance | Completed |
| Phase 7 | Attendance | Completed |
| Phase 8 | Inventory | Completed |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
