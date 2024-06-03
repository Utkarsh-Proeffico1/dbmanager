-- Create a table
CREATE TABLE IF NOT EXISTS test_table (
                                          id INT PRIMARY KEY AUTO_INCREMENT,
                                          name VARCHAR(50) NOT NULL,
    age INT NOT NULL
    );

-- Insert some records
INSERT INTO test_table (name, age) VALUES ('Alice', 30);
INSERT INTO test_table (name, age) VALUES ('Bob', 25);
INSERT INTO test_table (name, age) VALUES ('Charlie', 35);

-- Select records
SELECT * FROM test_table;

-- Update a record
UPDATE test_table SET age = 31 WHERE name = 'Alice';

-- Select records again to see the update
SELECT * FROM test_table;

-- Delete a record
DELETE FROM test_table WHERE name = 'Bob';

-- Select records again to see the deletion
SELECT * FROM test_table;


