# SQL Validation

SQL queries used for database validation during QA testing.

---

## Sample Queries

### Verify Student Count

```sql
SELECT COUNT(*) AS total_students
FROM students
WHERE status = 'active';
```

### Verify Duplicate Admission Number

```sql
SELECT admission_no, COUNT(*) AS cnt
FROM students
GROUP BY admission_no
HAVING COUNT(*) > 1;
```

### Verify Student Fee Assignment

```sql
SELECT s.id, s.student_name, fs.fee_type, fs.amount
FROM students s
JOIN student_fees sf ON s.id = sf.student_id
JOIN fee_structures fs ON sf.fee_id = fs.id
WHERE s.status = 'active';
```

### Verify Attendance Records

```sql
SELECT student_id, DATE(attendance_date) AS date, status
FROM attendances
WHERE attendance_date >= CURDATE() - INTERVAL 7 DAY
ORDER BY attendance_date DESC;
```

---

## Usage

These queries are executed against the QA MySQL database to validate data integrity after CRUD operations and cross-check application behavior.

---

Prepared by

**Naimur Rahman**
Software QA Engineer
