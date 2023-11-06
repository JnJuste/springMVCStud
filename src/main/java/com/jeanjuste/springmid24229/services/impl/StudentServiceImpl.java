package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.Student;
import com.jeanjuste.springmid24229.repositories.StudentRepository;
import com.jeanjuste.springmid24229.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl (StudentRepository studentRepository){
        this.studentRepository = studentRepository;

    }
    @Override
    public List<Student> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
