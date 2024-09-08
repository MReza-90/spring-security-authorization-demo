
# Spring REST CRUD Employee with Spring Data JPA


## Overview

This project is a RESTful API for managing an employee directory, built using Spring Boot and Spring Data JPA. It provides a set of endpoints for performing CRUD operations on employee records with data stored in a MySQL database.

## Features

- **Get a List of Employees**: Retrieve a list of all employees.
- **Get a Single Employee by ID**: Retrieve details of a specific employee using their ID.
- **Add a New Employee**: Create a new employee record.
- **Update an Employee**: Update the details of an existing employee.
- **Delete an Employee**: Remove an employee record from the directory.

## Technologies Used

- **Spring Boot**: Framework for building the REST API.
- **Spring Data JPA**: Simplifies data access and manipulation with JPA (Java Persistence API).
- **MySQL**: Relational database used for data storage.
- **Hibernate**: ORM (Object-Relational Mapping) tool used by Spring Data JPA for data persistence.

## Getting Started

### Prerequisites

- Java 21 or later
- Maven 3.6.0 or later
- MySQL Server

### Setup

1. **Clone the Repository**

   ```bash
   git clone  https://github.com/MReza-90/Spring-REST-CRUD-Employee-with-Spring-Data-JPA.git
   cd employee-directory-api
   ```

2. **Configure the Application**

   - Update the `src/main/resources/application.properties` file with your MySQL database credentials:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
     spring.datasource.username=your_mysql_username
     spring.datasource.password=your_mysql_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Build the Project**

   Use Maven to build the project:

   ```bash
   mvn clean install
   ```

4. **Run the Application**

   Start the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`.

### API Endpoints

- **GET /employees**: Retrieve all employees.
- **GET /employees/{id}**: Retrieve an employee by ID.
- **POST /employees**: Create a new employee. Requires a JSON payload with employee details.
- **PUT /employees/{id}**: Update an existing employee. Requires a JSON payload with updated details.
- **DELETE /employees/{id}**: Delete an employee by ID.

### Data Access with Spring Data JPA

This project uses Spring Data JPA to handle data persistence. The main components include:

- **Entity**: `Employee` class annotated with `@Entity` to define the data model.
- **Repository**: `EmployeeRepository` interface extending `JpaRepository` for CRUD operations.
- **Service**: `EmployeeService` class containing business logic and interacting with the repository.

### Configuration

- **application.properties**: Contains database and application configuration. Ensure your MySQL database is properly configured and accessible.

## Contributing

Feel free to open issues or submit pull requests. Contributions and feedback are welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
