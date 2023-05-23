
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

+ **car-equipment-pack-engine-list.html** - view displayes equipment packs which are in active states. And under each equipment pack are
             displayed its available engines.
+ **department-new.html** - view for adding new engine into system.
+ **department-list.html** - view displays list of all engines
+ **employee-new.html** - view for adding new equipment pack into system.
+ **employee-list.html** - view displays list of all equipment packs


# Screenshots
## Equipment pack - Engines 
![login view](/many-to-many-composite-key/screen-shots/eq-pack-engines-list2.png)

## Equipment pack - List
![login view](/many-to-many-composite-key/screen-shots/eq-pack-list.png)

## Equipment pack - NEW record
![login view](/many-to-many-composite-key/screen-shots/eq-pack-new.png)

## Engines - List
![login view](/many-to-many-composite-key/screen-shots/engine-list.png)
