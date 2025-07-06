# Blog Web Application

A lightweight Java Spring Boot web blog that supports full CRUD operations for posts. It uses MySQL via MAMP/phpMyAdmin for data storage. Designed for learning and demonstration purposes with a simple and clean structure.

## Features

- Create, read, update, and delete blog posts
- View post list and post details
- MySQL database integration via phpMyAdmin
- Runs locally using MAMP

## Requirements

- Java 17+
- Maven
- MAMP
- MySQL (phpMyAdmin)

## Setup Instructions

1. Start MAMP and phpMyAdmin (`http://localhost:8888/phpMyAdmin`)
2. Create a database (e.g. `blog_db`)
3. Configure `application.properties`:

properties
`spring.datasource.url=jdbc:mysql://localhost:8889/blog_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update`

## Run the application:
`./mvnw spring-boot:run`

Visit the app at: `http://localhost:8080`
