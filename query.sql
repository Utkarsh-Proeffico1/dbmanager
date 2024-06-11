-- Create the employees table if it does not exist
CREATE TABLE IF NOT EXISTS employees (
                                         id INT PRIMARY KEY AUTO_INCREMENT,
                                         first_name VARCHAR(50),
    last_name VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10, 2)
    );

-- Insert sample data into the employees table
INSERT INTO employees (first_name, last_name, department, salary)
VALUES ('John', 'Doe', 'HR', 5000.00);

INSERT INTO employees (first_name, last_name, department, salary)
VALUES ('Jane', 'Smith', 'IT', 6000.00);


select * from employees ;