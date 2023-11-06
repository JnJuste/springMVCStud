package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.StudentRegistration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentRegistrationService {
    List<StudentRegistration> findAllStudentRegistrations();
    StudentRegistration saveStudentRegistration(StudentRegistration studentRegistration);
}
