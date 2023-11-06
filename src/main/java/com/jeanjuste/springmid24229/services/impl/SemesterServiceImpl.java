package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.Semester;
import com.jeanjuste.springmid24229.repositories.SemesterRepository;
import com.jeanjuste.springmid24229.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterServiceImpl implements SemesterService {
    private SemesterRepository semesterRepository;

    @Autowired
    public SemesterServiceImpl (SemesterRepository semesterRepository){
        this.semesterRepository = semesterRepository;
    }
    @Override
    public List<Semester> findAllSemesters() {
        List<Semester> semesters = semesterRepository.findAll();
        return semesters;
    }

    @Override
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }
}
