# ExamControl System

## Overview
This project is a **university academic project** developed for learning purposes.  
The goal was to create a **web-based system** to manage exams, student data, and results using **Java Spring Boot** and an **Oracle database**.

The project demonstrates practical skills in:
- Java backend development with Spring Boot  
- Connecting and working with Oracle databases  
- Structuring a web application with Controllers, Services, Repositories, and Entities  
- Managing data persistence and database operations  

---

## Project Features
- User roles (admin, teacher, student) and authentication  
- Exam management: creation, editing, and scheduling  
- Automatic result tracking and database storage  
- Integration between Spring Boot backend and Oracle database  

---

## Technologies Used
- **Java 17**  
- **Spring Boot** (for backend development)  
- **Maven** (dependency management, pom.xml)  
- **Oracle Database Developer** (for storing all project data)  
- **SQL** (for table creation and database operations)  
- Git for version control  

---

## How This Project Works

### Backend with Spring Boot
1. **Application Entry Point:**  
   The main class is `LabkaApplication.java`. This class runs the Spring Boot application, initializes the context, and connects the backend to the Oracle database.

2. **Database Connection:**  
   - In the `pom.xml` file, the **Oracle JDBC library** was added to connect Spring Boot with Oracle Database.  
   - Configurations for the database connection are defined in `application.properties` (or `application.yml`), specifying:
     - Database URL
     - Username
     - Password
     - Driver class (`oracle.jdbc.OracleDriver`)  

3. **Entities and Repositories:**  
   - Each table in Oracle has a corresponding **Entity class** in Spring Boot.  
   - **Repositories** are interfaces that extend `JpaRepository` to perform CRUD operations.  
   - Example:
     ```java
     @Entity
     public class Student {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
         private String name;
         private String email;
     }
     
     public interface StudentRepository extends JpaRepository<Student, Long> { }
     ```

4. **Services:**  
   - Services contain business logic and call repositories to access data.  
   - Example:
     ```java
     @Service
     public class StudentService {
         @Autowired
         private StudentRepository studentRepository;
         
         public List<Student> getAllStudents() {
             return studentRepository.findAll();
         }
     }
     ```

5. **Controllers:**  
   - Controllers handle HTTP requests and map them to services.  
   - Example:
     ```java
     @RestController
     @RequestMapping("/students")
     public class StudentController {
         @Autowired
         private StudentService studentService;
         
         @GetMapping
         public List<Student> getStudents() {
             return studentService.getAllStudents();
         }
     }
     ```

### Oracle Database
- I created the database tables using **Oracle Developer SQL**.  
- All application data (students, exams, results) is stored in Oracle tables.  
- The application connects to Oracle DB using **JDBC driver** configured in `pom.xml`.  

### Spring Boot Configuration
- `application.properties` includes:
  ```properties
  spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true

### How to Run
## Clone the repository:

git clone https://github.com/damiribaidullaayev-web/project-with-springboot.git
cd project-with-springboot/Labka

### Build and run the Spring Boot backend:

./mvnw clean install
./mvnw spring-boot:run

