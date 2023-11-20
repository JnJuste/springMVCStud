package com.jeanjuste.springmid24229.controllers;


import com.jeanjuste.springmid24229.models.AcademicUnit;
import com.jeanjuste.springmid24229.services.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AcademicUnitController {

    private AcademicUnitService academicUnitService;

    @Autowired
    public AcademicUnitController(AcademicUnitService academicUnitService) {
        this.academicUnitService = academicUnitService;
    }
    @GetMapping("/academicUnits")
    public String createAcademicUnitForm(Model model){
        AcademicUnit academicUnit = new AcademicUnit();
        List<AcademicUnit> academicUnits = academicUnitService.findAllAcademicUnits();
        model.addAttribute("academicUnits", academicUnits);
        model.addAttribute("academicUnit", academicUnit);
        return "AcademicUnit/AcademicUnit";
    }

    @PostMapping("/academicUnits/new")
    public String saveAcademicUnit(@ModelAttribute("academicUnit") AcademicUnit academicUnit) {
        academicUnitService.saveAcademicUnit(academicUnit);
        return "redirect:/academicUnits";
    }
}
