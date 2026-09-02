-- ============================================================
-- FEES MODULE - SQL VALIDATION QUERIES
-- Validate fee structure and payment data.
-- Cross-checks UI behavior covered by automation (Phase 6).
-- ============================================================

-- List fee structures with amounts
SELECT id, fee_type, amount, status
FROM fee_structures
WHERE status = 'active'
ORDER BY fee_type;

-- Students and their assigned fees
SELECT s.id, s.student_name, f.fee_type, f.amount
FROM students s
JOIN student_fees sf ON s.id = sf.student_id
JOIN fee_structures f ON sf.fee_id = f.id
WHERE s.status = 'active'
ORDER BY s.student_name, f.fee_type;

-- Total collected per fee type (fee collection validation)
SELECT f.fee_type, SUM(p.amount_paid) AS total_collected, COUNT(p.id) AS payments
FROM fee_payments p
JOIN fee_structures f ON p.fee_id = f.id
GROUP BY f.fee_type
ORDER BY total_collected DESC;

-- Students with assigned fees but no payment (defaulters)
SELECT s.id, s.student_name, f.fee_type, f.amount
FROM students s
JOIN student_fees sf ON s.id = sf.student_id
JOIN fee_structures f ON sf.fee_id = f.id
LEFT JOIN fee_payments p ON p.student_id = s.id AND p.fee_id = f.id
WHERE s.status = 'active'
  AND p.id IS NULL;

-- Overdue / partial payment summary
SELECT
    s.id AS student_id,
    s.student_name,
    SUM(f.amount) AS total_due,
    COALESCE(SUM(p.amount_paid), 0) AS total_paid,
    (SUM(f.amount) - COALESCE(SUM(p.amount_paid), 0)) AS balance
FROM students s
JOIN student_fees sf   ON s.id = sf.student_id
JOIN fee_structures f  ON sf.fee_id = f.id
LEFT JOIN fee_payments p ON p.student_id = s.id AND p.fee_id = f.id
WHERE s.status = 'active'
GROUP BY s.id, s.student_name
HAVING balance > 0;

-- Fee collection per payment method
SELECT payment_method, COUNT(*) AS cnt, SUM(amount_paid) AS total
FROM fee_payments
GROUP BY payment_method;

-- ============================================================
-- End of Fees SQL
-- ============================================================
