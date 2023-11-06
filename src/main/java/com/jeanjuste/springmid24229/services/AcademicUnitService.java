package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.AcademicUnit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcademicUnitService {
    List<AcademicUnit> findAllAcademicUnits();
    AcademicUnit saveAcademicUnit(AcademicUnit academicUnit);
}
