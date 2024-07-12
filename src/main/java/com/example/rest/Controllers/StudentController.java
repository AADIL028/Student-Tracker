package com.example.rest.Controllers;

import com.example.rest.Entities.Student;
import com.example.rest.Services.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Rest-Api end-points....
    @GetMapping
    public ResponseEntity<?> getALlStudent(Model model){
        List<Student> allStudent = studentService.getAllStudent();
        model.addAttribute("students",allStudent);
        return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student std){
        Student saved = studentService.addStudent(std);
        if(saved!=null){
        return new ResponseEntity<>(saved,HttpStatus.OK);
        }
        return new ResponseEntity<>("Some error occur.... ",HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable int id){
        Student updated = studentService.updateStudent(student,id);
        if(updated!=null){
            return new ResponseEntity<>(updated,HttpStatus.OK);
        }
        return new ResponseEntity<>("Some error occured..",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }


    @GetMapping("/all")
    public ModelAndView getALlStudents(Model model){
        List<Student> allStudent = studentService.getAllStudent();
        model.addAttribute("students",allStudent);
        return new ModelAndView("index");
    }
    @GetMapping("/add")
    public ModelAndView addStudent(){
        return new ModelAndView("add");
    }
    @PostMapping("/save")
    public RedirectView saveStudentForm(@ModelAttribute Student std, HttpServletRequest httpServletRequest){
        Student saved = studentService.addStudent(std);
        if(saved!=null){
            return new RedirectView(httpServletRequest.getContextPath()+"all");
        }
        return new RedirectView(httpServletRequest.getContextPath()+"add");
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable int id,Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return new ModelAndView("update");
    }
    // put mapping not supported in html form.So, here post is used.
    @PostMapping("/update")
    public RedirectView updateStudent(@ModelAttribute Student std, HttpServletRequest httpServletRequest){
        Student saved = studentService.updateStudent(std, std.getStudentId());
        if(saved!=null){
            return new RedirectView(httpServletRequest.getContextPath()+"all");
        }
        return new RedirectView(httpServletRequest.getContextPath()+"update/"+std.getStudentId());
    }

    // delete mapping not supported in html form.So, here get is used.
    @GetMapping("delete/{id}")
    public RedirectView deleteStudentPost(@PathVariable int id,HttpServletRequest httpServletRequest){
        studentService.deleteStudent(id);
        return new RedirectView(httpServletRequest.getContextPath()+"/student/all");
    }
}
