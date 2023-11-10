package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.Student;
import com.jeanjuste.springmid24229.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String createStudentForm(Model model) {
        Student student = new Student();
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("student", student);
        return "Student";
    }


    @PostMapping("/students/new")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

}
