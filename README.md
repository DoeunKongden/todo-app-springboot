Todo List API Project

Overview

The Todo List API is a simple project built using Spring Boot, MyBatis, and PostgreSQL. It provides functionality to manage tasks (todos) and categorize them. The project uses RESTful APIs to perform CRUD operations on tasks and categories.

Features

Task Management (Todos)

Create, read, update, and delete tasks.

Assign tasks to specific categories.

Category Management

Create, read, and delete categories.

Categories are uniquely identified and tasks can be grouped under them.

Database Relationships

A category_id foreign key links tasks to their categories.

Technologies Used

Spring Boot: Backend framework for creating RESTful APIs.

MyBatis: ORM for database operations.

PostgreSQL: Database for persistent storage.

HikariCP: Database connection pool.

Postman: For API testing.

Database Schema

Categories Table

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Todos Table

CREATE TABLE todos (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN DEFAULT FALSE,
    category_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE SET NULL
);

API Endpoints

Todos Endpoints

Method

Endpoint

Description

POST

/api/todos

Create a new task

GET

/api/todos

Fetch all tasks

GET

/api/todos/{id}

Fetch a specific task

PUT

/api/todos/{id}

Update a task

DELETE

/api/todos/{id}

Delete a task

Example Request for Creating a Todo

POST /api/todos
{
  "title": "Complete Project",
  "description": "Finish the API implementation",
  "completed": false,
  "categoryId": 1
}

Categories Endpoints

Method

Endpoint

Description

POST

/api/categories

Create a new category

GET

/api/categories

Fetch all categories

GET

/api/categories/{id}

Fetch a specific category

DELETE

/api/categories/{id}

Delete a category

Example Request for Creating a Category

POST /api/categories
{
  "name": "Work"
}

Setup Instructions

Prerequisites

Java 17 or later

PostgreSQL 13 or later

Maven

Postman (optional for API testing)

Steps

Clone the repository:

git clone https://github.com/your-username/todo-list-api.git
cd todo-list-api

Configure the database in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/todo_list
spring.datasource.username=your_username
spring.datasource.password=your_password
mybatis.configuration.map-underscore-to-camel-case=true

Build the project:

mvn clean install

Run the project:

mvn spring-boot:run

Test the APIs using Postman or cURL.

Project Structure

src/main/java/com/example/todolist
├── controller
│   ├── TodoController.java
│   └── CategoryController.java
├── model
│   ├── Todo.java
│   └── Category.java
├── mapper
│   ├── TodoMapper.java
│   └── CategoryMapper.java
├── service
│   ├── TodoService.java
│   └── CategoryService.java
├── exception
│   └── GlobalExceptionHandler.java (optional)
└── TodoListApplication.java

Testing

Use Postman or a similar tool to test the endpoints. Ensure the following:

Categories must be created before assigning them to tasks.

Unique category names are enforced by the database.

Test edge cases like invalid inputs and missing fields.

Future Enhancements

Add user authentication using JWT or OAuth2.

Implement pagination for large datasets.

Add search and filtering functionality.

Improve validation and error handling.

License

This project is open-source and available under the MIT License.

