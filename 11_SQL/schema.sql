-- ============================================================
-- QA DATABASE - REFERENCE SCHEMA (core tables)
-- Reference only; column names should match the actual QA database.
-- Used by the validation queries in 01-05_*.sql
-- ============================================================

-- Students
CREATE TABLE IF NOT EXISTS students (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    admission_no  VARCHAR(20) UNIQUE NOT NULL,
    student_name  VARCHAR(100) NOT NULL,
    gender        ENUM('Male','Female','Other') DEFAULT 'Other',
    class_id      INT,
    section_id    INT,
    status        ENUM('active','inactive') DEFAULT 'active'
);

-- Classes & Sections
CREATE TABLE IF NOT EXISTS classes (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    class_name  VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS sections (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    section_name VARCHAR(50) NOT NULL,
    class_id    INT
);

-- Attendance
CREATE TABLE IF NOT EXISTS attendances (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    student_id      INT NOT NULL,
    attendance_date DATE NOT NULL,
    status          ENUM('present','absent','late','leave') DEFAULT 'absent',
    UNIQUE KEY uq_student_date (student_id, attendance_date)
);

-- Fees
CREATE TABLE IF NOT EXISTS fee_structures (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    fee_type  VARCHAR(50) NOT NULL,
    amount    DECIMAL(10,2) NOT NULL,
    status    ENUM('active','inactive') DEFAULT 'active'
);

CREATE TABLE IF NOT EXISTS student_fees (
    id         INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    fee_id     INT NOT NULL
);

CREATE TABLE IF NOT EXISTS fee_payments (
    id             INT AUTO_INCREMENT PRIMARY KEY,
    student_id     INT NOT NULL,
    fee_id         INT NOT NULL,
    amount_paid    DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(30),
    paid_at        DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Inventory
CREATE TABLE IF NOT EXISTS inventory_categories (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS inventory_items (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    category_id   INT NOT NULL,
    item_name     VARCHAR(100) NOT NULL,
    quantity      INT DEFAULT 0,
    reorder_level INT DEFAULT 0,
    status        ENUM('active','inactive') DEFAULT 'active'
);

CREATE TABLE IF NOT EXISTS inventory_receives (
    id               INT AUTO_INCREMENT PRIMARY KEY,
    item_id          INT NOT NULL,
    quantity_received INT NOT NULL,
    receive_date     DATE
);

CREATE TABLE IF NOT EXISTS inventory_issues (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    item_id         INT NOT NULL,
    quantity_issued INT NOT NULL,
    issue_date      DATE,
    student_id      INT,
    staff_id        INT
);

-- ============================================================
-- End of Reference Schema
-- ============================================================
