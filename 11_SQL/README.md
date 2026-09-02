# SQL Validation

SQL queries used for database validation during QA testing.

---

## Files

| File | Module | Validates |
|------|--------|-----------|
| `schema.sql` | Reference | Core tables & columns used by all queries |
| `01_Students.sql` | Student | Counts, duplicates, class/section grouping |
| `03_Attendance.sql` | Attendance | Records, attendance %, duplicate/missing dates |
| `04_Fees.sql` | Fees | Structures, assignments, collections, defaulters |
| `05_Inventory.sql` | Inventory | Items, stock levels, low stock, issue/receive |

---

## Usage

Each file is a self-contained set of `--`-annotated queries executed against the
QA MySQL database to validate data integrity after CRUD operations and
cross-check the behavior asserted by the Selenium automation suite.

Run files together or one query at a time; adapt table/column names to the
actual QA database if they differ from `schema.sql`.

---

Prepared by

**Naimur Rahman**
Software QA Engineer
