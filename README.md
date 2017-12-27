# spring-boot-spring-security-thymeleaf
A Spring Boot Thymeleaf example, uses Spring Security to protect path /admin, /super_admin and /user

<b>For user “admin” :</b>
* Able to access /admin page
* Unable to access /user and /super_admin page, redirect to 403 access denied page.

<b>For user “user” :</b>
* Able to access /user page
* Unable to access /admin and /super_admin page, redirect to 403 access denied page.

<b>For user “super_admin” :</b>
* Able to access /super_admin page
* Unable to access /user and /admin page, redirect to 403 access denied page.

<b>Technologies used :</b>

spring-boot-starter-parent 1.5.9.RELEASE<br/>
spring-boot-starter-security <br/>
spring-boot-starter-thymeleaf <br/>
thymeleaf-extras-springsecurity4 <br/>
Maven 3 <br/>
Java 8 <br/>

# Version 1: Using in-memory database
Create Users using inMemoryAuthentication() method.
