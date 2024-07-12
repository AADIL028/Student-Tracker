package com.example.rest.TestController;

import com.example.rest.Controllers.StudentController;
import com.example.rest.Entities.Student;
import com.example.rest.Entities.StudentGender;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;
    @Disabled
    @Test
    public void saveTest(){
        Student s = new Student();
        s.setStudentName("Aadil");
        s.setStudentGender(StudentGender.MALE);
        s.setStudentDOB(LocalDate.now());
        s.setStudentEmail("aadil@gmail.com");
        s.setStudentMobile("7080808080");
        studentController.saveStudent(s);
    }
    @Disabled
    @Test
    public void getTest(){
//        List<Student> allStudent = studentController.getALlStudent();
//        for(Student s : allStudent){
//            System.out.println(s);
//        }
    }
    @Disabled
    @Test
    public void updateTest(){
        Student s = new Student();
        s.setStudentId(1);
        s.setStudentName("Raman");
        s.setStudentGender(StudentGender.MALE);
        s.setStudentDOB(LocalDate.now());
        s.setStudentEmail("aadil@gmail.com");
        s.setStudentMobile("7080808080");

        studentController.updateStudent(s,1);
    }
    @Test
    public void deleteTest(){
        studentController.deleteStudent(1);
    }
}
