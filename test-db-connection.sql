-- Test database connection and create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS hebergementdb;
USE hebergementdb;

-- Test if we can create a table
CREATE TABLE IF NOT EXISTS test_connection (
    id INT AUTO_INCREMENT PRIMARY KEY,
    test_column VARCHAR(255)
);

-- Insert a test record
INSERT INTO test_connection (test_column) VALUES ('Connection successful');

-- Verify the record
SELECT * FROM test_connection;

-- Clean up
DROP TABLE test_connection;
