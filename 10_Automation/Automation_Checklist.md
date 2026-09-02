# Automation Checklist

## Phase Coverage

| Phase | Module | Test Class | Test Methods | Groups | Status |
|-------|--------|-----------|--------------|--------|--------|
| 1 | Login | LoginTest | validAdminLogin | — | Completed |
| 2 | Login | RoleLoginTest | validAdminLogin, validTeacherLogin, validStudentLogin, validAccountantLogin | smoke, regression | Completed |
| 2 | Dashboard | DashboardTest | adminDashboardIsDisplayed, teacherDashboardIsDisplayed, studentDashboardIsDisplayed, accountantDashboardIsDisplayed | smoke | Completed |
| 3 | Navigation | NavigationTest | navigateToStudentList, navigateToClasses, navigateToSections, navigateToHomeworks | smoke | Completed |
| 4 | Student | StudentTest | navigateToStudentList, studentListSearchBoxDisplayed, studentListTableDisplayed, studentListAddButtonDisplayed, studentSearchByName | smoke, regression | Completed |

---

## Group Distribution

| Group | Test Count | Modules |
|-------|-----------|---------|
| smoke | 13 | Login, Dashboard, Navigation, Student |
| regression | 2 | Login, Student |
| (default) | 1 | Login |

---

## Total

- **5 test classes**
- **18 test methods**
- **4 modules automated**

---

Prepared by

**Naimur Rahman**
Software QA Engineer
