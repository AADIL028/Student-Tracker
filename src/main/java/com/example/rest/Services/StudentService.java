package com.example.rest.Services;

import com.example.rest.Entities.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student s);
    Student updateStudent(Student s,int id);
    List<Student> getAllStudent();
    void deleteStudent(int id);
    Student getStudentById(int id);
}
