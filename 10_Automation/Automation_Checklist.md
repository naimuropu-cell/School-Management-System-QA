# Automation Checklist

## Phase Coverage

| Phase | Module | Test Class | Test Methods | Groups | Status |
|-------|--------|-----------|--------------|--------|--------|
| 1 | Login | LoginTest | validAdminLogin | — | Completed |
| 2 | Login | RoleLoginTest | validAdminLogin, validTeacherLogin, validStudentLogin, validAccountantLogin | smoke, regression | Completed |
| 2 | Dashboard | DashboardTest | adminDashboardIsDisplayed, teacherDashboardIsDisplayed, studentDashboardIsDisplayed, accountantDashboardIsDisplayed | smoke | Completed |
| 3 | Navigation | NavigationTest | navigateToStudentList, navigateToClasses, navigateToSections, navigateToHomeworks | smoke | Completed |
| 4 | Student | StudentTest | navigateToStudentList, studentListSearchBoxDisplayed, studentListTableDisplayed, studentListAddButtonDisplayed, studentSearchByName | smoke, regression | Completed |
| 5 | Academics | AcademicsTest | navigateToClassList, classListSearchBoxDisplayed, classListTableDisplayed, classListAddButtonDisplayed, navigateToSectionList, sectionListTableDisplayed, classSearch | smoke, regression | Completed |
| 6 | Fees | FeesTest | navigateToFeeStructure, feeStructureSearchBoxDisplayed, feeStructureTableDisplayed, feeStructureAddButtonDisplayed, navigateToFeeCollection, navigateToFeeAssignment, navigateToFeeReport, feeStructureSearch | smoke, regression | Completed |

---

## Group Distribution

| Group | Test Count | Modules |
|-------|-----------|---------|
| smoke | 26 | Login, Dashboard, Navigation, Student, Academics, Fees |
| regression | 4 | Login, Student, Academics, Fees |
| (default) | 1 | Login |

---

## Total

- **7 test classes**
- **33 test methods**
- **6 modules automated**

---

Prepared by

**Naimur Rahman**
Software QA Engineer
