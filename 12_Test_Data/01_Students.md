# Student Test Data

Sample student records used for QA validation. Column names align with
`11_SQL/schema.sql` and the queries in `11_SQL/01_Students.sql`.

---

## Valid Student Records

| Admission No | Student Name | Class | Section | Gender | Status |
|--------------|--------------|-------|---------|--------|--------|
| ADM-0001 | Ayesha Rahman | Class 5 | A | Female | active |
| ADM-0002 | Rahim Uddin | Class 5 | A | Male | active |
| ADM-0003 | Fatima Akter | Class 5 | B | Female | active |
| ADM-0004 | Karim Hossain | Class 6 | A | Male | active |
| ADM-0005 | Nusrat Jahan | Class 6 | B | Female | active |
| ADM-0006 | Tanvir Ahmed | Class 7 | A | Male | active |
| ADM-0007 | Sumaiya Islam | Class 7 | B | Female | active |

---

## Boundary Values

| Case | Data | Expected Result |
|------|------|-----------------|
| Max-length name (100 chars) | A 100-character student name string | Accepted |
| Min-length name (1 char) | "A" | Accepted |
| Empty name | "" | Rejected (mandatory validation) |
| Numeric name | "12345" | Rejected (name validation) |

---

## Data Quality Cases

| Admission No | Scenario | Status |
|--------------|----------|--------|
| ADM-0008 | Duplicate admission number (repeat ADM-0001) | Should be rejected |
| ADM-0009 | Missing class assignment | Data gap flagged |
| ADM-0010 | Missing section assignment | Data gap flagged |
| ADM-0011 | Inactive / left student | `status = 'inactive'` |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
