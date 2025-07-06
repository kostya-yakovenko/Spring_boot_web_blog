Blog Web Application
This is a simple web blog project that implements full CRUD operations (Create, Read, Update, Delete) for blog posts.

Features
Create, edit, and delete blog posts

View a list of all posts

View individual post details

Connected to a MySQL database via phpMyAdmin

Developed using Java & Spring Boot

Database configured and run using MAMP

Setup Instructions
1. Requirements
Java 17+

Maven

MAMP (with Apache & MySQL)

MySQL (via phpMyAdmin)

2. Database Setup
Start MAMP.

Open phpMyAdmin by navigating to http://localhost:8888/phpMyAdmin.

Create a new database, for example: blog_db.

Import the SQL schema if available or let the application auto-create tables.

3. Default Ports
Apache: 8888

MySQL: 8889

4. Application Configuration
Ensure that your application.properties or application.yml file contains something like:

properties
Копіювати
Редагувати
spring.datasource.url=jdbc:mysql://localhost:8889/blog_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
5. Run the Application
bash
Копіювати
Редагувати
./mvnw spring-boot:run
Then visit:
http://localhost:8080 — Main application page

Technologies Used
Java 17

Spring Boot

Thymeleaf

MySQL

MAMP

phpMyAdmin