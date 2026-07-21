# Business Rules

## Student Module

- Admission Number must be unique.
- Admission Number is auto-generated.
- Roll Number is auto-generated class & section wise.
- Student becomes Active immediately after successful admission.
- Student can be edited.
- Student can be disabled.
- Student can be deleted.

---

## Teacher Module

- Teacher can edit their own homework.
- If a teacher is deleted, related homework will not remain available.
- Changing the class teacher updates the class routine accordingly.

---

## Attendance Module

- Attendance can be taken only once per day.
- Existing attendance can be edited.
- Duplicate attendance is not allowed.

---

## Homework Module

- Student must submit homework before evaluation.
- Teacher should not evaluate students who did not submit homework.
- Homework supports single file upload.
- Homework submission is allowed after due date (Current System).
- Teacher can edit homework before completion.

---

## Leave Module

- Leave is assigned role-wise.
- User submits leave request.
- Admin approves or rejects leave.
- Approved leave cannot be edited.
- Approved leave cannot be cancelled.
- Multiple leave requests for the same date are currently allowed.
- Leave balance depends on Leave Define configuration.

---

## Fees Module

- Partial payment is allowed.
- Paid invoice cannot be edited.
- Paid invoice cannot be deleted.
- Due invoice cannot be deleted.
- Waiver can be applied.
- Fine is manually controlled.

---

## Examination Module

- Marks can be edited before publishing.
- Marks cannot be edited after publishing.
- Published exams can be deleted.
- Grade is automatically calculated.

---

## Online Examination

- Student can attempt only once.
- Auto submit is currently unavailable.
- Published exam cannot be edited.

---

## Frontend CMS

- Image upload is optional.
- Changes are published immediately after saving.
- Existing pages can be edited.

---

## Wallet

- Deposit request requires approval.
- Approved deposits affect wallet balance.
- Rejected deposits do not affect wallet balance.

---

## Reports

- Reports are generated from live system data.
- Reports support export where applicable.

---

## General Rules

- Mandatory fields must be validated.
- Duplicate records should not be created unless business permits.
- Unauthorized users cannot access restricted modules.
- Every successful operation should display a success message.
- Every failed operation should display a meaningful error message instead of a server error.