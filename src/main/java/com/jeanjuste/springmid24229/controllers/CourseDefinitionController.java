package com.jeanjuste.springmid24229.controllers;


import com.jeanjuste.springmid24229.models.CourseDefinition;
import com.jeanjuste.springmid24229.services.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseDefinitionController {
    private CourseDefinitionService courseDefinitionService;

    @Autowired
    public CourseDefinitionController(CourseDefinitionService courseDefinitionService) {
        this.courseDefinitionService = courseDefinitionService;
    }

    @GetMapping("/courseDefinitions")
    public String createCourseDefinitionForm(Model model){
        CourseDefinition courseDefinition = new CourseDefinition();
        List<CourseDefinition> courseDefinitions = courseDefinitionService.findAllCourseDefinitions();
        model.addAttribute("courseDefinitions", courseDefinitions);
        model.addAttribute("courseDefinition", courseDefinition);
        return "CourseDefinition/CourseDefinition";
    }

    @PostMapping("/courseDefinitions/new")
    public String saveCourseDefinition(@ModelAttribute("courseDefinition") CourseDefinition courseDefinition) {
        courseDefinitionService.saveCourseDefinition(courseDefinition);
        return "redirect:/courseDefinitions";
    }
}
