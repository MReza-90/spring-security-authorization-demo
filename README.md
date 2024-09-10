

# Spring Security Role-Based Access Control (RBAC) with BCrypt Authentication and Spring Data REST

## Project Overview

This project is a **Spring Boot** application built with **Java 21** that demonstrates how to implement role-based access control (RBAC) using **Spring Security**. Users are assigned specific roles, and access to REST API endpoints is determined by their authorities. **BCrypt** is used to securely store user passwords in the database. Additionally, **Spring Data REST** is used to expose RESTful APIs for managing entities.

## Features

- **Role-based Access Control (RBAC)**: Users are assigned roles, and their access to API endpoints is restricted based on their role and authorities.
- **BCrypt Password Hashing**: All user passwords are securely hashed using BCrypt before storing them in the database.
- **Spring Data REST**: Automatically generates RESTful APIs for repository entities, simplifying the creation and management of REST endpoints.
- **RESTful API**: Exposes a set of secured REST APIs with methods (GET, POST, PUT, DELETE) protected by role-based permissions.
- **Database Integration**: User data, including roles and authorities, are stored in a relational database (MySQL).

## Table of Contents

1. [Technologies Used](#technologies-used)
2. [Project Setup](#project-setup)
3. [Database Configuration](#database-configuration)
4. [Endpoints & Role-based Access](#endpoints-role-based-access)
5. [Security Configuration](#security-configuration)
6. [Password Encryption](#password-encryption)
7. [Spring Data REST Configuration](#spring-data-rest-configuration)
8. [Running Tests](#running-tests)
9. [Contributing](#contributing)
10. [License](#license)

---

## Technologies Used

- **Java 21**
- **Spring Boot 3.x**
- **Spring Security**
- **Spring Data JPA**
- **Spring Data REST**
- **BCrypt**
- **Maven**
- **H2/ MySQL/ PostgreSQL** (Use the one you prefer or configure it as needed)

## Project Setup

### Prerequisites

- **Java 21** installed
- **Maven** installed
- A relational database (e.g., **MySQL**, **PostgreSQL**, or **H2**)
- **IDE** (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/MReza-90/spring-security-authorization-demo.git
    cd spring-security-rbac-bcrypt
    ```

2. **Configure the database:**
   - Configure the database connection in the `application.properties` or `application.yml` file under the `src/main/resources` directory.
   - For example, for MySQL:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/mydb
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build the project:**
    ```bash
    mvn clean install
    ```

4. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

### Default User Accounts

You can pre-populate the database with default users and roles or create an initial user by seeding the database (if using H2, it may have sample data loading). Sample users can be inserted into the database with hashed passwords.

## Endpoints & Role-based Access

The application provides several RESTful API endpoints. Access to these endpoints is secured based on the user’s role.

### Example API Endpoints

- **Public Endpoints:**
   - `GET /api/employees`: Accessible to everyone.

- **User Endpoints:**
   - `GET /api/employees`: Accessible by users with `ROLE_EMPLOYEE` or `ROLE_ADMIN`.
   - `POST /api/employees`: Accessible by `ROLE_ADMIN` or `ROLE_MANAGER`.

- **Admin Endpoints:**
   - `DELETE /api/employees/{id}`: Accessible only by `ROLE_ADMIN`.

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add a new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Open a Pull Request


### Additional Resources

- [Spring Security Documentation](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)
- [Spring Data REST Documentation](https://docs.spring.io/spring-data/rest/docs/current/reference/html/)
- [BCrypt Password Hashing](https://en.wikipedia.org/wiki/Bcrypt)

