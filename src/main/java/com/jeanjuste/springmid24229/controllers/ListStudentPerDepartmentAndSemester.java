package com.jeanjuste.springmid24229.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListStudentPerDepartmentAndSemester {
    @GetMapping("/listStudentPerDepartmentAndSemester")
    public String getStudentPerDepartmentAndSemester(Model model){
        return "List";
    }
}
