# Boundary Values

Boundary and edge-case inputs used across modules for boundary-value analysis.

---

## Text Fields

| Boundary | Data | Expected Result |
|----------|------|-----------------|
| Min length | 1 character | Accepted |
| Max length | Field limit (e.g. 100 chars) | Accepted |
| Over max | Field limit + 1 | Rejected / truncated |
| Empty | "" | Rejected (mandatory) |
| Whitespace only | "   " | Rejected (treated as empty) |

---

## Numeric Fields

| Boundary | Data | Expected Result |
|----------|------|-----------------|
| Zero | 0 | Rejected for amounts/quantities |
| Positive | 1 | Accepted |
| Max bound | Largest supported value | Accepted |
| Over max | Max + 1 | Rejected |
| Negative | -1 | Rejected |

---

## Date Fields

| Boundary | Data | Expected Result |
|----------|------|-----------------|
| Today | Current date | Accepted |
| Past | Valid past date | Accepted |
| Future | After today (attendance) | Rejected (TS-ATT-012) |
| Leap day | 2028-02-29 | Accepted |
| Invalid | 2026-13-45 | Rejected |

---

## Special Characters

| Case | Data | Expected Result |
|------|------|-----------------|
| Symbols | `!@#$%^&*()` | Handled safely |
| Unicode | `Naimur রহমান` | Stored/displayed correctly |
| HTML tags | `<b>`, `<script>` | Sanitized (see security_payloads) |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
