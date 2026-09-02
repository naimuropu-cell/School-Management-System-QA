-- ============================================================
-- STUDENT MODULE - SQL VALIDATION QUERIES
-- Validate student data integrity against the QA database.
-- Cross-checks UI behavior covered by automation (Phase 4).
-- ============================================================

-- Verify total active student count (matches dashboard/list totals)
SELECT COUNT(*) AS total_active_students
FROM students
WHERE status = 'active';

-- Verify duplicate admission numbers (should return none)
SELECT admission_no, COUNT(*) AS cnt
FROM students
GROUP BY admission_no
HAVING COUNT(*) > 1;

-- Students grouped by class and section
SELECT c.class_name, s.section_name, COUNT(st.id) AS student_count
FROM students st
JOIN classes c      ON st.class_id = c.id
JOIN sections s     ON st.section_id = s.id
WHERE st.status = 'active'
GROUP BY c.class_name, s.section_name
ORDER BY c.class_name, s.section_name;

-- Student demographic breakdown (for report validation)
SELECT
    SUM(CASE WHEN gender = 'Male'   THEN 1 ELSE 0 END) AS male_count,
    SUM(CASE WHEN gender = 'Female' THEN 1 ELSE 0 END) AS female_count,
    COUNT(*) AS total
FROM students
WHERE status = 'active';

-- Students without an assigned class or section (data quality check)
SELECT id, admission_no, student_name
FROM students
WHERE class_id IS NULL OR section_id IS NULL;

-- Re-enrolled / inactive students
SELECT id, admission_no, student_name, status
FROM students
WHERE status <> 'active';

-- ============================================================
-- End of Student SQL
-- ============================================================
