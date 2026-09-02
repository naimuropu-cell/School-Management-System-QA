# Inventory Test Data

Sample inventory categories, items, stock levels, and transaction records used
for QA validation. Column names align with `11_SQL/schema.sql` and the queries
in `11_SQL/05_Inventory.sql`.

---

## Categories

| Category ID | Name |
|-------------|------|
| 1 | Stationery |
| 2 | Laboratory |
| 3 | Sports Equipment |
| 4 | Furniture |

---

## Items

| Item ID | Item Name | Category | Quantity | Reorder Level | Status |
|---------|-----------|----------|----------|---------------|--------|
| 1 | Notebook | Stationery | 500 | 100 | active |
| 2 | Pen | Stationery | 40 | 50 | active (low stock) |
| 3 | Bunsen Burner | Laboratory | 30 | 10 | active |
| 4 | Football | Sports Equipment | 8 | 5 | active |
| 5 | Whiteboard | Furniture | 3 | 1 | inactive |

---

## Stock-In (Receive) Records

| Item | Quantity Received | Date |
|------|-------------------|------|
| Notebook | 200 | 2026-08-01 |
| Pen | 100 | 2026-08-15 |

---

## Stock-Out (Issue) Records

| Item | Quantity Issued | Recipient (Student) | Date |
|------|-----------------|---------------------|------|
| Notebook | 20 | ADM-0001 | 2026-08-20 |
| Football | 1 | ADM-0004 | 2026-08-25 |

---

## Validation Cases

| Case | Data | Expected Result |
|------|------|-----------------|
| Low stock alert | quantity <= reorder_level | Flagged (Pen) |
| Insufficient stock | issue quantity > on-hand | Rejected (TS-INV-029) |
| Negative quantity | -5 | Rejected |
| Duplicate item | Same name + category twice | Rejected |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
