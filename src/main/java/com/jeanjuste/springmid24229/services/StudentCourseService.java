package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.StudentCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCourseService {
    List<StudentCourse> findAllStudentCourses();
    StudentCourse saveStudentCourse(StudentCourse studentCourse);
}
