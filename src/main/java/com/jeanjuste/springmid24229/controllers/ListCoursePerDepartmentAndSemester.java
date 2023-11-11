package com.jeanjuste.springmid24229.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListCoursePerDepartmentAndSemester {
    @GetMapping("/listCoursePerDepartmentAndSemester")
    public String getCoursePerDepartmentAndSemester(Model model){
        return "List";
    }
}
