# Basic parameters
+ Java version - **17**
+ Database - **Oracle 19**
+ Spring Boot - **2.7.11**
+ Template Engine - **Thymeleaf**

# Description
In this example are created entities **User** and **Role**. Relationship is M : N. Connection entity between theese two is **UserRole**
It contains composite primary key consisted of User and Role. And than following extra fields:
+ boolean **active** 		- Is role for user Active or Not 
+ Date **dateAdded**  		- Date when was role assigned to user
+ int **whoAssignRole** 	- Who was assigned the role to user

Theese extra fields have sense for one particular combination of User and Role

Password of User is encrypted. Each Role or User can be in active or NOT active state.

# Functionality
First is needed add some roles to system. And than add new User. In the view for adding new user you can than assign one or more
roles to this user. Role and authorities management could be in real systems quite complicated. In this examples are used just roles. 

# Application Views 
+ **role-new.html** - View for adding new Role - url end point **/role-new**
+ **role-list.html** - View with list of all roles - url end point **/role-list**
+ **user-new.html** - View for adding new User - url end point **/user-new**
+ **user-list.html** - View with list of all Users - url end point **/user-list**
+ **user-role-list.html** - View with list of users and roles assigned to them - url end point **/user-role-list**

# Screenshots
## View - Add new user

## View - List of all users
