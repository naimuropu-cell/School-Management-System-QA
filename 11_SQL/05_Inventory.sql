-- ============================================================
-- INVENTORY MODULE - SQL VALIDATION QUERIES
-- Validate inventory item and stock data.
-- Cross-checks UI behavior covered by automation (Phase 8).
-- ============================================================

-- Total active inventory items
SELECT COUNT(*) AS total_items
FROM inventory_items
WHERE status = 'active';

-- Stock level per item (quantity on hand)
SELECT id, item_name, quantity, reorder_level
FROM inventory_items
WHERE status = 'active'
ORDER BY item_name;

-- Low stock / reorder-needed items (validation vs UI badge)
SELECT id, item_name, quantity, reorder_level
FROM inventory_items
WHERE status = 'active'
  AND quantity <= reorder_level
ORDER BY quantity ASC;

-- Items grouped by category
SELECT c.name AS category_name, COUNT(i.id) AS item_count
FROM inventory_items i
JOIN inventory_categories c ON i.category_id = c.id
GROUP BY c.name
ORDER BY item_count DESC;

-- Issue history joined to items and recipients
SELECT
    i.item_name,
    il.issue_date,
    il.quantity_issued,
    il.student_id,
    il.staff_id
FROM inventory_issues il
JOIN inventory_items i ON il.item_id = i.id
ORDER BY il.issue_date DESC;

-- Stock received (stock-in) totals per item
SELECT i.item_name, SUM(r.quantity_received) AS total_received
FROM inventory_receives r
JOIN inventory_items i ON r.item_id = i.id
GROUP BY i.item_name
ORDER BY total_received DESC;

-- Verified stock after issue (should equal quantity + received - issued)
SELECT
    i.item_name,
    i.quantity AS on_hand,
    COALESCE(SUM(r.quantity_received), 0) AS total_received,
    COALESCE(SUM(il.quantity_issued), 0)  AS total_issued,
    (COALESCE(SUM(r.quantity_received), 0) - COALESCE(SUM(il.quantity_issued), 0)) AS calculated_balance
FROM inventory_items i
LEFT JOIN inventory_receives r  ON r.item_id = i.id
LEFT JOIN inventory_issues il   ON il.item_id = i.id
GROUP BY i.id, i.item_name, i.quantity
HAVING calculated_balance <> i.quantity;

-- ============================================================
-- End of Inventory SQL
-- ============================================================
