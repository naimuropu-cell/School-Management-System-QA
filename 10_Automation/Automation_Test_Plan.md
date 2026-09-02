# Automation Test Plan

## Project

School Management System

---

## Objective

Automate critical smoke and regression test cases using Selenium WebDriver to validate core application functionality across all user roles and key modules.

---

## Scope

### In Scope

- Login and role-based authentication
- Dashboard verification per role
- Navigation to key pages (Student List, Classes, Sections, Homework)
- Student List page elements (search, table, pagination, add button)

### Out of Scope

- Student Admission form automation (blocked by live site bugs)
- Data-driven testing with external data sources
- Mobile and cross-browser testing (Chrome only)
- Performance and load testing
- API automation (covered by Postman/Newman)

---

## Approach

- Framework: Page Object Model (POM) with TestNG
- Browser: Chrome (managed by WebDriverManager)
- Environment: Live QA site (`edu.yesbangladesh.net`)
- Test data: Real credentials stored in `config.properties`
- Reporting: Extent Reports + Surefire HTML reports

---

## Entry Criteria

- QA environment is accessible
- Test credentials are valid
- Chrome browser is installed
- Maven and Java 17 are available

---

## Exit Criteria

- All smoke test cases pass
- No critical blocker issues
- Regression suite completes without failure

---

## TestNG Groups

| Group | Description | When to Run |
|-------|-------------|-------------|
| smoke | Core navigation and visibility checks | Every build |
| regression | Deeper validation scenarios | Pre-release |
| sanity | Critical path validation | Post-fix verification |

---

## Test Case Mapping

| Test Class | Methods | Scenario IDs |
|-----------|---------|--------------|
| LoginTest | validAdminLogin | — |
| RoleLoginTest | validAdminLogin, validTeacherLogin, validStudentLogin, validAccountantLogin | — |
| DashboardTest | adminDashboardIsDisplayed, teacherDashboardIsDisplayed, studentDashboardIsDisplayed, accountantDashboardIsDisplayed | — |
| NavigationTest | navigateToStudentList, navigateToClasses, navigateToSections, navigateToHomeworks | — |
| StudentTest | navigateToStudentList, studentListSearchBoxDisplayed, studentListTableDisplayed, studentListAddButtonDisplayed, studentSearchByName | TS-STU-016, TS-STU-017, TS-STU-019, TS-STU-054, TS-STU-063 |

---

## Risks

- Live site availability may cause flaky test results
- Admission form bugs (BUG-002/015/016) block full student workflow automation
- Credential changes require config.properties update

---

Prepared by

**Naimur Rahman**
Software QA Engineer
