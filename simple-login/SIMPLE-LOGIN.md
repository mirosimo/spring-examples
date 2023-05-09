# Spring security - Simple Login / Logout example

## Basic characteristic
+ User fetch from database (Oracle) 
+ Password is encrypted
+ Secure endpoint: **/customer**
+ Public endpoints: **/, /home, /login**
+ Template engine: Thymeleaf

## Application functionality
+ When user goes to unsecured end point than is displayed login form. 
+ When is user logged in - then is display on top the strip containing user name and button for logout.
+ When is user not login and is on public page then is on top strip displayed button for login.
+ When user puts wrong credentials into login  form - then is displayed warning board and message that user or password is wrong.
