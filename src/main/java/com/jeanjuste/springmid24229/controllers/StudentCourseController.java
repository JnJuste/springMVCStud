package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.Course;
import com.jeanjuste.springmid24229.models.StudentCourse;
import com.jeanjuste.springmid24229.models.StudentRegistration;
import com.jeanjuste.springmid24229.services.CourseService;
import com.jeanjuste.springmid24229.services.StudentCourseService;
import com.jeanjuste.springmid24229.services.StudentRegistrationService;
import com.jeanjuste.springmid24229.services.StudentService;
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
    private CourseService courseService;
    private StudentRegistrationService studentRegistrationService;


    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService, CourseService courseService,
                                   StudentRegistrationService studentRegistrationService) {
        this.studentCourseService = studentCourseService;
        this.studentRegistrationService = studentRegistrationService;
        this.courseService = courseService;
    }

    @GetMapping("/studentCourses")
    public String createStudentCourseForm(Model model){
        StudentCourse studentCourse = new StudentCourse();
        List<StudentCourse> studentCourses = studentCourseService.findAllStudentCourses();
        List<StudentRegistration> studentRegistrations = studentRegistrationService.findAllStudentRegistrations();
        List<Course> courses = courseService.findAllCourses();
        model.addAttribute("studentCourses", studentCourses);
        model.addAttribute("studentCourse", studentCourse);
        model.addAttribute("studentRegistrations", studentRegistrations);
        model.addAttribute("courses", courses);
        return "StudentCourse";
    }

    @PostMapping("/studentCourses/new")
    public String saveStudentCourse(@ModelAttribute("studentCourse") StudentCourse studentCourse) {
        studentCourseService.saveStudentCourse(studentCourse);
        return "redirect:/studentCourses";
    }
}
