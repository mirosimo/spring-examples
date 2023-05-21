# Basic parameters
+ Java version - **17**
+ Database - **Oracle 19**
+ Spring Boot - **2.7.11**
+ Template Engine - **Thymeleaf**

# Description
In this example are created entities **User** and **Role**. Relationship is M : N. Connection entity between these two is **UserRole**
Contains Composite primary key consist of User and Role. And than following extra fields:
+ **boolean active** 		- Is role for user Active or Not 
+ **Date dateAdded**  		- Date when was role assigned to user
+ **int whoAssignRole** 	- Who was assigned the role to user


