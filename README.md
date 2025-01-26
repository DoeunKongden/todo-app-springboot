# Todo List API Project

## Overview

The Todo List API is a simple project built using Spring Boot, MyBatis, and PostgreSQL. It provides functionality to manage tasks (todos) and categorize them. The project uses RESTful APIs to perform CRUD operations on tasks and categories.

---

## Features

1. **Task Management (Todos)**

   - Create, read, update, and delete tasks.
   - Assign tasks to specific categories.

2. **Category Management**

   - Create, read, and delete categories.
   - Categories are uniquely identified and tasks can be grouped under them.

3. **Database Relationships**

   - A `category_id` foreign key links tasks to their categories.

---

## Technologies Used

- **Spring Boot**: Backend framework for creating RESTful APIs.
- **MyBatis**: ORM for database operations.
- **PostgreSQL**: Database for persistent storage.
- **HikariCP**: Database connection pool.
- **Postman**: For API testing.

---

## Database Schema

### Categories Table

```sql
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Todos Table

```sql
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
```

---

## API Endpoints

### Todos Endpoints

| Method | Endpoint          | Description           |
| ------ | ----------------- | --------------------- |
| POST   | `/api/todos`      | Create a new task     |
| GET    | `/api/todos`      | Fetch all tasks       |
| GET    | `/api/todos/{id}` | Fetch a specific task |
| PUT    | `/api/todos/{id}` | Update a task         |
| DELETE | `/api/todos/{id}` | Delete a task         |

#### Example Request for Creating a Todo

```json
POST /api/todos
{
  "title": "Complete Project",
  "description": "Finish the API implementation",
  "completed": false,
  "categoryId": 1
}
```

### Categories Endpoints

| Method | Endpoint               | Description               |
| ------ | ---------------------- | ------------------------- |
| POST   | `/api/categories`      | Create a new category     |
| GET    | `/api/categories`      | Fetch all categories      |
| GET    | `/api/categories/{id}` | Fetch a specific category |
| DELETE | `/api/categories/{id}` | Delete a category         |

#### Example Request for Creating a Category

```json
POST /api/categories
{
  "name": "Work"
}
```

---

## Setup Instructions

### Prerequisites

1. **Java 17 or later**
2. **PostgreSQL 13 or later**
3. **Maven**
4. **Postman** (optional for API testing)

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/todo-list-api.git
   cd todo-list-api
   ```

2. Configure the database in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/todo_list
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   mybatis.configuration.map-underscore-to-camel-case=true
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the project:

   ```bash
   mvn spring-boot:run
   ```

5. Test the APIs using Postman or cURL.

---

## Project Structure

```
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
```

---

## Testing

Use Postman or a similar tool to test the endpoints. Ensure the following:

1. Categories must be created before assigning them to tasks.
2. Unique category names are enforced by the database.
3. Test edge cases like invalid inputs and missing fields.

---

## Future Enhancements

1. Add user authentication using JWT or OAuth2.
2. Implement pagination for large datasets.
3. Add search and filtering functionality.
4. Improve validation and error handling.

---

## License

This project is open-source and available under the [MIT License](LICENSE).

