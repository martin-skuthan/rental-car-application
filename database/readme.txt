To install carrental database used by Car rental application, please follow these steps:
1.MySQL server needs to be installed on computer.
2.Using command line go to directory when server is installed. For example:
shell> cd C:\Program Files\MySQL\MySQL Server\bin
3.Connect to the MySQL server using the command line with the following command:
shell>mysql -u root -p, and then enter your root password.
4.Run carrental-database.sql in order to create database using following command:
mysql> SOURCE pathToSqlFile/carrental-database.sql; For example: mysql> SOURCE C:/temp/carrental-database.sql; 
