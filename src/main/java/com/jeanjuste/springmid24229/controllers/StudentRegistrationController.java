package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.*;
import com.jeanjuste.springmid24229.services.AcademicUnitService;
import com.jeanjuste.springmid24229.services.SemesterService;
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
public class StudentRegistrationController {
    private StudentRegistrationService studentRegistrationService;
    private SemesterService semesterService;
    private AcademicUnitService academicUnitService;
    private StudentService studentService;

    @Autowired
    public StudentRegistrationController(StudentRegistrationService studentRegistrationService, SemesterService semesterService,
                                         AcademicUnitService academicUnitService, StudentService studentService) {
        this.studentRegistrationService = studentRegistrationService;
        this.semesterService = semesterService;
        this.academicUnitService = academicUnitService;
        this.studentService = studentService;
    }
    @GetMapping("/studentRegistrations")
    public String createStudentRegistrationForm(Model model){
        StudentRegistration studentRegistration = new StudentRegistration();
        List<StudentRegistration> studentRegistrations = studentRegistrationService.findAllStudentRegistrations();
        List<Semester> semesters = semesterService.findAllSemesters();
        List<Student> studentList = studentService.findAllStudents();
        List<AcademicUnit> academicUnits = academicUnitService.findAllAcademicUnits();
        model.addAttribute("studentRegistrations", studentRegistrations);
        model.addAttribute("studentRegistration", studentRegistration);
        model.addAttribute("semesters", semesters);
        model.addAttribute("studentList", studentList);
        model.addAttribute("academicUnits", academicUnits);
        return "StudentRegistration/StudentRegistration";
    }

    @PostMapping("/studentRegistrations/new")
    public String saveStudentRegistration(@ModelAttribute("studentRegistration") StudentRegistration studentRegistration) {
        studentRegistrationService.saveStudentRegistration(studentRegistration);
        studentRegistration.setERegistrationStatus(ERegistrationStatus.REJECTED);
        studentRegistration.setERegistrationStatus(ERegistrationStatus.ADMITTED);
        studentRegistration.setERegistrationStatus(ERegistrationStatus.PENDING);
        return "redirect:/studentRegistrations";
    }
}
