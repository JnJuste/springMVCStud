package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.AcademicUnit;
import com.jeanjuste.springmid24229.repositories.AcademicUnitRepository;
import com.jeanjuste.springmid24229.services.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicUnitServiceImpl implements AcademicUnitService {
    private AcademicUnitRepository academicUnitRepository;

    @Autowired
    public AcademicUnitServiceImpl (AcademicUnitRepository academicUnitRepository){
        this.academicUnitRepository = academicUnitRepository;

    }
    @Override
    public List<AcademicUnit> findAllAcademicUnits() {
        List<AcademicUnit> academicUnits = academicUnitRepository.findAll();
       return academicUnits;
    }

    @Override
    public AcademicUnit saveAcademicUnit(AcademicUnit academicUnit) {
        return academicUnitRepository.save(academicUnit);
    }
}
