package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.*;
import com.jeanjuste.springmid24229.repositories.CourseRepository;
import com.jeanjuste.springmid24229.repositories.StudentCourseRepository;
import com.jeanjuste.springmid24229.repositories.StudentRegistrationRepository;
import com.jeanjuste.springmid24229.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Controller
//@RequestMapping("/lists")
public class ListController {

    private final StudentCourseRepository studentCourseRepository;
    private final CourseRepository courseRepository;
    private final StudentRegistrationRepository studentRegistrationRepository;
    private final SemesterService semesterService;
    private final AcademicUnitService academicUnitService;
    private final CourseService courseService;

    @Autowired
    public ListController( StudentRegistrationRepository studentRegistrationRepository, CourseRepository courseRepository,
                           StudentCourseRepository studentCourseRepository, SemesterService semesterService,
                           CourseService courseService, AcademicUnitService academicUnitService) {
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.studentRegistrationRepository = studentRegistrationRepository;
        this.courseService = courseService;
        this.academicUnitService = academicUnitService;
        this.semesterService = semesterService;
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

    @GetMapping("/listCoursesPerDepartment")
    public String coursesByDepartmentForm(Model model) {
        List<AcademicUnit> academicUnitList = academicUnitService.findAllAcademicUnits();
        model.addAttribute("academicUnitList", academicUnitList);

        return "/listCoursesPerDepartment";
    }

    @PostMapping("/{depId}/listOfCoursesByDepartment")
    public String listOfCoursesByDepartmentForm(@PathVariable("depId") UUID depId, Model model) {
        List<Object[]> listOfCoursesByDepartment = courseRepository.getCoursesByDepartment(depId);
        List<AcademicUnit> academicUnitList = academicUnitService.findAllAcademicUnits();

        model.addAttribute("academicUnitList", academicUnitList);
        model.addAttribute("listOfCoursesByDepartment", listOfCoursesByDepartment);

        return "/listCoursesPerDepartment";
    }
}
