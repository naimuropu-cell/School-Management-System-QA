# Fees Test Data

Sample fee structures, assignments, and collection records used for QA
validation. Column names align with `11_SQL/schema.sql` and the queries in
`11_SQL/04_Fees.sql`.

---

## Fee Structures

| Fee ID | Fee Type | Amount | Status |
|--------|----------|--------|--------|
| 1 | Tuition | 2500.00 | active |
| 2 | Admission | 3000.00 | active |
| 3 | Library | 500.00 | active |
| 4 | Transport | 1200.00 | active |
| 5 | Sports | 300.00 | inactive |

---

## Student Fee Assignments

| Student | Admission No | Assigned Fees |
|---------|--------------|---------------|
| Ayesha Rahman | ADM-0001 | Tuition, Library |
| Rahim Uddin | ADM-0002 | Tuition, Transport |
| Fatima Akter | ADM-0003 | Tuition, Library, Sports (inactive) |

---

## Collection Records

| Student | Fee Type | Paid | Payment Method | Scenario |
|---------|----------|------|----------------|----------|
| ADM-0001 | Tuition | 2500.00 | Cash | Paid in full |
| ADM-0002 | Tuition | 1500.00 | Card | Partial payment |
| ADM-0003 | Tuition | 0.00 | - | Defaulter / unpaid |
| ADM-0001 | Library | 550.00 | Mobile | Overpayment flagged |
| ADM-0004 | Transport | 1200.00 | Bank | Paid in full |

---

## Validation Cases

| Case | Data | Expected Result |
|------|------|-----------------|
| Duplicate payment | Same student + fee twice | Rejected |
| Mandatory selection | No class / no fee selected | Rejected (TS-FEE-006) |
| Negative amount | -100 | Rejected |
| Zero amount | 0 | Rejected |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
