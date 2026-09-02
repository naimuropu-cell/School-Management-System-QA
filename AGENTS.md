# AGENTS.md

QA portfolio repo for a School Management System (documentation + Selenium automation). No CI, no lint/format config, no `.gitignore`. There is only one piece of buildable code: the Maven project at `10_Automation/SeleniumFramework`.

## Layout

- Numbered folders `01_Project_Overview` … `14_User_Guide` contain QA artifacts (Markdown + `.xlsx`). `README.md` at root maps each folder.
- Test cases and checklists live in `.xlsx` files (e.g. `04_Test_Cases/Admin.xlsx`, `06_Regression_Suite/Regression_Checklist.xlsx`), not Markdown. Bug reports are Markdown: `05_Bug_Reports/Bug-NNN.md` using a fixed template (Bug ID, Module, Steps to Reproduce, Severity, Priority, Status, QA Comments…).
- `09_API_Testing/` has a Postman collection (`School_Management_API.postman_collection.json`); Newman is the stated runner but there is no script/collection runner config.
- `10_Automation/` = automation docs, Evidence/, Execution/, and the actual framework.
- Folders `11_SQL`, `12_Test_Data`, and `14_User_Guide` are empty.

## Selenium framework (`10_Automation/SeleniumFramework`)

- Stack: Java 17, Maven, TestNG 7.11, Selenium 4.34, WebDriverManager, POM pattern (pages/ / base/ / utilities/ / tests/). Also pulls in Apache POI 5.4.1 and Extent Reports 5.1.2 as dependencies, though neither is used in source yet.
- **Run tests from inside the framework directory** only: `mvn test`. `ConfigReader` loads `config.properties` via a relative path (`src/main/resources/config.properties`), so running from the repo root breaks it. Surefire is bound to `testng.xml`, which currently runs only `tests.LoginTest`; to run one test use e.g. `mvn test -Dtest=LoginTest`.
- Tests execute against a **live external site** (`https://edu.yesbangladesh.net`) using real credentials in `config.properties`. No test data seeding or mock server — the site must be up and creds valid.
- Framework is early-stage: only `LoginTest` exists. `Automation_Test_Plan.md` and `Execution/TestExecutionSummary.md` are empty stubs.
- `DriverFactory` only supports Chrome; other browser values throw a `RuntimeException`.
- Wait timeouts: `WaitHelper` uses a hardcoded 15-second explicit wait. The `implicitWait` and `pageLoadTimeout` keys in `config.properties` are defined but never read by any code.
- `DashboardPage` does not extend `BasePage` (unlike `LoginPage` and `MenuPage`), so it lacks the `click()`/`type()`/`getText()` helpers.
- **`target/` (compiled classes, surefire reports, dumpstreams) is committed to git** and there is no `.gitignore`. Avoid touching/committing `target/`, `reports/`, `screenshots/` churn; don't run `mvn clean` (it deletes tracked files and produces a dirty tree). Revert `target/` changes after runs rather than committing them.

## Conventions

- Docs use `---` horizontal-rule section separators with `##` headings (see any `Bug-NNN.md`).
- Bug report filenames are inconsistent: most use `Bug-NNN.md` but `BUG-013.md` and `BUG-014.md` use uppercase. The ID inside the file always uses `BUG-NNN`.
- Bug ID format is `BUG-NNN`; severity/priority are standalone headings (e.g. `**Critical**`).
- Commits are small and feature-scoped; author is a single-person portfolio repo. Follow existing commit-message style (short, e.g. "Login page Automation- success").
