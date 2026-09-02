-- ============================================================
-- ATTENDANCE MODULE - SQL VALIDATION QUERIES
-- Validate attendance records against the QA database.
-- Cross-checks UI behavior covered by automation (Phase 7).
-- ============================================================

-- Verify recent attendance records (last 7 days)
SELECT student_id, DATE(attendance_date) AS date, status
FROM attendances
WHERE attendance_date >= CURDATE() - INTERVAL 7 DAY
ORDER BY attendance_date DESC, student_id;

-- Attendance summary per student (present vs total, %)
SELECT
    a.student_id,
    s.student_name,
    COUNT(*) AS total_marks,
    SUM(CASE WHEN a.status = 'present' THEN 1 ELSE 0 END) AS present_days,
    ROUND(
        SUM(CASE WHEN a.status = 'present' THEN 1 ELSE 0 END) / COUNT(*) * 100, 2
    ) AS attendance_pct
FROM attendances a
JOIN students s ON a.student_id = s.id
GROUP BY a.student_id, s.student_name
ORDER BY attendance_pct ASC;

-- Duplicate attendance for the same student on the same date (should be none)
SELECT student_id, DATE(attendance_date) AS date, COUNT(*) AS cnt
FROM attendances
GROUP BY student_id, DATE(attendance_date)
HAVING COUNT(*) > 1;

-- Missing attendance dates for active students (data gap check)
SELECT s.id AS student_id, s.student_name
FROM students s
WHERE s.status = 'active'
  AND NOT EXISTS (
      SELECT 1 FROM attendances a
      WHERE a.student_id = s.id
        AND a.attendance_date = CURDATE()
  );

-- Attendance by status overall
SELECT status, COUNT(*) AS cnt
FROM attendances
GROUP BY status;

-- Attendance marked out of working days (present + absent total per day)
SELECT DATE(attendance_date) AS date, COUNT(*) AS marked_count
FROM attendances
GROUP BY DATE(attendance_date)
ORDER BY date DESC;

-- ============================================================
-- End of Attendance SQL
-- ============================================================
