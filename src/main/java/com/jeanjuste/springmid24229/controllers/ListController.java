package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.*;
import com.jeanjuste.springmid24229.repositories.CourseRepository;
import com.jeanjuste.springmid24229.repositories.StudentCourseRepository;
import com.jeanjuste.springmid24229.repositories.StudentRegistrationRepository;
import com.jeanjuste.springmid24229.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;
@Controller
//@RequestMapping("/lists")
public class ListController {

    private final StudentCourseRepository studentCourseRepository;
    private final CourseRepository courseRepository;
    private final StudentRegistrationRepository studentRegistrationRepository;

    @Autowired
    public ListController( StudentRegistrationRepository studentRegistrationRepository, CourseRepository courseRepository,
                           StudentCourseRepository studentCourseRepository) {
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.studentRegistrationRepository = studentRegistrationRepository;
    }
    @GetMapping("/listCoursePerStudent")
    public String allLists(Model model) {
        UUID course_ID = UUID.fromString("courseId");
        UUID studentId = UUID.fromString("stud_id");
        UUID departmentId = UUID.fromString("dep_id");
        UUID semesterId = UUID.fromString("semId");
        UUID departAccID = UUID.fromString("accId");

        List<Object[]> listOfStudentsByCourse = studentCourseRepository.getStudentsByCourse(course_ID);
        List<Object[]> listOfCoursesByStudent = studentCourseRepository.getCoursesByStudent(studentId);
        List<Object[]> listOfCoursesByDepartment = courseRepository.getCoursesByDepartment(departmentId);
        List<Object[]> listOfStudentsBySemester = studentRegistrationRepository.getStudentsBySemester(semesterId);
        List<Object[]> listOfStudentsByDepartment = studentRegistrationRepository.getStudentsByDepartment(departAccID);

        model.addAttribute("listOfStudentsByCourse", listOfStudentsByCourse);
        model.addAttribute("listOfCoursesByStudent", listOfCoursesByStudent);
        model.addAttribute("listOfCoursesByDepartment", listOfCoursesByDepartment);
        model.addAttribute("listOfStudentsBySemester", listOfStudentsBySemester);
        model.addAttribute("listOfStudentsByDepartment", listOfStudentsByDepartment);

        return "listCoursePerStudent";
    }

    @GetMapping("/listStudentPerSemester")
    public String getStudentPerSemester(Model model){
        return null;
    }

    @GetMapping("/listStudentPerCourseAndSemester")
    public String getStudentPerCourseAndSemester(Model model){
        return null;
    }

    @GetMapping("/listStudentPerDepartmentAndSemester")
    public String getStudentPerDepartmentAndSemester(Model model){
        return null;
    }

    @GetMapping("/listCoursePerDepartmentAndSemester")
    public String getCoursePerDepartmentAndSemester(Model model){
        return null;
    }
}
