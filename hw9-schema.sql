SET sql_mode = STRICT_ALL_TABLES;

DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee(
        emp_id INT UNSIGNED,
        salary INT UNSIGNED,
        title VARCHAR(20),
        PRIMARY KEY (emp_id)
);

CREATE INDEX salary
ON Employee (salary);

CREATE INDEX titleSalary
ON Employee (title, salary);
