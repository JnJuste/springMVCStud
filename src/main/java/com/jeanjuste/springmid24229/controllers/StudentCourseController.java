package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.StudentCourse;
import com.jeanjuste.springmid24229.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentCourseController {
    private StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("/studentCourses")
    public String createStudentCourseForm(Model model){
        StudentCourse studentCourse = new StudentCourse();
        List<StudentCourse> studentCourses = studentCourseService.findAllStudentCourses();
        model.addAttribute("studentCourses", studentCourses);
        model.addAttribute("studentCourse", studentCourse);
        return "StudentCourse";
    }

    @PostMapping("/studentCourses/new")
    public String saveStudentCourse(@ModelAttribute("studentCourse") StudentCourse studentCourse) {
        studentCourseService.saveStudentCourse(studentCourse);
        return "redirect:/studentCourses";
    }
}
