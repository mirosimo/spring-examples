
# Basic parameters
+ Java version - **17**
+ Database - **Oracle 19**
+ Spring Boot - **2.7.11**
+ Template Engine - **Thymeleaf**

# Overview
  This example is focused on Jpa **one to many** relationship between entities. 

# Department - Employee
  For our purpose are applied two entities **Department** and **Employee**. Each Department could contain one or more employees.
 And each employee can be assigned in one department.

# Thymeleaf views

+ **department-employees-list.html** - view displayes under each department list of assigned employees to this department
+ **department-new.html** - view for adding new department into system
+ **department-list.html** - view displays list of all departments
+ **employee-new.html** - view for adding new employee into system
+ **employee-list.html** - view displays list of all employees


# Screenshots
## Department - Employees 
![department-employees](/one-to-many/screenshots/department-employees.png)

## Employee new
![employee new](/one-to-many/screenshots/employee-new.png)

## Employee list
![employee list](/one-to-many/screenshots/employee-list.png)

## Department list
![department list](/one-to-many/screenshots/department-list.png)
