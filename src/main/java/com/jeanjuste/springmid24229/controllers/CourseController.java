package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.*;
import com.jeanjuste.springmid24229.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {
    private CourseService courseService;
    private AcademicUnitService academicUnitService;
    private TeacherService teacherService;
    private CourseDefinitionService courseDefinitionService;
    private SemesterService semesterService;

    @Autowired
    public CourseController(CourseService courseService, AcademicUnitService academicUnitService,
                            TeacherService teacherService, SemesterService semesterService,
                            CourseDefinitionService courseDefinitionService) {
        this.courseService = courseService;
        this.academicUnitService = academicUnitService;
        this.teacherService = teacherService;
        this.semesterService = semesterService;
        this.courseDefinitionService = courseDefinitionService;
    }

    @GetMapping("/courses")
    public String createCourseForm(Model model) {
        Course course = new Course();
        List<Course> courses = courseService.findAllCourses();
        List<AcademicUnit> academicUnits = academicUnitService.findAllAcademicUnits();
        List<Teacher> teachers = teacherService.findAllTeachers();
        List<Semester> semesters = semesterService.findAllSemesters();
        List<CourseDefinition> courseDefinitions =courseDefinitionService.findAllCourseDefinitions();
        model.addAttribute("courses", courses);
        model.addAttribute("course", course);
        model.addAttribute("academicUnits", academicUnits);
        model.addAttribute("teachers", teachers);
        model.addAttribute("semesters", semesters);
        model.addAttribute("courseDefinitions", courseDefinitions);
        return "Course";
    }

    @PostMapping("/courses/new")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }
}
