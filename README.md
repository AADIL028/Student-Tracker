# Student Tracker

This is a CRUD (Create, Read, Update, Delete) application for managing student records. The application is built using Spring Boot, Hibernate, Thymeleaf, and MySQL.

## Features

- Add new students
- View a list of all students
- Update student information
- Delete student records

## Technologies Used

- Spring Boot
- Hibernate
- Thymeleaf
- MySQL

## Usage

### View All Students

1. Navigate to `http://localhost:8080/student/all`

### Add a New Student

1. Navigate to `http://localhost:8080/student/all`
2. Click the "Add Student" button to open add student form
3. Fill in the student details and submit the form


### Update Student Information

1. Navigate to `http://localhost:8080/student/all`
2. Click the "Update" button next to the student you want to update
3. Update the student details and submit the form

### Delete Student Records

1. Navigate to `http://localhost:8080/student/all`
2. Click the "Delete" button next to the student you want to delete

## Rest-Api End Points
1. View Students :- `http://localhost:8080/student`(Get Request)
2. Add Student :- `http://localhost:8080/student`(Post Request)
3. Update Student :- `http://localhost:8080/student/update/{id}`(Put Request)
4. Delete Student :- `http://localhost:8080/student/delete/{id}`(Delete Request)
