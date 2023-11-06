package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.StudentCourse;
import com.jeanjuste.springmid24229.repositories.CourseRepository;
import com.jeanjuste.springmid24229.repositories.StudentCourseRepository;
import com.jeanjuste.springmid24229.repositories.StudentRegistrationRepository;
import com.jeanjuste.springmid24229.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    private StudentCourseRepository studentCourseRepository;
    private StudentRegistrationRepository studentRegistrationRepository;
    private CourseRepository courseRepository;

    @Autowired
    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository, CourseRepository courseRepository,
                                    StudentRegistrationRepository studentRegistrationRepository){
        this.studentCourseRepository = studentCourseRepository;
        this.courseRepository = courseRepository;
        this.studentRegistrationRepository = studentRegistrationRepository;
    }
    @Override
    public List<StudentCourse> findAllStudentCourses() {
        List<StudentCourse> studentCourses = studentCourseRepository.findAll();
        return studentCourses;
    }

    @Override
    public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }
}
