package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.Semester;
import com.jeanjuste.springmid24229.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SemesterController {

    private SemesterService semesterService;

    @Autowired
    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }
    @GetMapping("/semesters")
    public String createSemesterForm(Model model){
        Semester semester = new Semester();
        List<Semester> semesters = semesterService.findAllSemesters();
        model.addAttribute("semesters", semesters);
        model.addAttribute("semester", semester);
        return "Semester";
    }

    @PostMapping("/semesters/new")
    public String saveSemester(@ModelAttribute("semester") Semester semester) {
        semesterService.saveSemester(semester);
        return "redirect:/semesters";
    }
}
