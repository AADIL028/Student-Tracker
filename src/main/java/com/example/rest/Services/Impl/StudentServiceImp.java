package com.example.rest.Services.Impl;

import com.example.rest.Entities.Student;
import com.example.rest.Repositories.StudentRepository;
import com.example.rest.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student addStudent(Student s) {
        try {
            return studentRepository.save(s);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student updateStudent(Student sNew,int id) {
        try{
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
           Student sOld = optional.get();
           sOld.setStudentName(!sNew.getStudentName().equals(null) && !sNew.getStudentName().equals("") ? sNew.getStudentName():sOld.getStudentName());
           sOld.setStudentMobile(!sNew.getStudentMobile().equals(null) && !sNew.getStudentMobile().equals("") ? sNew.getStudentMobile():sOld.getStudentMobile());
           sOld.setStudentEmail(!sNew.getStudentEmail().equals(null) && !sNew.getStudentEmail().equals("") ? sNew.getStudentEmail():sOld.getStudentEmail());
           sOld.setStudentDOB(!sNew.getStudentDOB().equals(null)? sNew.getStudentDOB():sOld.getStudentDOB());
           sOld.setStudentGender(!sNew.getStudentGender().equals(null) && !sNew.getStudentGender().equals("") ? sNew.getStudentGender():sOld.getStudentGender());
           Student student = studentRepository.save(sOld);
           return student;
        }
        return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Student> getAllStudent() {
        try{
        Iterable<Student> iterable = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        iterable.forEach(studentList::add);
        return studentList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            Optional<Student> optional = studentRepository.findById(id);
            if(optional.isPresent()){
                Student student = optional.get();
                studentRepository.delete(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional!=null){
            return optional.get();
        }
        return null;
    }
}
