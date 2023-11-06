package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.Semester;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SemesterService {
    List<Semester> findAllSemesters();
    Semester saveSemester(Semester semester);
}
