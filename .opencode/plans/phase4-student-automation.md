# Plan: Phase 4 — Student Module Automation

## Context & constraints
- Tests run against live site (`https://edu.yesbangladesh.net`) with real credentials from `config.properties`.
- Only confirmed-stable student route is `/student-list` (used by `MenuPage.goToStudents()`, `NavigationTest`, and the `DomInspect` diagnostic that dumps its DOM).
- Scope = **Navigation & Student List**, smoke/navigation style, matching the existing framework tests.
- Avoid the broken student-admission workflow (BUG-002/015/016 block completion on the live site).
- Verification = **compile only** (`mvn test-compile` from `10_Automation/SeleniumFramework`). Do not run `mvn test`; results are gitignored. Do not commit `target/`, `reports/`, `screenshots/`.

## Scope decisions (from user Q&A)
- Scope: **Navigation & Student List** (recommended option chosen).
- Verification: **compile only** (`mvn test-compile`).

## Files to create/edit

### 1. NEW `src/main/java/pages/StudentPage.java` (POM extends `BasePage`)
Locators tied to elements `DomInspect` already confirmed on `/student-list`:
- Search box: `By.cssSelector("input[type='search']")`
- Table: `By.cssSelector("table")`, rows `By.cssSelector("tbody tr")`
- Pagination: `By.cssSelector(".dataTables_paginate, .pagination")`
- Add button: tolerant `By.xpath("//a[contains(normalize-space(),'Add')]")` (exact text not yet verified)

Helpers (use `BasePage` `getCurrentUrl()`, `isDisplayed()`; `driver.get(...)` for navigation like MenuPage):
- `goToStudentList()` — `driver.get(baseUrl + "/student-list")`
- `isStudentListDisplayed()` — URL contains `/student-list`
- `isSearchBoxDisplayed()` / `isTableDisplayed()` / `isPaginationDisplayed()` / `isAddButtonDisplayed()`
- `getRowCount()` — returns count of `tbody tr`
- `searchStudent(String)` — type into search box

### 2. NEW `src/test/java/tests/StudentTest.java` (extends `BaseTest`)
Lifecycle mirrors existing tests: `@BeforeMethod(alwaysRun=true)` → `setUp()`, `@AfterMethod(alwaysRun=true)` → `tearDown()`. Initialize `StudentPage` (add a field / helper — see notes).
- `@Test(groups={"smoke"}) navigateToStudentList` — login admin, `goToStudents()` from MenuPage, assert `isStudentListDisplayed()` and title contains "Student List" (maps TS-STU-016/017).
- `@Test(groups={"smoke"}) studentListSearchBoxDisplayed` — login admin, navigate, assert `isSearchBoxDisplayed()` (TS-STU-019).
- `@Test(groups={"smoke"}) studentListTableDisplayed` — assert `isTableDisplayed()` and `getRowCount() >= 0` (TS-STU-016/019).
- `@Test(groups={"smoke"}) studentListAddButtonDisplayed` — assert `isAddButtonDisplayed()` (TS-STU-054 / Save/Add button visibility).
- `@Test(groups={"regression"}) studentSearchByName` — navigate, `searchStudent("...")`, assert search box retains value (tolerant; DataTable re-renders server-side) (TS-STU-063).

Each method gets a one-line `// Ref: TS-STU-XXX` comment.

### 3. EDIT `src/main/java/base/BaseTest.java`
No change required if StudentPage is constructed directly in the test via `new StudentPage(driver)` (pattern matches how `LoginHelper` wraps `LoginPage`; `BasePage`/pages are constructed with `driver`). Add `protected StudentPage studentPage;` and init in `setUp()` only if a shared instance is desired to match `dashboardPage`/`menuPage` convention.

### 4. EDIT `testng.xml`
Add a new `<test name="Student Module">` containing `<class name="tests.StudentTest"/>`, after the existing "Navigation Module" block, matching the current suite grouping style.

## Verification
- From `10_Automation/SeleniumFramework`: `mvn test-compile` must succeed.
- Confirm no `target/` churn is committed.

## Out of scope / flagged
- Full student CRUD and Admission forms (broken on live site / unseeded data).
- Exact Add-button locator and any extra routes (`/student-view`, `/add-student`) are NOT verified — confirm against live DOM via `DomInspect` if needed; otherwise keep to tolerant/skip.
- No `AGENTS.md` changes unless a genuinely wrong convention surfaces (not expected).
