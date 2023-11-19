package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StudentService {
    List<Student> findAllStudents();
    Student saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(UUID studId);
}
