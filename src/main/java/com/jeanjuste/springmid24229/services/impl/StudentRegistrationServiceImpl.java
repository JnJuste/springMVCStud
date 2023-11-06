package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.StudentRegistration;
import com.jeanjuste.springmid24229.repositories.AcademicUnitRepository;
import com.jeanjuste.springmid24229.repositories.SemesterRepository;
import com.jeanjuste.springmid24229.repositories.StudentRegistrationRepository;
import com.jeanjuste.springmid24229.repositories.StudentRepository;
import com.jeanjuste.springmid24229.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
    private StudentRegistrationRepository studentRegistrationRepository;
    private SemesterRepository semesterRepository;
    private AcademicUnitRepository academicUnitRepository;
    private StudentRepository studentRepository;

    @Autowired
    public StudentRegistrationServiceImpl (StudentRegistrationRepository studentRegistrationRepository,StudentRepository studentRepository,
                                           SemesterRepository semesterRepository, AcademicUnitRepository academicUnitRepository){
        this.studentRegistrationRepository = studentRegistrationRepository;
        this.studentRepository = studentRepository;
        this.academicUnitRepository = academicUnitRepository;
        this.semesterRepository = semesterRepository;
    }
    @Override
    public List<StudentRegistration> findAllStudentRegistrations() {
        List<StudentRegistration> studentRegistrations = studentRegistrationRepository.findAll();
        return studentRegistrations;
    }

    @Override
    public StudentRegistration saveStudentRegistration(StudentRegistration studentRegistration) {
        return studentRegistrationRepository.save(studentRegistration);
    }

}
