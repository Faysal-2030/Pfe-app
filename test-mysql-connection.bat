@echo off
echo Testing MySQL connection on port 3307...
echo This will attempt to connect to MySQL and create the hebergementdb database if it doesn't exist.

REM Find the MySQL executable in XAMPP
set MYSQL_PATH=C:\xampp\mysql\bin\mysql.exe
if not exist "%MYSQL_PATH%" (
  set MYSQL_PATH=C:\xampp\bin\mysql.exe
)

if not exist "%MYSQL_PATH%" (
  echo MySQL executable not found in XAMPP installation.
  echo Please make sure XAMPP is installed correctly.
  pause
  exit /b 1
)

REM Test connection and create database
"%MYSQL_PATH%" -h localhost -P 3307 -u root -e "CREATE DATABASE IF NOT EXISTS hebergementdb; SHOW DATABASES;"

if %ERRORLEVEL% EQU 0 (
  echo Connection successful! Database hebergementdb is ready.
  echo Now importing the initial schema...
  "%MYSQL_PATH%" -h localhost -P 3307 -u root hebergementdb < setup-database.sql
  if %ERRORLEVEL% EQU 0 (
    echo Database schema imported successfully!
  ) else (
    echo Failed to import database schema.
  )
) else (
  echo Failed to connect to MySQL on port 3307.
  echo Please make sure MySQL is running and accessible on port 3307.
)

pause
