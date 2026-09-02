# Attendance Test Data

Sample attendance records used for QA validation. Column names align with
`11_SQL/schema.sql` and the queries in `11_SQL/03_Attendance.sql`.

---

## Daily Attendance Marks

| Date | Status | Admission No | Scenario |
|------|--------|--------------|----------|
| 2026-09-01 | present | ADM-0001 | Normal daily mark |
| 2026-09-01 | absent | ADM-0002 | Normal daily mark |
| 2026-09-01 | late | ADM-0003 | Normal daily mark |
| 2026-09-01 | present | ADM-0004 | Normal daily mark |

---

## Mixed / All-Present / All-Absent

| Scenario | Data | Expected Result |
|----------|------|-----------------|
| All students present | All marks = present | TS-ATT-002 |
| All students absent | All marks = absent | TS-ATT-003 |
| Mixed attendance | Combination of present/absent/late | TS-ATT-004 |

---

## Date Rule Cases

| Case | Data | Expected Result |
|------|------|-----------------|
| Attendance by date | Filter on a specific date | TS-ATT-011 |
| Future date | Date after today | Rejected (TS-ATT-012) |
| Previous date | A past date | Allowed (TS-ATT-013) |
| Duplicate mark | Same student + same date twice | Rejected (TS-ATT-008) |
| Missing date | Active student with no mark today | Flagged as data gap |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
