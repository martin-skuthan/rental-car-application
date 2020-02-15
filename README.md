# Car rental application 
Car rental management system written in Java language.

## Table of contents
* [General info](#general-info)
* [Instalation](#screenshots)
* [Features](#features)
* [Contact](#contact)

## General info
Project has been created using Java 8 language in order to develop my skills related to this technology and relational databases. Application is a car rental managament system allowing users to add/remove/rent/return cars(app handles two types of cars : Passangers and Light commercial cars) and add/remove clients of car rental. Application allows choose three types of read/write data method: 
* to CSV file
* to Serializable file
* to MySQL database

## Installation
####  1) Database 
In order to use "database read/write data method" needs to be installed carrental database on your computer. If you prefer write/read using you can omit this step.
To install carrental database used by Car rental application, please follow these steps:
1. MySQL server needs to be installed on computer.
2. Using command line go to directory when server is installed. For example:
shell> cd C:\Program Files\MySQL\MySQL Server\bin
3. Connect to the MySQL server using the command line with the following command:
shell>mysql -u root -p, and then enter your root password.
4. Run carrental-database.sql in order to create database using following command:
mysql> SOURCE pathToSqlFile/carrental-database.sql; For example: mysql> SOURCE C:/temp/carrental-database.sql; 
5. In java class ConnectionProvider.java located at src/io.database provide your login and password to MySQL root account:
 eg.Connection connection = DriverManager.getConnection(dbPath, "login", "passowrd");
#### 2) Application
You can run appliaction using integrated developments enviroment such as IntelliJ or Eclipse.

## Features
* **Adding/Removing Cars** - Application allows users add/remove passangers and ligth commercial cars to the system. When adding user provides car's details like brand, model, registration number, transmission, type of drive etc. Removing is carried out by providing registration number of car that user want to remove.
* **Adding/Removing Users** - Application allows add/remove car rental's customers to the system. When adding new custeomer user proovides details like first name, last name and pesel. Removing is carried out by providinig pesel of customer that user want to remove.
* **Printing Cars and Users** - Application allows print cusomers and cars added to the system. When printing cars user can choose "Print filter" and print available cars, rented cars or all cars. 
* **Renting/Returning Cars** - Application allows rent and return car available in system by customers added to the system.

## Contact
Created by : Martin Skuthan. Please feel free to contact me :
* My mail: martin.skuthan95@gmail.com
* Linkedin : www.linkedin.com/in/martin-skuthan-630553190
