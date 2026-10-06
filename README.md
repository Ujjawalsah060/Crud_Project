# Teacher CRUD Application

A simple **Teacher Management REST API** built using **Java and Spring Boot**. This project demonstrates how to perform basic **CRUD operations — Create, Read, Update, and Delete** — with a MySQL database.

The project follows a **layered architecture**, where the Controller handles API requests, the Service manages business logic, and the Repository communicates with the database.

---

## Features

* Create a new teacher
* Get all teachers
* Get a teacher by ID
* Update teacher information
* Delete a teacher
* Store teacher information in MySQL
* RESTful API implementation
* Test APIs using Postman
* Layered application architecture

---

## Technologies Used

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Maven**
* **Postman**
* **Git & GitHub**

---

## Project Structure

The project is organized into different layers to keep the code clean, maintainable, and easy to understand.

![Project Structure](https://github.com/user-attachments/assets/67879d90-18cf-4309-9c13-93a990cc113a)

### Main Layers

```text
controller/
service/
repository/
entity/
```

### Controller

The `controller` package contains REST controllers that receive HTTP requests from clients such as Postman.

**Example:**

`TeacherController.java`

It handles endpoints such as:

```text
POST    /teachers
GET     /teachers
GET     /teachers/{id}
PUT     /teachers/{id}
DELETE  /teachers/{id}
```

### Service

The `service` package contains the application's business logic.

**Example:**

`TeacherService.java`

It receives requests from the Controller and performs the required operations using the Repository.

### Repository

The `repository` package communicates with the database.

**Example:**

`TeacherRepository.java`

It usually extends:

```java
JpaRepository<Teacher, Long>
```

This provides common database operations such as saving, finding, updating, and deleting records.

### Entity

The `entity` package contains classes that represent database tables.

**Example:**

`Teacher.java`

It contains teacher-related fields such as:

```text
id
name
email
address
subject
```

---

## Application Architecture

The basic flow of the application is:

```text
        Client / Postman
               ↓
          Controller
               ↓
            Service
               ↓
          Repository
               ↓
          MySQL Database
```

This layered architecture separates different responsibilities and makes the application easier to maintain and extend.

---

# Annotations Used

This project uses several **Spring Boot, Spring Data JPA, and REST API annotations**.

| Annotation               | Purpose                                               |
| ------------------------ | ----------------------------------------------------- |
| `@SpringBootApplication` | Marks the main class of the Spring Boot application.  |
| `@RestController`        | Creates a REST controller for handling HTTP requests. |
| `@RequestMapping`        | Defines the base URL for API endpoints.               |
| `@GetMapping`            | Handles HTTP GET requests.                            |
| `@PostMapping`           | Handles HTTP POST requests.                           |
| `@PutMapping`            | Handles HTTP PUT requests.                            |
| `@DeleteMapping`         | Handles HTTP DELETE requests.                         |
| `@RequestBody`           | Converts JSON request data into a Java object.        |
| `@PathVariable`          | Gets a value from the URL path.                       |
| `@Service`               | Marks a class as a service/business-logic component.  |
| `@Repository`            | Defines the repository layer for database operations. |
| `@Entity`                | Marks a Java class as a JPA entity.                   |
| `@Table`                 | Specifies the database table name.                    |
| `@Id`                    | Defines the primary key.                              |
| `@GeneratedValue`        | Automatically generates the primary-key value.        |
| `@Column`                | Provides configuration for a database column.         |

These annotations reduce boilerplate code and make it easier to connect the Java application with the database and build REST APIs.

---

# Implementation Examples

## 1. Entity Example

The `Teacher` entity represents the teacher table in the database.

![Teacher Entity](https://github.com/user-attachments/assets/85937db1-16d4-4d9d-8263-f576421c6db7)

The entity contains the teacher information and uses JPA annotations to map the Java class to the database table.

---

## 2. Repository Example

The Repository layer is responsible for communicating with the database.



By extending `JpaRepository`, the project gets predefined methods for common database operations without writing SQL queries manually.

---

## 3. Service Example

The Service layer contains the main business logic of the application.

![Teacher Service](https://github.com/user-attachments/assets/e4d55693-e7de-4fc8-8678-c61527ef9a3c)

The service communicates with the Repository to perform operations such as creating, retrieving, updating, and deleting teacher records.

---

## 4. Controller Example

The Controller provides REST API endpoints that can be accessed through Postman or other clients.

![Teacher Controller](https://github.com/user-attachments/assets/4328f6ea-8b5f-4ec6-a55a-e4fc66057cfe)

The Controller receives the request, sends it to the Service layer, and returns the appropriate response.

---

# API Testing and Output

The APIs were tested using **Postman** to verify that all CRUD operations work correctly.

## Create Teacher

**POST**

```text
/teachers
```

Used to create a new teacher record.

Example request:

```json
{
    "name": "Ram Sharma",
    "email": "ram@gmail.com",
    "address": "Kathmandu",
    "subject": "Java"
}
```

---

## Get All Teachers

**GET**

```text
/teachers
```

Used to retrieve all teacher records from the database.

---

## Get Teacher by ID

**GET**

```text
/teachers/{id}
```

Used to retrieve a specific teacher using their ID.

---

## Update Teacher

**PUT**

```text
/teachers/{id}
```

Used to update an existing teacher's information.

---

## Delete Teacher

**DELETE**

```text
/teachers/{id}
```

Used to delete a teacher record from the database.

---

## Postman Output

![API Output](https://github.com/user-attachments/assets/447978d4-f825-4d6a-9383-b6c7b409a9c5)

The Postman responses were used to verify that the CRUD operations were successfully working with the database.

---

# Purpose of the Project

The main purpose of this project is to understand how a **Spring Boot REST API works with a database** and how different layers of an application communicate with each other.

Through this project, I practiced:

* Building REST APIs
* Implementing CRUD operations
* Connecting Spring Boot with MySQL
* Using Spring Data JPA
* Understanding Controller, Service, Repository, and Entity layers
* Testing APIs using Postman
* Managing source code using Git and GitHub

---

# What I Learned

This project helped me gain practical understanding of **Spring Boot application development**, especially how a request moves from the Controller through the Service and Repository layers before interacting with the database.

It also gave me hands-on experience in developing and testing a basic real-world backend application.

---

# Future Improvements

Some possible improvements for this project are:

* Add input validation
* Add exception handling
* Add global error handling
* Add pagination and sorting
* Add authentication and authorization
* Create a frontend interface
* Deploy the application online








