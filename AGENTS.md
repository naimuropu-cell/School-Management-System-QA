# AGENTS.md

QA portfolio repo for a School Management System (documentation + Selenium automation). No CI, no lint/format config. There is only one piece of buildable code: the Maven project at `10_Automation/SeleniumFramework`.

## Layout

- Numbered folders `01_Project_Overview` … `14_User_Guide` contain QA artifacts (Markdown + `.xlsx`). `README.md` at root maps each folder.
- Test cases and checklists live in `.xlsx` files (e.g. `04_Test_Cases/Admin.xlsx`, `06_Regression_Suite/Regression_Checklist.xlsx`), not Markdown. Bug reports are Markdown: `05_Bug_Reports/Bug-NNN.md` using a fixed template (Bug ID, Module, Steps to Reproduce, Severity, Priority, Status, QA Comments…).
- `09_API_Testing/` has a Postman collection (`School_Management_API.postman_collection.json`); Newman is the stated runner but there is no script/collection runner config.
- `10_Automation/` = automation docs, Evidence/, Execution/, and the actual framework.
- Folders `11_SQL`, `12_Test_Data`, and `14_User_Guide` are empty.

## Selenium framework (`10_Automation/SeleniumFramework`)

- Stack: Java 17, Maven, TestNG 7.11, Selenium 4.34, WebDriverManager 6.1.0, POM pattern (pages/ / base/ / utilities/ / tests/). Apache POI and Extent Reports are in `pom.xml` but unused in source.
- **Run from inside the framework directory only**: `mvn test`. `ConfigReader` loads `config.properties` via a relative path (`src/main/resources/config.properties`), so running from the repo root breaks it.
- Surefire is bound to `testng.xml`, which runs 4 test classes: `LoginTest`, `RoleLoginTest`, `DashboardTest`, `NavigationTest`. `DomInspect` is a diagnostic utility (group `inspect`), not a real test.
- Run a single test: `mvn test -Dtest=LoginTest`. Run a group: `mvn test -Dgroups=smoke` (groups: `smoke`, `sanity`, `regression`, `inspect`).
- Tests execute against a **live external site** (`https://edu.yesbangladesh.net`) using real credentials in `config.properties`. No test data seeding or mock server — the site must be up and creds valid.
- `DriverFactory` only supports Chrome; other browser values throw a `RuntimeException`.
- Wait timeouts: `WaitHelper` uses a hardcoded 15-second explicit wait. `implicitWait` and `pageLoadTimeout` in `config.properties` are defined but never read by any code.
- `BaseTest` provides convenience login methods (`loginAsAdmin()`, `loginAsTeacher()`, `loginAsStudent()`, `loginAsAccountant()`) that delegate to `LoginHelper`.
- All page classes (`LoginPage`, `MenuPage`, `DashboardPage`) extend `BasePage`, which provides `click()`, `type()`, `getText()`, and `isDisplayed()` helpers.
- `.gitignore` covers `target/`, `reports/`, `screenshots/`. Don't commit build output or test artifacts.

## Conventions

- Docs use `---` horizontal-rule section separators with `##` headings (see any `Bug-NNN.md`).
- Bug report filenames are inconsistent: most use `Bug-NNN.md` but `BUG-013.md` and `BUG-014.md` use uppercase. The ID inside the file always uses `BUG-NNN`.
- Bug ID format is `BUG-NNN`; severity/priority are standalone headings (e.g. `**Critical**`).
- Commits are small and feature-scoped; author is a single-person portfolio repo. Follow existing commit-message style (short, e.g. "Login page Automation- success").
