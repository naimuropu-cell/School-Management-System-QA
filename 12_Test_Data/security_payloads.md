# Security Payloads

Inputs used for negative and security testing (SQL injection, XSS, malformed
data). Referenced by general negative scenarios across modules (e.g.
TS-xxx-040/048/050).

---

## SQL Injection Payloads

| Payload | Field Example | Expected Result |
|---------|---------------|-----------------|
| `' OR '1'='1` | Login email / search | No data leak, sanitized |
| `'; DROP TABLE students; --` | Search input | Statement rejected |
| `1 OR 1=1` | ID / numeric field | No unauthorized rows |
| `" OR ""="` | Login password | No bypass |
| `admin'--` | Login username | No bypass |

---

## XSS / HTML Payloads

| Payload | Field Example | Expected Result |
|---------|---------------|-----------------|
| `<script>alert(1)</script>` | Name / description | Rendered as text, not executed |
| `<img src=x onerror=alert(1)>` | Comment / note | Sanitized |
| `<b>bold</b>` | Description | Stored as literal text |
| `javascript:alert(1)` | URL field | Blocked |

---

## Malformed Inputs

| Case | Data | Expected Result |
|------|------|-----------------|
| Overflow text | Long string > field limit | Truncated / rejected (boundary) |
| Trailing spaces | `" admin "` | Trimmed |
| Multi-line | Newlines in single-line field | Normalized |
| Special characters | `!@#$%^&*()_+` | Handled safely |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
