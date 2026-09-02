# Test Data

Test data strategy and sample data used across QA activities.

---

## Strategy

- **Login credentials** are stored in `config.properties` and managed per role
- **Student records** are created via the live application during testing
- **Negative test data** includes invalid emails, empty fields, duplicate entries
- **Boundary data** includes max-length strings, special characters, SQL injection payloads

---

## Role Credentials

| Role | Username | Password |
|------|----------|----------|
| Admin | admin@yesedu.com | 1234 |
| Teacher | teacher@yesbangladesh.com | 1234 |
| Student | student@yesbangladesh.com | 123456 |
| Accountant | accountant@yesbangladesh.com | 1234 |

---

## Test Data Categories

| Category | Examples |
|----------|---------|
| Valid inputs | Names, emails, phone numbers, dates |
| Invalid inputs | Empty strings, malformed emails, duplicate records |
| Boundary values | Max-length strings, zero values, negative numbers |
| Security payloads | SQL injection, XSS scripts, HTML tags |

---

Prepared by

**Naimur Rahman**
Software QA Engineer
